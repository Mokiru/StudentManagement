package com.example.data.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("dorminfo")
public class Dorminfo {
    @Id
    private Integer id;

    private String classn;

    private String stuname;

    private String buildnum;

    private String dormnum;

}
