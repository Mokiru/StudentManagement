package com.example.data.tests;

import com.example.data.domain.Car;
import com.example.data.domain.Customer;
import com.example.data.domain.CustomerDetails;
import com.example.data.repository.CarRepository;
import com.example.data.repository.CustomerDetailsRepository;
import com.example.data.repository.CustomerRepository;
import com.example.data.service.CarService;
import com.example.data.service.CustomerDetailsService;
import com.example.data.service.CustomerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
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

    @Autowired
    CarRepository cr; // 汽车

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

    @Test
    public void findByCarClass() {
        List<Car> c = cr.findByCarClass("%" + "e" + "%");
        System.out.println( c.size() );
        List<Car> b = cr.findByCarType("%" + "e" + "%");
        System.out.println( b.size() );
    }
    @Autowired
    CarService cs;

    @Test
    public void findByCarClassService() {
        List<Car> c = cs.findByCarClass("e");
        System.out.println( c.size() );
    }

    @Test
    public void filePath() {
        try {
            String projectPath = System.getProperty("user.dir");					//获取当前eclipse工程路径
            String classPath = this.getClass().getResource("/").toString();			//获取当前classPath
//			String classPath = this.getClass().getClassLoader().getResource("");	//获取当前classPath等同上一行代码
            String classFullPath = this.getClass().getResource("").toString();		//获取当前类基于classPath的完整路径

           // System.out.println(projectPath);
           // System.out.println(classPath);
            System.out.println(classFullPath);
//            System.out.println(classFullPath.indexOf("data"));
            System.out.println(classFullPath.substring(6, classFullPath.indexOf("target")));
        } catch(Exception ex) {
            ex.printStackTrace();
        }

    }

    @Test
    public void testfindall() {
        List<Car> carlist = cs.findAll();
        System.out.println( carlist );
    }
}
