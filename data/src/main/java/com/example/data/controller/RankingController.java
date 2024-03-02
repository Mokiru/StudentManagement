package com.example.data.controller;

import com.example.data.domain.Gradeinfo;
import com.example.data.domain.Stuinfo;
import com.example.data.service.GradeinfoService;
import com.example.data.service.StuinfoService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.In;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;

@Controller
@RequestMapping("/ranking")
public class RankingController {
    /*
        成绩排名 首先 编号 学号 总分（列表排序）
        需要 gradeinfo 表
            stuinfo 表 获得 学生学号
     遍历 stuinfo Map<String, Object> ... [key:学号, value:总分]
     最后遍历 gradeinfo 每次对学号加上值即可
     */
    @Autowired
    private StuinfoService stuinfoService;

    @Autowired
    private GradeinfoService gradeinfoService;

    @RequestMapping("/get")
    public String getPage(HttpSession session) {
        //
        List<Stuinfo> stuinfoList = stuinfoService.findAll();
        Map<String, Integer> mem = new HashMap<>();
        for (var x : stuinfoList) {
            mem.put(x.getStuid(), 0);
        }
        List<Gradeinfo> gradeinfoList = gradeinfoService.findAllGrade();
        for (var x : gradeinfoList) {
            mem.replace(x.getStuid(), mem.get(x.getStuid()) + x.getGrade());
        }
        List<Map.Entry<String, Integer>> ranklist = new ArrayList<>(mem.entrySet());
        ranklist.sort(Collections.reverseOrder(Map.Entry.comparingByValue()));
        session.setAttribute("rankmap", mem);
        session.setAttribute("Ranking", ranklist);
        return "ranking";
    }

    @RequestMapping("/search")
    public String searchRank(String sea, HttpSession session) {
         if (sea.equals("")) {
             return "redirect:/ranking/get";
         } else {
            Map<String, Integer> mem = (Map<String, Integer>) session.getAttribute("rankmap");
            if (mem.containsKey(sea)) {
                Map<String, Integer> ans = new HashMap<>();
                ans.put(sea, mem.get(sea));
                session.setAttribute("Ranking", ans);
            }
         }
         return "ranking";
    }
}
