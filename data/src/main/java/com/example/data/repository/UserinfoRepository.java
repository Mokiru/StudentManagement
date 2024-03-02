package com.example.data.repository;

import com.example.data.domain.userinfo;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserinfoRepository extends CrudRepository<userinfo, Integer> {

    // 重置密码
    @Modifying
    @Query("UPDATE userinfo SET password=:password WHERE stuid=:stuid")
    public void updateUserinfo(@Param("stuid")String stuid, @Param("password") String password);

    @Query("SELECT * FROM userinfo WHERE stuid=:stuid")
    public userinfo findByStuid(@Param("stuid") String stuid);

    // 获取用户信息
    @Query("SELECT * FROM userinfo")
    public List<userinfo> findAll();

    // 删除用户信息
    @Modifying
    @Query("DELETE FROM userinfo WHERE id=:id")
    public void deleteUserinfo(@Param("id") Integer id);

    //  添加用户信息
    @Modifying
    @Query("INSERT INTO userinfo (stuid, password, salt) VALUES (:stuid, :password, :salt)")
    public void addUserinfo(@Param("stuid") String stuid, @Param("password") String password, @Param("salt") String salt);
}
