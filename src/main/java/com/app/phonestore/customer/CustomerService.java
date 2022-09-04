package com.app.phonestore.customer;

import com.app.phonestore.customer.DTO.ReceievedCustomer;
import com.app.phonestore.exceptions.NoDataFoundExceptions;
import com.app.phonestore.exceptions.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public CustomerService(CustomerRepository customerRepository, ModelMapper modelMapper) {
        this.customerRepository = customerRepository;
        this.modelMapper = modelMapper;
    }

    public Customer getCustomer(Long id){
        return customerRepository.findById(id).
                orElseThrow(() ->
                        new ResourceNotFoundException("Customer is not found for this id->"+id));
    }

    public List<Customer> getAllCustomers(){
        List<Customer> customers= customerRepository.findAll();
        if (customers.isEmpty()){
            throw new NoDataFoundExceptions("there is no customers to show");
        }
        return customers;
    }

    public Customer addCustomer(ReceievedCustomer receievedCustomer){
        Customer customer=modelMapper.map(receievedCustomer,Customer.class);
        return customerRepository.save(customer);
    }

    public Customer updateCustomer(ReceievedCustomer receievedCustomer){
        Customer customer=customerRepository.findById(receievedCustomer.getId()).orElse(null);
        if (customer==null) {
            customer = modelMapper.map(receievedCustomer, Customer.class);
            return customerRepository.save(customer);
        }
        modelMapper.map(receievedCustomer,customer);
        return customerRepository.save(customer);
    }



}
