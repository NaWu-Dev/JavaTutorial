package com.nana.practice.service;

import com.nana.practice.dao.UserDAO;
import com.nana.practice.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private UserDAO userDAO;

    @Override
    @Transactional
    public List<User> listUsers() {
        List<User> users = userDAO.listUsers();
        return users;
    }

}
