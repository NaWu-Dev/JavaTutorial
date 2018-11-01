package com.nana.springdemo.dao;

import com.nana.springdemo.entity.Customer;

import java.util.List;

public interface CustomerDAO {

    public List<Customer> getCustomers();

    void saveCustomer(Customer theCustomer);
}
