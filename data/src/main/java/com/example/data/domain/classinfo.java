package com.example.data.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;


@Data
@Table("classinfo")
public class classinfo {
    @Id
    private Integer id;

    private String faculties; // 院系

    private String classn; // 班级

    private String headteacher; // 班主任

    private Integer personnum; // 班级人数
}
