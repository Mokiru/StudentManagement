package com.example.data.repository;

import com.example.data.domain.classinfo;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ClassinfoRepository extends CrudRepository<classinfo, Integer> {

    // 获取所有信息
    @Query("SELECT * FROM classinfo")
    List<classinfo> findAll();

    // 根据 院系 筛选
    @Query("SELECT * FROM classinfo WHERE faculties=:limit")
    List<classinfo> findBySome(String limit);

    // 修改
    @Modifying
    @Query("UPDATE classinfo SET faculties=:#{#cinfo.faculties}, classn=:#{#cinfo.classn}, headteacher=:#{#cinfo.headteacher}, personnum=:#{#cinfo.personnum} WHERE id=:#{#cinfo.id}")
    void updateClassinfo(@Param("cinfo") classinfo cinfo);


    // 添加
    @Modifying
    @Query("INSERT INTO classinfo (faculties, classn, headteacher, personnum) VALUES (:#{#cinfo.faculties}, :#{#cinfo.classn}, :#{#cinfo.headteacher}, :#{#cinfo.personnum})")
    void addClassinfo(@Param("cinfo") classinfo cinfo);
}
