package com.cg.customerjparest.controllers;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cg.customerjparest.dto.CreateCustomerRequest;
import com.cg.customerjparest.dto.CustomerDetails;
import com.cg.customerjparest.dto.UpdateCustomerRequest;
import com.cg.customerjparest.entities.Customer;
import com.cg.customerjparest.service.ICustomerService;

@RequestMapping("/customers")
@RestController
public class CustomerController {

    @Autowired
    private ICustomerService service;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/add")
    public CustomerDetails add(@RequestBody CreateCustomerRequest requestData) {
        Customer customer = new Customer(requestData.getName());
        customer = service.register(customer);
        CustomerDetails details = toDetails(customer);
        return details;
    }

    @PutMapping("/update")
    public CustomerDetails update(@RequestBody UpdateCustomerRequest requestData) {
        Customer customer = new Customer(requestData.getName());
        customer.setId(requestData.getId());
        customer = service.updateName(01, "Shreya");
        CustomerDetails details = toDetails(customer);
        return details;
    }

    @GetMapping
    public List<CustomerDetails> fetchAll() {
        List<Customer> students = service.findAll();
        // List<StudentDetails>response= students.stream().map(student->toDetails(student)).collect(Collectors.toList());
        List<CustomerDetails> response = toDetails(students);
        return response;
    }

    public List<CustomerDetails> toDetails(Collection<Customer> customers) {
        List<CustomerDetails> desired = new ArrayList<>();
        for (Customer customer : customers) {
            CustomerDetails details = toDetails(customer);
            desired.add(details);
        }
        return desired;
    }

    public CustomerDetails toDetails(Customer customer) {
        CustomerDetails details = new CustomerDetails(customer.getId(), customer.getName());
        return details;

    }


}
