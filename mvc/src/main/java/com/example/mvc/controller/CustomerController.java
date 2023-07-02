package com.example.mvc.controller;

import com.example.mvc.domain.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;

@Controller

@RequestMapping("/customer")

public class CustomerController {

    @GetMapping("/sign/up")
    public String signUppage() {
        return "signUp";
    }

    @PostMapping("/sign/up")
    public String signUpAction(Customer customer, RequestAttribute attr) {
        String username = customer.getUsername();
        String password = customer.getPassword();
        String realname = customer.getRealname();
        String sex = customer.getSex();
        LocalDate busi = customer.getBusiExpireDate();
        String location = customer.getLocation();
        String [] like = customer.getLike();
        System.out.println(busi);
        return "index";
    }
}
