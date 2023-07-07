package com.example.data.service;

import com.example.data.domain.Car;
import com.example.data.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    @Autowired
    CarRepository cr;

    public List<Car> findByCarClass(String carclass) {
        return cr.findByCarClass("%" + carclass +"%");
    }

    public List<Car> findByCarType(String cartype) {
        return cr.findByCarType("%" + cartype + "%");
    }

    public List<Car> findAll() {
        return cr.findAll();
    }
}
