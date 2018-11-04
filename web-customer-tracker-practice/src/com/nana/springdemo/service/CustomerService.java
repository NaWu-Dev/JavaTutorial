package com.nana.springdemo.service;

import com.nana.springdemo.entity.Customer;
import com.nana.springdemo.entity.CustomerContacts;

import java.util.List;

public interface CustomerService {
    public List<Customer> listCustomers();

    public List<CustomerContacts> listCustomerContacts(int customerId);

    public void saveCustomer(Customer theCustomer);

    public void saveCustomerContacts(Customer theCustomer);
}
