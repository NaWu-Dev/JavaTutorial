package com.nana.practice.dao;

import com.nana.practice.entity.Account;
import com.nana.practice.entity.Host;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AccountDAOImpl implements AccountDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Account> listAccounts() {

        Session currentSession = sessionFactory.getCurrentSession();

        String sql = "select * from accountsystem_account";
        Query<Account> query = currentSession.createNativeQuery(sql, Account.class);
        List<Account> accounts = query.getResultList();

        return accounts;

    }

    @Override
    public Account getAccount(int accountId) {
        Session currentSession = sessionFactory.getCurrentSession();

        return currentSession.get(Account.class, accountId);
    }

}
