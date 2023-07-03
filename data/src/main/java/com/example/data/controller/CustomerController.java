package com.example.data.controller;

import com.example.data.domain.Customer;
import com.example.data.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService service;

    @GetMapping("/customers")
    public List<Customer> allCustomers() {
        return service.findAll();
    }

    @DeleteMapping("/customers/{id}")
    public void delete(@PathVariable String id) {
        Long customerid = Long.parseLong(id);
        service.deleteById(customerid);
    }

}
