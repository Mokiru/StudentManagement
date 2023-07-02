package com.example.mvc.controller;

import com.example.mvc.domain.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

@RequestMapping("/customer")

public class CustomerController {

    @GetMapping("/sign/up")
    public String signUppage() {
        return "signUp";
    }

    @PostMapping("/sign/up")
    public String signUpAction(Customer customer, RequestAttribute attr) {
        System.out.println(customer.getPassword());


        return "index";
    }
}
