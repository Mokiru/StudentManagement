package com.example.data.service;

import com.example.data.config.Encrypt;
import com.example.data.domain.userinfo;
import com.example.data.repository.UserinfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserinfoService {

    @Autowired
    private UserinfoRepository userinfoRepository;

    private Encrypt en;

    // 重置用户
    public boolean updateUserinfo(String stuid) {
        userinfo u = userinfoRepository.findByStuid(stuid);
        String salt, password;
        if (u != null) {
            salt = u.getSalt();
            password = en.encrypt("888", salt);
            userinfoRepository.updateUserinfo(stuid, password);
            return true;
        } else {
            return false;
        }
    }

    public void deleteUserinfo(Integer id) {
        userinfoRepository.deleteUserinfo(id);
    }

    public void addUserinfo(String stuid) {
        String salt = en.firstgetSalt();
        String password = en.encrypt("888", salt);
        userinfoRepository.addUserinfo(stuid, password, salt);
    }

    public List<userinfo> findAll() {
        return userinfoRepository.findAll();
    }
}
