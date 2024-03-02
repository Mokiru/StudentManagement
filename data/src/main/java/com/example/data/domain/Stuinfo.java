package com.example.data.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("stuinfo")
public class Stuinfo {
    @Id
    private Integer id;

    private String faculties; // 学院 名称

    private String classn; // 班级

    private String stuid; // 学号

    private String stuname; // 学生姓名

    private String tel; // 学生电话号码
}
