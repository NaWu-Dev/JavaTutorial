package com.nana.springdemo.controller;

import com.nana.springdemo.dao.CustomerDAO;
import com.nana.springdemo.entity.Customer;
import com.nana.springdemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    // need to inject the customer service instead of customer DAO
    @Autowired
    private CustomerService customerService;

    @GetMapping("/list")
    public String listCustomer(Model theModel) {

        // get customer from the dao
        List<Customer> theCustomers = customerService.getCustomers();

        // add the customers to model
        theModel.addAttribute("customers", theCustomers);

        return "list-customers";

    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {

        // create model attribute to bind form data
        Customer theCustomer = new Customer();

        theModel.addAttribute("customer", theCustomer);

        return "customer-form";

    }

}
