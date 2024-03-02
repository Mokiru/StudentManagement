package com.example.data.service;

import com.example.data.domain.classinfo;
import com.example.data.repository.ClassinfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassinfoService {

    @Autowired
    private ClassinfoRepository classinfoRepository;

    public List<classinfo> findBySome(String limit) {
        if (limit == null) {
            return classinfoRepository.findAll();
        } else {
            return classinfoRepository.findBySome(limit);
        }
    }

    public void updateClassinfo(classinfo cinfo) {
        classinfoRepository.updateClassinfo(cinfo);
    }

    public void deleteClassinfo(Integer id) {
        classinfoRepository.deleteById(id);
    }

    public void addClassinfo(classinfo cinfo) {
        classinfoRepository.addClassinfo(cinfo);
    }

}
