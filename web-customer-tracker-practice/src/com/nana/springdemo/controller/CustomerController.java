package com.nana.springdemo.controller;

import com.nana.springdemo.entity.Customer;
import com.nana.springdemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/list")
    public String listCustomer(Model theModel) {

        List<Customer> theCustomers = customerService.listCustomers();

        theModel.addAttribute("customers", theCustomers);

        return "customer-list";
    }

}
