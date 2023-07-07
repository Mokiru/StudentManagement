package com.example.data.service;

import com.example.data.domain.CustomerDetails;
import com.example.data.repository.CustomerDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class CustomerDetailsService {

    @Autowired
    CustomerDetailsRepository cdr;

    public void save(CustomerDetails cd) {
        cdr.save(cd);
    }

    public CustomerDetails findByCustomerId(Long id) {
        return cdr.findByCustomerId(id);
    }

    public void UpdateByCustomerId(CustomerDetails cd) {
        String realname = cd.getRealname();
        String sex = cd.getSex();
        LocalDate birthdate = cd.getBirthdate();
        String location = cd.getLocation();
        Long id = cd.getCustomerId();
        cdr.updateByCustomerId(realname, sex, birthdate, location, id);
    }
}
