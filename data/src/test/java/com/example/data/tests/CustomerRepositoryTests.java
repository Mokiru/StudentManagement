package com.example.data.tests;

import com.example.data.domain.Customer;
import com.example.data.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
    public void findById() {

        Optional<Customer> c = repository.findById(1L);

        System.out.println( c );

    }

    @Test
    public void deleteById() {

        repository.deleteById(1L);

    }

    @Test
    public void updatePasswordById() {

        repository.updatePasswordById("1234", 2L);

    }

    @Test
    public void findByUsername() {

        Customer c = repository.findByUsername( "zhangtingyu" );
        System.out.println( c );

    }
}
