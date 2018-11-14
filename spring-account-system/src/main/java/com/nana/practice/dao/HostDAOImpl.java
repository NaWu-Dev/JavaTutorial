package com.nana.practice.dao;

import com.nana.practice.entity.Host;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HostDAOImpl implements HostDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Host> listHosts() {

        Session currentSession = sessionFactory.getCurrentSession();

        String sql = "select * from accountsystem_host";
        Query<Host> query = currentSession.createNativeQuery(sql, Host.class);
        List<Host> hosts = query.getResultList();

        return hosts;

    }

}
