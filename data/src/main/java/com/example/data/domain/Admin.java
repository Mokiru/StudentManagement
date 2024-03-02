package com.example.data.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("admin")
public class Admin {
    @Id
    private Integer id;

    private String name; // 名称

    private String username; // 用户名

    private String password; // 密码

    private String salt;
}
