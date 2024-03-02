package com.example.data.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("gradeinfo")
public class Gradeinfo {
    /*
    科目-学号-成绩
     */
    @Id
    private Integer id;

    private String subject;

    private String stuid;

    private Integer grade;
}
