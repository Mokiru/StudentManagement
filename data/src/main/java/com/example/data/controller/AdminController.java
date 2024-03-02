package com.example.data.controller;

import com.example.data.config.Encrypt;
import com.example.data.domain.Stuinfo;
import com.example.data.domain.Subjectinfo;
import com.example.data.domain.falist;
import com.example.data.service.AdminService;
import com.example.data.service.ClassinfoService;
import com.example.data.service.GradeinfoService;
import com.example.data.service.StuinfoService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.In;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.NumberFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/login")

public class AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private StuinfoService stuinfoService;

    @Autowired
    private GradeinfoService gradeinfoService;

    @Autowired
    private ClassinfoService classinfoService;

    private Encrypt en;

    @RequestMapping("/make")
    public String checkAdmin(String username, String password, HttpSession session) {
//        String salt = en.firstgetSalt();
//        String p11 = en.encrypt("1122", salt);
//        System.out.println(salt);
//        System.out.println(p11);

        if (username.isEmpty() || password.isEmpty()) {
            session.setAttribute("message", "请输入账号和密码");
            return "index";
        } else {
            // 账号 密码 不为空
            Map<String, Object> check = adminService.findByUP(username, password);
            if ((boolean) check.get("check")) {
                List<falist> falists = adminService.findAllfailname();
                List<Subjectinfo> sublists = adminService.findAllSubject();
                List<Stuinfo> s = stuinfoService.findAll();
                Integer stuNUM = s.size();
                Integer failNUM = gradeinfoService.getFailNum();
                Integer gradeNUM = gradeinfoService.findAllGrade().size();
                double failstu = (failNUM + 0.0)/(gradeNUM + 0.0);
                String str = String.format("%.2f", failstu);
                failstu = Double.parseDouble(str);
                System.out.println(failstu);
                Integer classNUM = classinfoService.findBySome(null).size();
                Integer classStu = stuNUM/classNUM;
                session.setAttribute("adminname", check.get("name"));
                session.setAttribute("falist", falists); // 添加 院系列表
                session.setAttribute("sublist", sublists); // 添加 科目列表
                session.setAttribute("Allstunum", stuNUM); // 获取学校总人数
                session.setAttribute("failSTU", failstu); // 挂科率
                session.setAttribute("classNUM", classNUM); // 班级总数
                session.setAttribute("classSTU", classStu); // 班级平均人数


            } else {
                session.setAttribute("message", "账号或密码错误");
                return "index";
            }
        }
        return "mainpage";
    }

    @RequestMapping("/test")
    @ResponseBody
    public Map<String, Object> Test(Integer u) {
        System.out.println(u);
        Map<String, Object> res = new HashMap<>();
        res.put("index", u);
        return res;
    }

    @RequestMapping("/break")
    public String breakT(HttpSession session) {
        session.invalidate();
        return "index";
    }

    @RequestMapping("/getfirst")
    public String getFirst() {
        return "firstpage";
    }
}
