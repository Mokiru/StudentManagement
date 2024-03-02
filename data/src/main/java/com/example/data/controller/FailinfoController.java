package com.example.data.controller;

import com.example.data.domain.Failinfo;
import com.example.data.service.GradeinfoService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/failinfo")
public class FailinfoController {

    @Autowired
    private GradeinfoService gradeinfoService;

    @RequestMapping("/get")
    public String getPage(HttpSession session) {
        // 返回 挂科统计页面
        Object check = session.getAttribute("finfosel");
        List<Failinfo> failsubs;
        if (check == null) {
            failsubs = gradeinfoService.findAll();
        } else {
            failsubs = gradeinfoService.findSome((String) check);
        }
        session.setAttribute("failinfo", failsubs);
        System.out.println(failsubs);
        return "failinfo";
    }

    @RequestMapping("/select")
    public String selectFailinfo(String failchoice, HttpSession session) {
        if (failchoice.equals("All")) {
            session.removeAttribute("finfosel");
        } else {
            session.setAttribute("finfosel", failchoice);
        }
        return "redirect:/failinfo/get";
    }

}
