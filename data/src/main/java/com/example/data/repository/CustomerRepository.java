package com.example.data.repository;


import com.example.data.domain.Customer;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

    // 根据 account 查找单个 Customer 对象
    // "SELECT id, account, email, tel, password, salt FROM t_customers WHERE account = ? "
    Customer findByAccount(String account);
    // 根据 email 查找单个 Customer 对象
    // "SELECT id, account, email, tel, password, salt FROM t_customers WHERE email = ? "
    Customer findByEmail(String email);
    // 根据 tel 查找单个 Customer 对象
    // "SELECT id, account, email, tel, password, salt FROM t_customers WHERE tel = ? "
    Customer findByTel(String tel);

    // "SELECT ... WHERE account = ? OR email = ?"
    Customer findByAccountOrEmail(String account, String email);

    // "DELETE FROM t_customers WHERE account = ? "
    boolean deleteByAccount(String account);

    // 根据 id 找到用户并修改其 password
    @Modifying
    @Query("UPDATE t_customers SET password = ? WHERE id = ?")
    boolean updatePasswordById(String password, Long id);
}
