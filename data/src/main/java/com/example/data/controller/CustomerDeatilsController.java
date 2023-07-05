package com.example.data.controller;

import com.example.data.domain.CustomerDetails;
import com.example.data.service.CustomerDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer/details")
public class CustomerDeatilsController {

    @Autowired
    CustomerDetailsService cds;

    @GetMapping("/update")
    public String updatePage() { return "/customer/updatePage"; }

    @PostMapping("/update")
    public String updateAction(CustomerDetails cd) {
        /*
        * 修改 t_details 内容
        * 密码若修改 需 额外操作
        *
        * */
        cds.UpdateByCustomerId(cd);
        return "redirect:/customer/mainPage";
    }

}
