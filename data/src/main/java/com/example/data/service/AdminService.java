package com.example.data.service;

import com.example.data.config.Encrypt;
import com.example.data.domain.Admin;
import com.example.data.domain.Subjectinfo;
import com.example.data.domain.falist;
import com.example.data.repository.AdminRepository;
import com.example.data.repository.FalistRepository;
import com.example.data.repository.SubjectinfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private FalistRepository falistRepository; // 可以进行 获取院系 列表 操作

    @Autowired
    private SubjectinfoRepository subjectinfoRepository; // 获取 科目 列表

    private Encrypt en;

    public Admin findByUsername(String username) {
        return adminRepository.findByUsername(username);
    }

    public Map<String, Object> findByUP(String username, String password) {
        Admin admin = adminRepository.findByUsername(username);
//        Admin admin = adminRepository.findByUP(username, password);
        String checkp;
        Map<String, Object> res = new HashMap<>();
        res.put("check", false);
        if (admin != null) {
            checkp = en.encrypt(password, admin.getSalt());
        } else {
            return res;
        }
        if (admin.getPassword().equals(checkp)) {
            res.replace("check", true);
            res.put("name", admin.getName());
        }
        return res;
    }

    public List<falist> findAllfailname() {
        return falistRepository.findAllName();
    }

    public List<Subjectinfo> findAllSubject() {
        return subjectinfoRepository.findAll();
    }
}
