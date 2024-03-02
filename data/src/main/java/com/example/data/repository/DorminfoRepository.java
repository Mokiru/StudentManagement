package com.example.data.repository;

import com.example.data.domain.Dorminfo;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DorminfoRepository extends CrudRepository<Dorminfo, Integer> {

    // 获取 宿舍信息
    @Query("SELECT * FROM dorminfo")
    public List<Dorminfo> findAll();

    // 修改宿舍信息
    @Modifying
    @Query("UPDATE dorminfo SET classn=:#{#dorm.classn}, stuname=:#{#dorm.stuname}, buildnum=:#{#dorm.buildnum}, dormnum=:#{#dorm.dormnum} WHERE id=:#{#dorm.id}")
    public void updateDorminfo(@Param("dorm") Dorminfo dorminfo);

    // 根据id 删除信息
    @Modifying
    @Query("DELETE FROM dorminfo WHERE id=:id")
    public void deleteDorminfo(@Param("id") Integer id);

    // 添加宿舍信息
    @Modifying
    @Query("INSERT INTO dorminfo (classn, stuname, buildnum, dormnum) VALUES (:#{#dorm.classn}, :#{#dorm.stuname}, :#{#dorm.buildnum}, :#{#dorm.dormnum})")
    public void addDorminfo(@Param("dorm") Dorminfo dorminfo);

    // 根据姓名查找
    @Query("SELECT * FROM dorminfo WHERE stuname LIKE :name")
    public List<Dorminfo> findAllBySome(@Param("name") String name);
}
