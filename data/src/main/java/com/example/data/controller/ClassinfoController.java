package com.example.data.controller;

import com.example.data.domain.classinfo;
import com.example.data.service.ClassinfoService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/classinfo")
public class ClassinfoController {

    @Autowired
    private ClassinfoService classinfoService;

    @RequestMapping("/get")
    public String goClassinfo(HttpSession session) {
        /*
            获取classinfo页面 同时 获取数据 session cinoflist
         */
        Object select = session.getAttribute("choice");
        List<classinfo> cinfolist;
        if (select != null) {
            cinfolist = classinfoService.findBySome((String) select);
        } else {
            cinfolist = classinfoService.findBySome(null);
        }

        session.setAttribute("cinfolist", cinfolist);
        return "classinfo";
    }

    @RequestMapping("/addinfo")
    public String addClassinfo(classinfo cinfo) {
        /*
            添加数据
            最后重定向 对数据更新
         */
        classinfoService.addClassinfo(cinfo);
        System.out.println(cinfo);
        return "redirect:/classinfo/get";
    }

    @RequestMapping("/update")
    public String updateClassinfo(classinfo cinfo) {
        /*
            更新 classinfo
         */
        classinfoService.updateClassinfo(cinfo);
        return "redirect:/classinfo/get";
    }

    @RequestMapping("/delete/{id}")
    public String deleteClassinfo(@PathVariable("id") Integer id) {
        /*
            根据 id 删除 classinfo
        */
        classinfoService.deleteClassinfo(id);
        return "redirect:/classinfo/get";
    }

    @RequestMapping("/select")
    public String selectClassinfo(String failchoice, HttpSession session) {
        if (!failchoice.equals("All")) {
            session.setAttribute("choice", failchoice);
        } else {
            session.removeAttribute("choice");

        }
        return "redirect:/classinfo/get";
    }
}
