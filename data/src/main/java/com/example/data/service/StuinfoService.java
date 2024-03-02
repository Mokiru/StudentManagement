package com.example.data.service;

import com.example.data.domain.Stuinfo;
import com.example.data.repository.StuinfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StuinfoService {

    @Autowired
    private StuinfoRepository stuinfoRepository;

    public List<Stuinfo> findAll() {
        return stuinfoRepository.findAll();
    }

    public List<Stuinfo> findAll(String faculties) {
        return stuinfoRepository.findAll(faculties);
    }

    public List<Stuinfo> findAll(String faculties, String classn) {
        return stuinfoRepository.findAll(faculties, classn);
    }

    public List<Stuinfo> findInfoByStuid(String stuid) {
        return stuinfoRepository.findInfoByStuid(stuid);
    }

    public void addStuinfo(Stuinfo stuinfo) {
        stuinfoRepository.addStuinfo(stuinfo);
    }

    public void updateStuinfo(Stuinfo stuinfo) {
        stuinfoRepository.updateStuinfo(stuinfo);
    }

    public void deleteStuinfo(Integer id) {
        stuinfoRepository.deleteStuinfo(id);
    }
}
