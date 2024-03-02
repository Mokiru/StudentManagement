package com.example.data.service;

import com.example.data.domain.Failinfo;
import com.example.data.domain.Gradeinfo;
import com.example.data.repository.GradeinfoRepository;
import com.example.data.repository.SubjectinfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GradeinfoService {

    @Autowired
    private GradeinfoRepository gradeinfoRepository;

    public List<Failinfo> findAll() {
        return gradeinfoRepository.getFailinfo();
    }

    public List<Failinfo> findSome(String check) {
        return gradeinfoRepository.getFailinfoBySome(check);
    }

    public List<Gradeinfo> findAllGrade() {
        return gradeinfoRepository.findAll();
    }

    public List<Gradeinfo> findAllGrade(String subject) {
        return gradeinfoRepository.findAll(subject);
    }

    public void addGradeinfo(Gradeinfo gradeinfo) {
        gradeinfoRepository.addGradeinfo(gradeinfo);
    }

    public Integer getFailNum() {
        return gradeinfoRepository.getFailNum();
    }
}
