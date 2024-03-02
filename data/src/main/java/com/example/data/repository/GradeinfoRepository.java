package com.example.data.repository;

import com.example.data.domain.Failinfo;
import com.example.data.domain.Gradeinfo;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GradeinfoRepository extends CrudRepository<Gradeinfo, Integer> {

    // 统计 分数小于 60 的人数 并按照 学科名称 进行 分组 最终获得 挂科统计表
    @Query("SELECT subject, COUNT(stuid) AS personnum FROM gradeinfo WHERE grade<60 GROUP BY subject")
    public List<Failinfo> getFailinfo();

    @Query("SELECT subject, COUNT(stuid) AS personnum FROM gradeinfo WHERE grade<60 AND subject=:check")
    public List<Failinfo> getFailinfoBySome(@Param("check") String check);

    @Query("SELECT COUNT(stuid) FROM gradeinfo WHERE grade<60")
    public Integer getFailNum();

    // 查询成绩信息
    @Query("SELECT * FROM gradeinfo ORDER BY subject DESC, grade DESC")
    public List<Gradeinfo> findAll();

    // 根据科目查询成绩信息 降序
    @Query("SELECT * FROM gradeinfo WHERE subject=:subject ORDER BY grade DESC")
    public List<Gradeinfo> findAll(@Param("subject") String subject);

    //添加成绩信息
    @Modifying
    @Query("INSERT INTO gradeinfo (subject, stuid, grade) VALUES (:#{#grade.subject}, :#{#grade.stuid}, :#{#grade.grade})")
    public void addGradeinfo(@Param("grade") Gradeinfo grade);
}
