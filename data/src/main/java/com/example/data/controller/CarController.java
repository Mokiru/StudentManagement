package com.example.data.controller;

import com.example.data.domain.Car;
import com.example.data.service.CarService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/car")
public class CarController {
    @Autowired
    CarService cs;

    @RequestMapping("/list")
    public String eachlist(Long price, String carclass, HttpSession session) {
        List<Car> carlist = new ArrayList<>();
        System.out.println( session.getAttribute("price") );
        System.out.println( session.getAttribute("carclass") );
//        if (price != null) {
//            session.setAttribute("price", price);
//        }
//        if (carclass != null) {
//            session.setAttribute("carclass", carclass);
//        }
//
//        if (price != null && carclass != null) {
//            carlist = cs.findAllAboutPCP(price, carclass);
//        }
        carlist = cs.findAllAboutPCP();


        session.setAttribute("carlist", carlist);
        // object -> List<Car>
//        Class<Car> cla = Car.class;
//        List<Car> list = new ArrayList<>();

//        Object obj = session.getAttribute("carlist");
//        for (Object o : (List<Car>) obj) {
//            list.add(cla.cast(o));
//        }
//        System.out.println(list);

        return "redirect:/customer/mainPage";
    }
//
//    @GetMapping("/mainPage/{carid}")
//    public String carMainpage(@Param(carid) String carid) {
//
//    }
}
