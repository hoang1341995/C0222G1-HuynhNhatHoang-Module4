package com.example.validate_form_register.service;

import com.example.validate_form_register.model.Register;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface IRegisterService {

    Page<Register> findAll(Pageable pageable);

    void save(Register register);

}
