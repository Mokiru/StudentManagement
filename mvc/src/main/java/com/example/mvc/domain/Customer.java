package com.example.mvc.domain;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
public class Customer {
    private String username;
    private String password;
    private String realname;
    private String sex;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate busiExpireDate;
    private String location;
    private String [] like ;

}
