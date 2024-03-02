package com.example.data.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("subjectinfo")
public class Subjectinfo {
    /*
        记录 有哪些科目
     */
    @Id
    private Integer id;

    private String name;
}
