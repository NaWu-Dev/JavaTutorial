package com.nana.springdemo.dao;

import com.nana.springdemo.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void saveCustomer(Customer theCustomer) {

        Session currentSession = sessionFactory.getCurrentSession();

        currentSession.saveOrUpdate(theCustomer);
    }

    @Override
    public List<Customer> listCustomers() {

        Session currentSession = sessionFactory.getCurrentSession();

        String sql = "select * from customer";
        Query<Customer> query = currentSession.createNativeQuery(sql, Customer.class);
        List<Customer> customers = query.getResultList();

        return customers;
    }
}
