package com.example.data.tests;

import com.example.data.domain.Customer;
import com.example.data.domain.CustomerDetails;
import com.example.data.repository.CustomerDetailsRepository;
import com.example.data.repository.CustomerRepository;
import com.example.data.service.CustomerDetailsService;
import com.example.data.service.CustomerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Optional;

@SpringBootTest
public class CustomerRepositoryTests {

    @Autowired
    CustomerRepository repository;

    @Autowired
    CustomerService service;

    @Autowired
    CustomerDetailsService cds;

    @Autowired
    CustomerDetailsRepository cdr;

    @Test
    public void testSave() {
        Customer c = new Customer();
        CustomerDetails cd = new CustomerDetails();
        c.setUsername("zsssda");
        c.setPassword("hello");
        service.save(c);
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

    @Test
    public void findUsernameByUsername() {
        System.out.println(repository.findUsernameByUsername("qweqwqqw") != null);
    }

    @Test
    public void findByCutomerId() {
        CustomerDetails cd = cds.findByCustomerId(9L);
        System.out.println( cd );
    }

    @Test
    public void updateCustomerDetailsByCustomerId() {
        CustomerDetails cd = new CustomerDetails();
        cd.setCustomerId(9L);
        String realname = "123";
        String sex = "123";
        LocalDate birthdate = LocalDate.now();
        String location = "123";
        String like = "[Bike, Car]";
        cd.setRealname(realname);
        cd.setSex(sex);
        cd.setLocation(location);
        cd.setBirthdate(birthdate);
        cdr.updateByCustomerId(realname, sex, birthdate, location, 9L);
    }
}
