package com.nana.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {

    public boolean addMember() {
        System.out.println(getClass() + ": Doing stuff: Adding a membership account");

        return true;
    }

}
