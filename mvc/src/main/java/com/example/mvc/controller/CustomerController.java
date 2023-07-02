package com.example.mvc.controller;

import com.example.mvc.domain.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;

@Controller

@RequestMapping("/customer")

public class CustomerController {

    @GetMapping("/sign/up")
    public String signUppage() { return "signUp"; }

    @PostMapping("/sign/up")
    public String signUpAction(Customer customer, RedirectAttributes attrs) {
        String username = customer.getUsername();
        String password = customer.getPassword();
        String realname = customer.getRealname();
        String sex = customer.getSex();
        LocalDate busi = customer.getBusiExpireDate();
        String location = customer.getLocation();
        String [] like = customer.getLike();
//        System.out.println(busi);
        if (username == null || (username = username.trim()).isEmpty()) {
            attrs.addFlashAttribute("message", "用户名不能为空");
            return "redirect:/customer/sign/up";
        }
        if (password == null || (password = password.trim()).isEmpty()) {
            attrs.addFlashAttribute("message", "密码不能为空");
            return "redirect:/customer/sign/up";
        }
        if (realname == null || (realname = realname.trim()).isEmpty()) {
            attrs.addFlashAttribute("message", "姓名不能为空");
            return "redirect:/customer/sign/up";
        }

        return "redirect:/";
    }

    @GetMapping("/sign/in")
    public String signInpage() { return "signIn"; }

    @PostMapping("/sign/in")
    public String signInAction(Customer customer, RedirectAttributes attrs) {



        return "redirect:/mainpage";
    }
}
