package com.nana.practice.rest;

import com.nana.practice.entity.Account;
import com.nana.practice.entity.Host;
import com.nana.practice.entity.User;
import com.nana.practice.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AccountRestController {

    @Autowired
    AccountService accountService;

    // ***** User API *****

    @GetMapping("/users")
    public List<User> getUsers() {
        return accountService.listUsers();
    }

    // ***** Host API *****

    @GetMapping("/hosts")
    public List<Host> getHosts() {
        return accountService.listHosts();
    }

    // ***** Account API *****

    @GetMapping("/accounts")
    public List<Account> getAccounts() {
        return accountService.listAccounts();
    }


}
