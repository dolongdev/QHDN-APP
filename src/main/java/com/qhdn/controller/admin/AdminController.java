package com.qhdn.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {
    @GetMapping("/test")
    public String test(){
        return "/admin/login-form";
    }

    @GetMapping("/admin/home")
    public String adminPage(Model model){
        return "admin/home";
    }
}
