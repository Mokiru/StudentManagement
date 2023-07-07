package com.example.data.repository;

import com.example.data.domain.CustomerDetails;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;


public interface CustomerDetailsRepository extends CrudRepository<CustomerDetails, Long> {

    @Query("SELECT * FROM t_details WHERE customer_id = :id")
    public CustomerDetails findByCustomerId(Long id);

    @Modifying
    @Query("UPDATE t_details t SET t.realname=:realname, t.sex=:sex, t.birthdate=:birthdate,t.location=:location WHERE customer_id = :id")
    public void updateByCustomerId(String realname, String sex, LocalDate birthdate, String location, Long id);


}
