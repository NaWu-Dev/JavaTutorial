package com.nana.springdemo.controller;

import com.nana.springdemo.dao.CustomerDAO;
import com.nana.springdemo.entity.Customer;
import com.nana.springdemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {

        // save customer using service
        customerService.saveCustomer(theCustomer);

        return "redirect:/customer/list";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("customerId") int theId, Model theModel) {

        // get the customer from db
        Customer theCustomer = customerService.getCustomer(theId);

        // set customer as a model attribute to pre-populate the form
        theModel.addAttribute("customer", theCustomer);

        // send over the form
        return "customer-form";
    }

    @GetMapping("/delete")
    public String deleteCustomer(@RequestParam("customerId") int theId) {

        // delete customer
        customerService.deleteCustomer(theId);

        return "redirect:/customer/list";
    }

}
