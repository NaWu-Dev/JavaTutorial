package com.nana.springdemo.dao;

import com.nana.springdemo.entity.Customer;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.TypedQuery;
import java.util.List;


@Repository
public class CustomerDAOImpl implements CustomerDAO {

    // need to inject the session factory
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public List<Customer> getCustomers() {

        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

//        // create query
//        Query<Customer> theQuery = currentSession.createQuery("from Customer", Customer.class);
//
//        // get result list by executing query
//        List<Customer> customers = theQuery.getResultList();

        // SQL query
        String sql = "select * from customer";
        Query<Customer> query = currentSession.createNativeQuery(sql, Customer.class);
        List<Customer> customers = (List<Customer>)query.getResultList();

        // return list of customers
        return customers;
    }
}
