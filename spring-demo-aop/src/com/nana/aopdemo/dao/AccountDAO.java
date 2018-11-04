package com.nana.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class AccountDAO {

    public void addAccount() {
        System.out.println(getClass() + ": Do some db work: Add Account");
    }

    public void testAccount(){
        System.out.println("Testing....");
    }
}
