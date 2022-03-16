package com.example.demo.service;

import com.example.demo.entity.Customer;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.repo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CustomerService {

    private final CustomerRepo customerRepo;

    @Autowired
    public CustomerService(CustomerRepo customerRepo){

        this.customerRepo = customerRepo;
    }

    public Customer addCustomer(Customer customer){
        customer.setId(UUID.randomUUID().toString());
        return customerRepo.save(customer);
    }

    public List<Customer> findAllCustomers(){

        return customerRepo.findAll();
    }

    public Customer updateCustomer(Customer customer){

        return customerRepo.save(customer);
    }

    public Customer findCustomerById(String id){

        return customerRepo.findCustomerById(id).orElseThrow(() -> new UserNotFoundException("Customer by id" + id + "was not found"));
    }

    public void deleteCustomer(String id){

        customerRepo.deleteCustomerById(id);
    }
}

