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

    public List<Car> findAll();
}
