package com.nana.springdemo.dao;

import com.nana.springdemo.entity.Customer;

import java.util.List;

public interface CustomerDAO {
    public void saveCustomer(Customer theCustomer) ;

    public List<Customer> listCustomers();

    public Customer getCustomer(int id);
}
