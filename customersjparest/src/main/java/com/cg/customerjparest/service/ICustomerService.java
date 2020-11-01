package com.cg.customerjparest.service;

import java.util.List;

import com.cg.customerjparest.entities.Customer;

public interface ICustomerService {

	Customer register(Customer customer);
	
	Customer updateName(long id,String name);
	
	List<Customer>findAll();
	
}
