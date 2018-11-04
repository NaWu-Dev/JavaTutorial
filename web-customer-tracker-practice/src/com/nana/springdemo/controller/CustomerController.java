package com.nana.springdemo.controller;

import com.nana.springdemo.entity.Customer;
import com.nana.springdemo.entity.CustomerContacts;
import com.nana.springdemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

        for (CustomerContacts tempCustomerContact : theCustomer.getCustomerContactsList()) {
            tempCustomerContact.setCustomer(theCustomer);
        }

        customerService.saveCustomer(theCustomer);

        return "redirect:/customer/list";

    }

    @GetMapping("/updateCustomer")
    public String updateCustomer(Model theModel, @RequestParam("customerId") int id) {

        Customer theCustomer = customerService.getCustomer(id);

        theModel.addAttribute("customer", theCustomer);

        return "customer_form";
    }

}
