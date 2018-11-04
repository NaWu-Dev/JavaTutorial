package com.nana.springdemo.dao;

import com.nana.springdemo.entity.Customer;
import com.nana.springdemo.entity.CustomerContacts;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerContactsDAOImpl implements CustomerContactsDAO {

    @Autowired
    private SessionFactory sessionFactory = new Configuration()
                                            .configure("hibernate.cfg.xml")
                                            .addAnnotatedClass(Customer.class)
                                            .addAnnotatedClass(CustomerContacts.class)
                                            .buildSessionFactory();

    @Override
    public List<CustomerContacts> listCustomerContacts(int customerId) {

        Session session = sessionFactory.getCurrentSession();

        Customer theCustomer = session.get(Customer.class, customerId);

        List<CustomerContacts> customerContacts = theCustomer.getCustomerContactsList();

        return customerContacts;

    }

    @Override
    public void saveCustomerContacts(Customer theCustomer) {

        Session session = sessionFactory.getCurrentSession();

        CustomerContacts customerContacts = new CustomerContacts();

        customerContacts.setCustomer(theCustomer);

        customerContacts.setTelephoneNumber(theCustomer.getTelephone());

        session.saveOrUpdate(customerContacts);

    }

}
