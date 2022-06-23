package com.example.validate_form_register.repository;

import com.example.validate_form_register.model.Register;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

@Transactional
public interface IRegisterRepository extends PagingAndSortingRepository<Register, Integer> {

    @Query(value = "select * from register_model", nativeQuery = true)
    Page<Register> findAll(Pageable pageable);

    @Modifying
    @Query(value = "INSERT INTO register_model (first_name, last_name, phone_number, age, email) VALUES (:firstName, :lastName, :phoneNumber, :age, :email)",
            nativeQuery = true)
    void save(@Param("firstName") String firstName,
              @Param("lastName") String lastName,
              @Param("phoneNumber") String phoneNumber,
              @Param("age") Integer age,
              @Param("email") String email);
}
