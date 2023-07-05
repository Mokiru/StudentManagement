package com.example.data.tests;

import com.example.data.domain.Customer;
import com.example.data.domain.CustomerDetails;
import com.example.data.repository.CustomerRepository;
import com.example.data.service.CustomerDetailsService;
import com.example.data.service.CustomerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class CustomerRepositoryTests {

    @Autowired
    CustomerRepository repository;

    @Autowired
    CustomerService service;

    @Autowired
    CustomerDetailsService cds;

    @Test
    public void testSave() {
        Customer c = new Customer();
        CustomerDetails cd = new CustomerDetails();
        c.setUsername("zsssda");
        c.setPassword("hello");
        String [] h = {"123", "32"};
        cd.setLike(h);
        service.save(c);
        cd.setCustomerId(c.getId());
        cds.save(cd);
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
