package com.example.validate_form_register.model;

import com.example.validate_form_register.utils.annotation.RegexEmailConstraint;
import com.example.validate_form_register.utils.annotation.RegexPhoneNumberConstraint;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity(name = "register_model")
public class Register {

    //Firstname, lastname bắt buộc, có độ dài tối thiểu 5, tối đa 45 ký tự
    //
    //Phonenumber đúng quy tắc của sđt
    //
    //Age >=18
    //
    //Email đúng quy tắc của email

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Họ không được trống")
    @Size(min = 5, max = 45, message = "Họ tối thiểu 4 và tối đa 45 kí tự")
    @Column(name = "first_name")
    private String firstName;
    @NotBlank(message = "Tên không được trống")
    @Size(min = 5, max = 45, message = "Tên tối thiểu 4 và tối đa 45 kí tự")
    @Column(name = "last_name")
    private String lastName;

    @RegexPhoneNumberConstraint(message = "Không đúng định dạng điện thoại. vd: 09,08,07,84")
    @Column(name = "phone_number")
    private String phoneNumber;

    @Min(value = 18, message = "Phải từ 18 tuổi trở lên")
    @NotNull(message = "Chưa nhập tuổi")
    private Integer age;

    @RegexEmailConstraint(message = "Không đúng định dạng email. vd: hoang@gmail.com")
    private String email;

    public Register() {
    }

    public Register(Integer id, String firstName, String lastName, String phoneNumber, Integer age, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
