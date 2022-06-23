package com.example.validate_form_register.service.impl;


import com.example.validate_form_register.model.Register;
import com.example.validate_form_register.repository.IRegisterRepository;
import com.example.validate_form_register.service.IRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class RegisterService implements IRegisterService {

    @Autowired
    private IRegisterRepository iRegisterRepository;

    @Override
    public Page<Register> findAll(Pageable pageable) {
        return iRegisterRepository.findAll(pageable);
    }

    @Override
    public void save(Register register) {
        iRegisterRepository.save(register.getFirstName(), register.getLastName(), register.getPhoneNumber(), register.getAge(), register.getEmail());
    }
}
