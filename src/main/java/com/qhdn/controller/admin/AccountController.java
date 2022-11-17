package com.qhdn.controller.admin;

import com.qhdn.dto.AccountDto;
import com.qhdn.entity.Account;
import com.qhdn.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin/accounts")
public class AccountController {

    @Autowired
    AccountService accountService;

    @GetMapping("")
    public String accountList(Model model, @ModelAttribute("account") Account account){
        List<Account> list = this.accountService.findAll();
        model.addAttribute("accounts", list);
        return "/admin/account-list";
    }

    @GetMapping("/delete/{username}")
    public String deleteAccount(Model model, @PathVariable String username){
        this.accountService.deleteAccount(username);
        return "redirect:/admin/accounts";
    }

    @PostMapping("/add")
    public String addAccount(Model model, @ModelAttribute("account") Account account){
        this.accountService.addAccount(account);
        return "redirect:/admin/accounts";
    }
}
