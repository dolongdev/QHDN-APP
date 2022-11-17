package com.qhdn.controller.security;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/security")
public class SecurityController {

    @GetMapping("/login")
    public String loginForm(){
        return "/admin/login-form";
    }

    @GetMapping("/login/error")
    public String loginError(Model model){
        model.addAttribute("message", "Login Failed!!");
        return "/admin/login-form";
    }

    @GetMapping("/login/success")
    public String loginSuccess(Model model){
        model.addAttribute("message", "Login Success!!");
        return "/admin/login-form";
    }

    @GetMapping("/logoff/success")
    public String logoff(Model model){
        model.addAttribute("message", "Logoff successfully!!");
        return "redirect:/security/login";
    }
}
