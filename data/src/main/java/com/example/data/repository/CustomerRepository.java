package com.example.data.repository;


import com.example.data.domain.Customer;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

    // 根据 account 查找单个 Customer 对象
    // "SELECT * FROM t_customers WHERE account = ? "
    @Query( "SELECT * FROM t_customers WHERE username = :username" )
    Customer findByUsername(String username);

    // 根据 id 找到用户并修改其 password
    @Modifying
    @Transactional
    @Query("UPDATE t_customers SET password = :password WHERE id = :id")
    void updatePasswordById(@Param("password") String password, @Param("id") Long id);

    @Query( "SELECT username FROM t_customers WHERE username = :username" )
    String findUsernameByUsername(String username);

}
