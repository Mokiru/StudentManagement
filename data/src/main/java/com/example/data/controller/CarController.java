package com.example.data.controller;

import com.example.data.domain.Car;
import com.example.data.service.CarService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/car")
public class CarController {
    @Autowired
    CarService cs;

    @RequestMapping("/list")
    public String eachlist(HttpSession session) {
        List<Car> carlist = new ArrayList<>();
        carlist = cs.findAll();
        session.setAttribute("carlist", carlist);
        session.getAttribute("carlist").;
        return "redirect:/customer/mainPage";
    }

}
