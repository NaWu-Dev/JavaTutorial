package com.nana.practice.service;

import com.nana.practice.dao.AccountDAO;
import com.nana.practice.dao.HostDAO;
import com.nana.practice.dao.UserDAO;
import com.nana.practice.entity.Account;
import com.nana.practice.entity.Host;
import com.nana.practice.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private HostDAO hostDAO;

    @Autowired
    private AccountDAO accountDAO;

    @Override
    @Transactional
    public List<User> listUsers() {
        List<User> users = userDAO.listUsers();
        return users;
    }

    @Override
    @Transactional
    public User getUser(int userId) {
        return userDAO.getUser(userId);
    }

    @Override
    @Transactional
    public List<Host> listHosts() {
        List<Host> hosts = hostDAO.listHosts();
        return hosts;
    }

    @Override
    @Transactional
    public Host getHost(int hostId) {
        return hostDAO.getHost(hostId);
    }

    @Override
    @Transactional
    public List<Account> listAccounts() {
        List<Account> accounts = accountDAO.listAccounts();
        return accounts;
    }

    @Override
    @Transactional
    public Account getAccount(int accountId) {
        return accountDAO.getAccount(accountId);
    }

}
