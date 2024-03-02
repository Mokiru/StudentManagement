package com.example.data.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("falist")
// 目的 登录成功 过后 就去 获取 院系 有 哪些
public class falist {
    @Id
    private Integer id;

    private String name; // 院系名称
}
