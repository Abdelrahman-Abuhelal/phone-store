package com.app.phonestore.customer;

import com.app.phonestore.customer.DTO.ReceievedCustomer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customers/{id}")
    public Customer getCustomer(@PathVariable Long id){
        return customerService.getCustomer(id);
    }

    @GetMapping("/customers")
    public List<Customer> getAllCustomers(){
        return customerService.getAllCustomers();
    }

    @PostMapping("/customers/addcustomer")
    public Customer addCustomer(@RequestBody ReceievedCustomer receievedCustomer){
        return customerService.addCustomer(receievedCustomer);
    }

    @PutMapping("/customers")
    public Customer updateCustomer(@RequestBody ReceievedCustomer receievedCustomer){
        return customerService.updateCustomer(receievedCustomer);
    }




}
