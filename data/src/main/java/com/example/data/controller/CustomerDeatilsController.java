package com.example.data.controller;

import com.example.data.domain.CustomerDetails;
import com.example.data.service.CustomerDetailsService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/customer/details")
public class CustomerDeatilsController {

    @Autowired
    CustomerDetailsService cds;

    @GetMapping("/update")
    public String updatePage(HttpSession session, RedirectAttributes ra) {

        if (session.getAttribute("Customer") == null) {
            ra.addFlashAttribute("message", "请先登录");
            return "redirect:/";
        }

        return "/customer/updatePage";
    }

    @PostMapping("/update")
    public String updateAction(CustomerDetails cd) { // 修改用户详细信息
        /*
        * 修改 t_details 内容
        * 密码若修改 需 额外操作
        * */
        cds.UpdateByCustomerId(cd);
        return "redirect:/customer/mainPage";
    }

}
