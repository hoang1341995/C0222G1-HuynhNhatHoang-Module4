package com.example.case_study_module4.service.contract.contract_impl;

import com.example.case_study_module4.model.contract.Contract;
import com.example.case_study_module4.model.contract.ContractDetail;
import com.example.case_study_module4.model.dto.contract_dto.ContractDto;
import com.example.case_study_module4.repository.contract.IContractRepository;
import com.example.case_study_module4.service.contract.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

@Service
public class ContractService implements IContractService {

    @Autowired
    private IContractRepository iContractRepository;

    @Override
    public Page<ContractDto> findAll(Pageable pageable) {
        List<ContractDto> contractDtoList =  convertContractToContracDto(iContractRepository.findAll(pageable));
//        return iContractRepository.findAll(pageable);
       return new PageImpl<>(contractDtoList, pageable, 100);
    }

    @Override
    public List<ContractDto> findAllList(Pageable pageable) {
        List<ContractDto> contractDtoList =  convertContractToContracDto(iContractRepository.findAll(pageable));
        return contractDtoList;
    }

    @Override
    public void save(Contract contract) {
        iContractRepository.save(contract);
    }

    @Override
    public void delete(Contract contract) {
        iContractRepository.delete(contract);
    }

    @Override
    public Contract findById(Integer id) {
//        return iContractRepository.findById(id);
        return null;
    }


    public static List<ContractDto> convertContractToContracDto(Page<Contract> contracts){
        ContractDto contractDto;
        List<ContractDto> contractDtoPage = new ArrayList<>();
        for (Contract contract : contracts) {
            contractDto = new ContractDto();
            contractDto.setContractId(contract.getContractId());
            contractDto.setStartDate(contract.getStartDate());
            contractDto.setEndDate(contract.getEndDate());
            contractDto.setDeposit(contract.getDeposit());
            contractDto.setEmployee(contract.getEmployee());
            contractDto.setCustomer(contract.getCustomer());
            contractDto.setService(contract.getService());
            System.out.println(contract.getService().getServiceCost());
            Double serviceCostAndNumberOfDays = contract.getService().getServiceCost() * endDateMinusStartDate(contract.getStartDate(), contract.getEndDate());
            Double quantityAndAttach = 0.0;
            for (ContractDetail contractDetail : contract.getContractDetailList()) {
                quantityAndAttach += contractDetail.getQuantity() * contractDetail.getAttachService().getAttachServiceCost();
            }
            contractDto.setTotalCost((serviceCostAndNumberOfDays - Double.parseDouble(contract.getDeposit())) + quantityAndAttach);
            contractDtoPage.add(contractDto);
        }

        return contractDtoPage;
    }

    public static int endDateMinusStartDate(String startDate, String endDate){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("uuuu-MM-dd").withResolverStyle(ResolverStyle.STRICT);
        LocalDate startDateLocalDate = LocalDate.parse(startDate, formatter);
        LocalDate endDateLocalDate = LocalDate.parse(endDate, formatter);
        LocalDate startDates = LocalDate.of(startDateLocalDate.getYear(), startDateLocalDate.getMonth(), startDateLocalDate.getDayOfMonth());
        LocalDate endDates = LocalDate.of(endDateLocalDate.getYear(), endDateLocalDate.getMonth(), endDateLocalDate.getDayOfMonth());
        return  (int) ChronoUnit.DAYS.between(startDates, endDates);
    }


}
