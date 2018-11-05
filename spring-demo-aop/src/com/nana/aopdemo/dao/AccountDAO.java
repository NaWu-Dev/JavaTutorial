package com.nana.aopdemo.dao;

import com.nana.aopdemo.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountDAO {

    public void addAccount(Account theAccount, boolean vipFlag) {

        System.out.println(getClass() + ": Do some db work: Add Account");
    }

    public boolean doWork(){

        System.out.println(getClass() + ": doWork()");

        return false;
    }
}
