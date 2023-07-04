package com.example.data.service;

import com.example.data.domain.Customer;
import com.example.data.repository.CustomerRepository;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.commons.lang3.RandomStringUtils;

import java.security.DigestException;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository repository;

    public void save(Customer c) {
        String pwd = c.getPassword();
        String salt = RandomStringUtils.randomAlphabetic(8);
        c.setSalt(salt);

        String en = encrypt(pwd, salt);

        c.setPassword(en);

        repository.save(c);
    }

    public Customer findByUsername(String username) {
        return repository.findByUsername(username);
    }

    public String encrypt(String pwd, String salt) {
        String en = DigestUtils.sha1Hex(pwd);
        StringBuilder s = new StringBuilder(en);
        s.insert(20, salt);
        en = DigestUtils.sha1Hex(s.toString());
        return en;
    }

}
