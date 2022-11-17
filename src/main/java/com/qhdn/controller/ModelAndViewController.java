package com.qhdn.controller;

import com.qhdn.entity.Account;
import com.qhdn.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ModelAndViewController {
    @Autowired
    AccountService accountService;

    @GetMapping("/testM")
    public String testMain(@ModelAttribute("account") Account account){
        return "testModelAndView";
    }

    @GetMapping("/testM/getSingleAcc")
    public ModelAndView test(@RequestParam String usernameInput){
        ModelAndView modelAndView = new ModelAndView("testModelAndView");
        Account account = this.accountService.findById(usernameInput);
        modelAndView.addObject("account", account);
        return modelAndView;
    }

    @GetMapping("/testM/admin")
    public ModelAndView test(Model model){
        ModelAndView modelAndView = new ModelAndView("testModelAndView");
        Account account = this.accountService.findById("admin");
        modelAndView.addObject("account", account);
        return modelAndView;
    }
}
