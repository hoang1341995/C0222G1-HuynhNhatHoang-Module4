package com.example.case_study_module4.controller;

import com.example.case_study_module4.model.contract.Contract;
import com.example.case_study_module4.model.contract.ContractDetail;
import com.example.case_study_module4.model.customer.Customer;
import com.example.case_study_module4.model.dto.contract_dto.ContractDto;
import com.example.case_study_module4.model.employee.Employee;
import com.example.case_study_module4.model.service.Service;
import com.example.case_study_module4.service.contract.IAttachServiceService;
import com.example.case_study_module4.service.contract.IContractDetailService;
import com.example.case_study_module4.service.contract.IContractService;
import com.example.case_study_module4.service.customer.ICustomerService;
import com.example.case_study_module4.service.service.IServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/contract")
public class ContractController {

    @Autowired
    private IContractService iContractService;

    @Autowired
    private IContractDetailService iContractDetailService;

    @Autowired
    private IAttachServiceService iAttachServiceService;

    @Autowired
    private IServiceService iServiceService;

    @Autowired
    private ICustomerService iCustomerService;

    @GetMapping(value = "")
    public String showIndex(@PageableDefault(value = 100) Pageable pageable, Model model) {
        Page<ContractDto> list = iContractService.findAll(pageable);
        model.addAttribute("contracDtotList", list);
        model.addAttribute("contractDetailList", iContractDetailService.findAll());
        model.addAttribute("attachServiceList", iAttachServiceService.findAll());
        model.addAttribute("serviceList", iServiceService.findAll());
        model.addAttribute("customerList", iCustomerService.findAll());
        return "contract/index-contract";
    }

    @PostMapping(value = "/create")
    public ResponseEntity<?> createContract(@RequestBody Contract contract,@PageableDefault(value = 10) Pageable pageable) {
        iContractService.save(contract);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(value = "/attach-service-in")
    public ResponseEntity<?> AttachServiceInOut(@PageableDefault(value = 100) Pageable pageable,@RequestBody ContractDetail contractDetail) {
        iContractDetailService.save(contractDetail);
        List<ContractDetail> list = iContractDetailService.findAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping(value = "/detail-of-contract/{id}")
    public ResponseEntity<?> detailOfContract(@PathVariable Integer id) {
        List<ContractDetail> list = iContractDetailService.findByIdContract(id);
        if (!list.isEmpty()){
            return new ResponseEntity<>(list, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/get-service-by-id/{id}")
    public ResponseEntity<?> getServiceById(@PathVariable Integer id) {
        Optional<Service> list = iServiceService.findById(id);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }


    //API---
    @GetMapping(value = "/getListContract")
    public ResponseEntity<?> getListContract(@PageableDefault(value = 100) Pageable pageable) {
        List<ContractDto> list = iContractService.findAllList(pageable);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }


    @GetMapping(value = "/getListContractDetail")
    public ResponseEntity<?> getListContractDetail() {
        List<ContractDetail> list = iContractDetailService.findAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    
}
