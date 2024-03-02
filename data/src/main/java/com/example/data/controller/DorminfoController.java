package com.example.data.controller;


import com.example.data.domain.Dorminfo;
import com.example.data.service.DorminfoService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/dorminfo")
public class DorminfoController {
    @Autowired
    private DorminfoService dorminfoService;

    @RequestMapping("/get")
    public String getPage(HttpSession session) {
        Object sea = session.getAttribute("dorminfosearch");
        List<Dorminfo> dorminfoList;
        if (sea == null) {
            dorminfoList = dorminfoService.findAll();
        } else {
            dorminfoList = dorminfoService.findAll((String) sea);
            session.removeAttribute("dorminfosearch");
        }
        session.setAttribute("dorminfoList", dorminfoList);
        return "dorminfo";

    }

    @RequestMapping("/search")
    public String searchDorminfo(String sea, HttpSession session) {
        if (sea == null) {
            session.removeAttribute("dorminfosearch");
        } else {
            session.setAttribute("dorminfosearch", sea);
        }
        return "redirect:/dorminfo/get";
    }

    @RequestMapping("/update")
    public String updateDorminfo(Dorminfo dorminfo) {
        dorminfoService.updateDorminfo(dorminfo);
        return "redirect:/dorminfo/get";
    }

    @RequestMapping("/delete/{id}")
    public String deleteDorminfo(@PathVariable("id") Integer id) {
        dorminfoService.deleteDorminfo(id);
        return "redirect:/dorminfo/get";
    }

    @RequestMapping("/add")
    public String addDorminfo(Dorminfo dorminfo) {
        dorminfoService.addDorminfo(dorminfo);
        return "redirect:/dorminfo/get";
    }


}
