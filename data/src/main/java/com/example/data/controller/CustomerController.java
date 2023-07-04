package com.example.data.controller;

import com.example.data.domain.Customer;
import com.example.data.service.CustomerService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService service;

    @PostMapping("/sign/in")
    public String signInAction(Customer c, RedirectAttributes ra, HttpSession session) {
        String un = c.getUsername();
        String pwd = c.getPassword();
        if (un == null || (un = un.trim()).isEmpty()) {
            ra.addFlashAttribute("message", "用户名不能为空");
            return "redirect:/";
        }
        session.setAttribute("username", un);
        Customer allc = service.findByUsername(un);
        if (allc == null) {
            ra.addFlashAttribute("message", "用户名不存在");
            return "redirect:/";
        }
        String salt = allc.getSalt();
        String check = service.encrypt(pwd, salt);
        System.out.println(allc.getSalt());
        if (check.equals(allc.getPassword())) {
            return "redirect:/customer/mainPage";
        }
        ra.addFlashAttribute("message", "用户名或密码有误");
        return "redirect:/";
    }

    @GetMapping("/sign/up")
    public String signUpPage() { return "/customer/signUp"; }

    @PostMapping("/sign/up")
    public String signUpAction(Customer c, RedirectAttributes ra) {
        service.save(c);
        return "redirect:/";
    }

    @RequestMapping("/mainPage")
    public String getMainPage() {
        return "/customer/mainPage";
    }

}
