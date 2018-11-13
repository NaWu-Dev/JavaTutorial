package com.nana.springdemo.rest;

import com.nana.springdemo.entity.Customer;
import com.nana.springdemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerRestController {

    @Autowired
    private CustomerService customerService;

    // get Customers list
    @GetMapping("/customers")
    public List<Customer> getCustomers() {

        return customerService.listCustomers();

    }

    // get one customer via id
    @GetMapping("/customers/{customerId}")
    public Customer getCustomer(@PathVariable int customerId) {

        Customer theCustomer = customerService.getCustomer(customerId);

        if (theCustomer == null) {
            throw new CustomerNotFoundException("Customer id not found - " + customerId);
        }

        return theCustomer;

    }

    // add new customer
    @PostMapping("/customers")
    public Customer addCustomer(@RequestBody Customer theCustomer) {

        theCustomer.setId(0);
        customerService.saveCustomer(theCustomer);

        return theCustomer;

    }

    // edit a customer
    @PutMapping("/customers")
    public Customer editCustomer(@RequestBody Customer theCustomer) {

        customerService.saveCustomer(theCustomer);

        return theCustomer;

    }

    // delete a customer
    @DeleteMapping("/customers/{customerId}")
    public void deleteCustomer(@PathVariable int customerId) {

        Customer theCustomer = customerService.getCustomer(customerId);

        if (theCustomer == null) {
            throw new CustomerNotFoundException("Customer id not found - " + customerId);
        }

        customerService.deleteCustomer(theCustomer);

    }

}
