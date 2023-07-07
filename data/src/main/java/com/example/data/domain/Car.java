package com.example.data.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("t_cat")
public class Car {
    @Id
    private Long id;

    private String name;

}
