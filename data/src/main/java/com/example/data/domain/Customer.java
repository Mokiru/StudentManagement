package com.example.data.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Arrays;

@Data
@Table("t_customers")
public class Customer {
    @Id
    private Long id;

    private String username;
    private String password;
    private String realname;
    private String sex;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthdate;

    private String location;
    private String like ;

    private String salt;

    public void setLike(String [] l) {
        this.like = Arrays.toString(l);
    }
}
