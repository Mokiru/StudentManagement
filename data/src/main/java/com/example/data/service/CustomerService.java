package com.example.data.service;

import com.example.data.domain.Customer;
import com.example.data.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository repository;

    public List<Customer> findAll() {
        var it = repository.findAll();
        var customers = new ArrayList<Customer>();
        it.forEach(e -> customers.add(e));
        return customers;
    }

}
