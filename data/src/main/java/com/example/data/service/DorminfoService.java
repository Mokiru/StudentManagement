package com.example.data.service;

import com.example.data.domain.Dorminfo;
import com.example.data.repository.DorminfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DorminfoService {
    @Autowired
    private DorminfoRepository dorminfoRepository;

    public List<Dorminfo> findAll() {
        return dorminfoRepository.findAll();
    }

    public List<Dorminfo> findAll(String name) {
        return dorminfoRepository.findAllBySome('%' + name + '%');
    }

    // 增
    public void addDorminfo(Dorminfo dorminfo) {
        dorminfoRepository.addDorminfo(dorminfo);
    }

    // 删
    public void deleteDorminfo(Integer id) {
        dorminfoRepository.deleteDorminfo(id);
    }

    // 改
    public void updateDorminfo(Dorminfo dorminfo) {
        dorminfoRepository.updateDorminfo(dorminfo);
    }

}
