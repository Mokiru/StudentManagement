package com.example.data.service;

import com.example.data.domain.CustomerDetails;
import com.example.data.repository.CustomerDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerDetailsService {

    @Autowired
    CustomerDetailsRepository cdr;

    public void save(CustomerDetails cd) {
        cdr.save(cd);
    }

}
