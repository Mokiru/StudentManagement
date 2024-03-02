package com.example.data.repository;

import com.example.data.domain.Admin;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;


public interface AdminRepository extends CrudRepository<Admin, Integer> {
    @Query("SELECT * FROM admin WHERE username=:username")
    Admin findByUsername(String username);

    @Query("SELECT * FROM admin WHERE username=:username AND password=:password")
    Admin findByUP(String username, String password);
}
