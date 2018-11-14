package com.nana.practice.rest;

import com.nana.practice.entity.Account;
import com.nana.practice.entity.Host;
import com.nana.practice.entity.User;
import com.nana.practice.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/users/{userId}")
    public User getUser(@PathVariable int userId) {
        return accountService.getUser(userId);
    }

    @PostMapping("/users")
    public String addUser(@RequestBody User theUser) {
        accountService.addUser(theUser);
        return "SUCCESS";
    }

    // ***** Host API *****

    @GetMapping("/hosts")
    public List<Host> getHosts() {
        return accountService.listHosts();
    }

    @GetMapping("hosts/{hostId}")
    public Host getHost(@PathVariable int hostId) {
        return accountService.getHost(hostId);
    }

    // ***** Account API *****

    @GetMapping("/accounts")
    public List<Account> getAccounts() {
        return accountService.listAccounts();
    }

    @GetMapping("/accounts/{accountId}")
    public Account getAccount(@PathVariable int accountId) {
        return accountService.getAccount(accountId);
    }

}
