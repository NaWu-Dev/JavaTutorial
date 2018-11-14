package com.nana.practice.dao;

import com.nana.practice.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<User> listUsers() {

        Session session = sessionFactory.getCurrentSession();

        String sql = "select * from accountsystem_user";
        Query<User> query = session.createNativeQuery(sql, User.class);
        List<User> users = query.getResultList();

        return users;

    }

    @Override
    public User getUser(int userId) {

        Session currentSession = sessionFactory.getCurrentSession();

        User theUser = currentSession.get(User.class, userId);

        return theUser;
    }

}
