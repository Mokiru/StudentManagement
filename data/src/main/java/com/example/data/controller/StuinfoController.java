package com.example.data.controller;

import com.example.data.domain.Stuinfo;
import com.example.data.service.StuinfoService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/stuinfo")
public class StuinfoController {

    @Autowired
    private StuinfoService stuinfoService;

    @RequestMapping("/get")
    public String getPage(HttpSession session) {
        Object select = session.getAttribute("stuchoice");
        List<Stuinfo> stuinfoList;
        if (select == null) {
            stuinfoList = stuinfoService.findAll();
        } else {
            stuinfoList = stuinfoService.findAll((String) select);
        }
        session.setAttribute("stuinfoList", stuinfoList);
        return "stuinfo";
    }

    @RequestMapping("/add")
    public String addStuinfo(Stuinfo stuinfo, HttpSession session) {
        stuinfoService.addStuinfo(stuinfo);
        return "redirect:/stuinfo/get";
    }

    @RequestMapping("/update")
    public String updateStuinfo(Stuinfo stuinfo) {
        stuinfoService.updateStuinfo(stuinfo);
        return "redirect:/stuinfo/get";
    }

    @RequestMapping("/delete/{id}")
    public String deleteStuinfo(@PathVariable("id") Integer id) {
        stuinfoService.deleteStuinfo(id);
        return "redirect:/stuinfo/get";
    }

    @RequestMapping("/select")
    public String selectSome(String stuchoice, HttpSession session) {
        if (stuchoice.equals("All")) {
            session.removeAttribute("stuchoice");
        } else {
            session.setAttribute("stuchoice", stuchoice);
        }
        return "redirect:/stuinfo/get";
    }
}
