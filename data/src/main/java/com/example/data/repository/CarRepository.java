package com.example.data.repository;

import com.example.data.domain.Car;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CarRepository extends CrudRepository<Car, Long> {
    // 查询 模糊查询 车辆类型 或者 型号
    @Query( "SELECT * FROM t_car WHERE carclass LIKE :carclass" )
    public List<Car> findByCarClass(@Param("carclass") String carclass);

    @Query( "SELECT * FROM t_car WHERE cartype LIKE :cartype" )
    public List<Car> findByCarType(@Param("cartype") String cartype);

    @Query( "SELECT * FROM t_car WHERE price < :price AND carclass=:carclass " )
    public List<Car> findAllAboutPCP(@Param("price") Long price, @Param("carclass") String carclass); // 限制价格 和 车型

    @Query( "SELECT * FROM t_car WHERE price < 200000 AND carclass=:carclass" )
    public List<Car> findAllAboutC(@Param("carclass") String carclass); // 不限价格 限制 车型

    @Query( "SELECT * FROM t_car WHERE price < :price" )
    public List<Car> findAllAboutP(@Param("price") Long price); // 限制 价格 不限 车型

    @Query( "SELECT * FROM t_car" )
    public List<Car> findAll();

}
