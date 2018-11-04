package com.nana.springdemo.controller;

import com.nana.springdemo.entity.Customer;
import com.nana.springdemo.entity.CustomerContacts;
import com.nana.springdemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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

    @GetMapping("/addCustomer")
    public String addCustomer(Model theModel){

        Customer theCustomer = new Customer();

        theModel.addAttribute("customer", theCustomer);

        return "customer_form";
    }

    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {

        customerService.saveCustomer(theCustomer);

        customerService.saveCustomerContacts(theCustomer);

        return "redirect:/customer/list";

    }

}
