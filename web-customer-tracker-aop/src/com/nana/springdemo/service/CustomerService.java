package com.nana.springdemo.service;

import com.nana.springdemo.entity.Customer;

import java.util.List;

public interface CustomerService {

    public Customer getCustomer(int theId);

    public List<Customer> getCustomers();

    public void saveCustomer(Customer theCustomer);

    public void deleteCustomer(int theId);
}
