package com.qhdn.controller.rest;

import com.qhdn.entity.Account;
import com.qhdn.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/accounts/")
public class AccountsRestController {

    @Autowired
    AccountService accountService;

    @GetMapping("/{username}")
    public ResponseEntity<Account> getSingleUser(Model model
            , @PathVariable String username){
        Account account = this.accountService.findById(username);
        model.addAttribute("account", account);
        return ResponseEntity.ok(account);
    }
}
