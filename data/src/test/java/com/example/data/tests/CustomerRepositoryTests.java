package com.example.data.tests;

import com.example.data.domain.Customer;
import com.example.data.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jdbc.repository.query.Query;

import java.util.Optional;

@SpringBootTest
public class CustomerRepositoryTests {

    @Autowired
    CustomerRepository repository;

    @Test
    public void testSave() {
        Customer c = new Customer();

        c.setUsername("zhangtingyu");
        c.setPassword("hello");

        repository.save(c);
    }

    @Test
    public void findById(Long id) {

        Optional<Customer> c = repository.findById(1L);

        System.out.println( c );

    }
}
