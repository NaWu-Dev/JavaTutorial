package com.nana.springdemo.service;

import com.nana.springdemo.dao.CustomerDAO;
import com.nana.springdemo.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDAO customerDAO;

    @Override
    @Transactional
    public List<Customer> listCustomers() {
        List<Customer> customers = customerDAO.listCustomers();
        return customers;
    }
}
