package com.example.data.controller;

import com.example.data.domain.Gradeinfo;
import com.example.data.service.GradeinfoService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/gradeinfo")
public class GradeinfoController {
    @Autowired
    private GradeinfoService gradeinfoService;

    @RequestMapping("/select")
    public String selectGradeinfo(String gradechoice, HttpSession session) {
        if (gradechoice.equals("All")) {
            session.removeAttribute("gradechoice");
        } else {
            session.setAttribute("gradechoice", gradechoice);
        }
        return "redirect:/gradeinfo/get";
    }

    @RequestMapping("/add")
    public String addGradeinfo(Gradeinfo gradeinfo) {
        System.out.println(gradeinfo);
        gradeinfoService.addGradeinfo(gradeinfo);
        return "redirect:/gradeinfo/get";
    }

    @RequestMapping("/get")
    public String getGradeinfo(HttpSession session) {
        Object gradechoice = session.getAttribute("gradechoice");
        List<Gradeinfo> gradeinfoList;
        if (gradechoice == null) {
            gradeinfoList = gradeinfoService.findAllGrade();
        } else {
            gradeinfoList = gradeinfoService.findAllGrade((String) gradechoice);
        }
        session.setAttribute("gradeinfoList", gradeinfoList);
        return "gradeinfo";
    }


}
