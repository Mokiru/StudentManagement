package com.example.data.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("t_car")
public class Car {
    @Id
    private Long id;

    private Long price; // 价格

    private String cartype; // 型号

    private String carclass; // 类型

    private Long person; // 可承载最大人数

    private String color; // 颜色

}
