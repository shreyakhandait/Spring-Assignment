package org.cap.apps.customerbootjparest.controllers;

import java.util.List;

import org.cap.apps.customerbootjparest.dto.CreateCustomerRequest;
import org.cap.apps.customerbootjparest.dto.CustomerDetails;
import org.cap.apps.customerbootjparest.dto.UpdateCustomerDetails;
import org.cap.apps.customerbootjparest.entities.Customer;
import org.cap.apps.customerbootjparest.service.ICustomerService;
import org.cap.apps.customerbootjparest.util.CustomerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@Validated
@RequestMapping("/customers")
@RestController
public class CustomerController {
	
	@Autowired
	private ICustomerService service;
	
	@Autowired
	private CustomerUtil customerUtil;
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/add")
	
	public CustomerDetails add(@RequestBody CreateCustomerRequest requestData) {
		Customer customer = new Customer(requestData.getFirstName(),requestData.getLastName());
		customer = service.register(customer);
		CustomerDetails details=customerUtil.toDetails(customer);
		return details;
	}
	

	@PutMapping("/update")
	public CustomerDetails update(@RequestBody UpdateCustomerDetails requestData) {
		String fname=requestData.getFirstName();
		String lname=requestData.getLastName();
		long id=requestData.getId();
		Customer customer = service.updateName(id, fname,lname);
		CustomerDetails details=customerUtil.toDetails(customer);
		return details;
	}
	
	 
	 @GetMapping("/by/firstname/{name}")
	    public List<CustomerDetails> findByFirstName(@PathVariable("name") String name) {
	        List<Customer> customer = service.findByFirstName(name);
	        List<CustomerDetails> response = customerUtil.toDetails(customer);
	        return response;
	    }
	 
	
	 @GetMapping("/by/laststname/{name}")
	    public List<CustomerDetails> findByLastName(@PathVariable("name") String name) {
	        List<Customer> customer = service.findByLastName(name);
	        List<CustomerDetails> response = customerUtil.toDetails(customer);
	        return response;
	    }
	 
	  @GetMapping
	    public List<CustomerDetails> fetchAll() {
	        List<Customer> customers = service.findAll();
	        List<CustomerDetails> response = customerUtil.toDetails(customers);
	        return response;
	    }
	
	
}
