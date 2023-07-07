package com.example.data.controller;

import com.example.data.domain.Customer;
import com.example.data.domain.CustomerDetails;
import com.example.data.service.CustomerDetailsService;
import com.example.data.service.CustomerService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;


@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService service; // customer  Service

    @Autowired
    private CustomerDetailsService cds; // customerDetails      Service

    @PostMapping("/sign/in")
    public String signInAction(Customer c, RedirectAttributes ra, String captcha, HttpSession session) {
        String un = c.getUsername(); // 用户账号
        String pwd = c.getPassword(); // 用户密码
        CustomerDetails cd = new CustomerDetails(); // 用户详细信息
        String code = (String)session.getAttribute("CAPTCHA"); // 获取 验证码

        if (un == null || (un = un.trim()).isEmpty()) { // 账号判断
            ra.addFlashAttribute("message", "账号不能为空");
            return "redirect:/";
        }

        session.setAttribute("username", un);
        Customer allc = service.findByUsername(un);

        if (allc == null) {
            ra.addFlashAttribute("message", "用户名不存在");
            return "redirect:/";
        }

        if ( !captcha.equals(code) ) {
            ra.addFlashAttribute("message", "验证码错误");
            return "redirect:/";
        }

        cd = cds.findByCustomerId(allc.getId());
        String salt = allc.getSalt();
        String check = service.encrypt(pwd, salt);

        if (check.equals(allc.getPassword())) {
            if (cd != null) {
                session.setAttribute("CustomerDetails", cd);
            }
            session.setAttribute("Customer", c);
            return "redirect:/customer/mainPage";
        }
        ra.addFlashAttribute("message", "用户名或密码有误");
        return "redirect:/";
    }

    @GetMapping("/sign/up")
    public String signUpPage() { return "/customer/signUp"; }

    @PostMapping("/sign/up")
    public String signUpAction(Customer c, CustomerDetails cd, RedirectAttributes ra, HttpSession session) {
        String un = c.getUsername();
        String pwd = c.getPassword();
        session.setAttribute("Customer", c);
        if (un == null || (un = un.trim()).isEmpty()) {
            ra.addFlashAttribute("message", "用户名不能为空");
            return "redirect:/customer/sign/up";
        }
        if (service.findUsernameByUsername(un)) {
            ra.addFlashAttribute("message", "用户名已经被占用");
            return "redirect:/customer/sign/up";
        }
        if (pwd == null || (pwd = pwd.trim()).isEmpty()) {
            ra.addFlashAttribute("message", "密码不能为空");
            return "redirect:/customer/sign/up";
        }
        service.save(c);
        cd.setCustomerId(c.getId());
        cds.save(cd);
        return "redirect:/";
    }

    @RequestMapping("/mainPage")
    public String getMainPage(HttpSession session, RedirectAttributes attr) {
        if (session.getAttribute("Customer") == null || session.getAttribute("CustomerDetails") == null) {
            attr.addFlashAttribute("message", "请先登录");
            return "redirect:/";
        }
        return "/customer/mainPage";
    }

    @RequestMapping("/sign/out")
    public String signOutAction(HttpSession session) {
        session.removeAttribute("CustomerDetails");
        session.removeAttribute("Customer");
        session.removeAttribute("usernmae");
        session.removeAttribute("password");
        return "redirect:/";
    }
}
