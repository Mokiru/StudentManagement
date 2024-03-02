package com.example.data.controller;

import com.example.data.domain.userinfo;
import com.example.data.service.UserinfoService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/userinfo")
public class UserinfoController {

    @Autowired
    private UserinfoService userinfoService;

    @RequestMapping("/get")
    public String getPage(HttpSession session) {
        List<userinfo> userinfoList =  userinfoService.findAll();
        session.setAttribute("userinfoList", userinfoList);
        return "userinfo";
    }

    @RequestMapping("/update")
    @ResponseBody
    public Map<String, Object> updateUserinfo(String stuid) {
        boolean check = userinfoService.updateUserinfo(stuid);
        Map<String, Object> res = new HashMap<>();
        res.put("sta", "F");
        if (check == true) {
            res.replace("sta", "T");
        }
        return res;
//        Map<String, Object> res = new HashMap<>();
//        res.put("sta", 1);
//        return res;
        // 重置用户
    }

    @RequestMapping("/delete/{id}")
    public String deleteUserinfo(@PathVariable("id") Integer id) {
        userinfoService.deleteUserinfo(id);
        return "redirect:/userinfo/get";
    }

    @RequestMapping("/add")
    public String addUserinfo(String stuid) {
        userinfoService.addUserinfo(stuid);
        return "redirect:/userinfo/get";
    }

}
