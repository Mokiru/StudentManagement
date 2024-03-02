package com.example.data.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("userinfo")
public class userinfo {
    /*
        学生用户
     */

    @Id
    private Integer id;

    private String stuid;

    private String password;

    private String salt;
}
