package com.nana.practice.service;

import com.nana.practice.entity.Account;
import com.nana.practice.entity.Host;
import com.nana.practice.entity.User;

import java.util.List;

public interface AccountService {

    // ***** Users methods *****
    public List<User> listUsers();
    public User getUser(int userId);
    public String addUser(User theUser);

    // ***** Host methods *****
    public List<Host> listHosts();
    public Host getHost(int hostId);

    // ***** Accounts *****
    public List<Account> listAccounts();
    public Account getAccount(int accountId);

}
