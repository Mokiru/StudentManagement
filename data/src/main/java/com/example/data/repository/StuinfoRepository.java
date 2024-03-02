package com.example.data.repository;

import com.example.data.domain.Stuinfo;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StuinfoRepository extends CrudRepository<Stuinfo, Integer> {

    // 查找全部学生信息
    @Query("SELECT * FROM stuinfo")
    public List<Stuinfo> findAll();

    // 根据 学院名称 查找学生信息
    @Query("SELECT * FROM stuinfo WHERE faculties=:faculties")
    public List<Stuinfo> findAll(String faculties);

    // 根据 学院名称 班级 查找学生信息
    @Query("SELECT * FROM stuinfo WHERE faculties=:faculties AND classn=:classn")
    public List<Stuinfo> findAll(String faculties, String classn);

    // 根据 学号查找学生信息
    @Query("SELECT * FROM stuinfo WHERE stuid=:stuid")
    public List<Stuinfo> findInfoByStuid(String stuid);

    // 添加学生信息
    @Modifying
    @Query("INSERT INTO stuinfo (faculties, classn, stuid, stuname, tel) VALUES (:#{#s.faculties}, :#{#s.classn}, :#{#s.stuid}, :#{#s.stuname}, :#{#s.tel})")
    public void addStuinfo(@Param("s") Stuinfo s);

    @Modifying
    @Query("UPDATE stuinfo SET faculties=:#{#stu.faculties}, classn=:#{#stu.classn}, stuid=:#{#stu.stuid}, stuname=:#{#stu.stuname}, tel=:#{#stu.tel} WHERE id=:#{#stu.id}")
    void updateStuinfo(@Param("stu") Stuinfo stu);

    // 根据id 删除
    @Modifying
    @Query("DELETE FROM stuinfo WHERE id=:id")
    void deleteStuinfo(@Param("id") Integer id);
}
