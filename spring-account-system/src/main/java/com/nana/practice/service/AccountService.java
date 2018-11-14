package com.nana.practice.service;

import com.nana.practice.entity.Account;
import com.nana.practice.entity.Host;
import com.nana.practice.entity.User;

import java.util.List;

public interface AccountService {

    // ***** Users methods *****
    public List<User> listUsers();

    // ***** Host methods *****
    public List<Host> listHosts();

    // ***** Accounts *****
    public List<Account> listAccounts();

}
