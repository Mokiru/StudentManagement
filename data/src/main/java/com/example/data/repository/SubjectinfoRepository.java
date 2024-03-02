package com.example.data.repository;

import com.example.data.domain.Subjectinfo;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SubjectinfoRepository extends CrudRepository<Subjectinfo, Integer> {

    @Query("SELECT * FROM subjectinfo")
    List<Subjectinfo> findAll();
}
