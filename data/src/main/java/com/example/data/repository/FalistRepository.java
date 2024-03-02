package com.example.data.repository;

import com.example.data.domain.falist;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FalistRepository extends CrudRepository<falist, Integer> {
    // 获取院系列表
    @Query("SELECT * FROM falist")
    List<falist> findAllName();

    // 根据 id 获取 院系名称
    @Query("SELECT name FROM falist WHERE id=:id")
    String findNameByid(Integer id);
}
