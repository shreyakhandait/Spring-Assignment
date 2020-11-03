package org.cap.apps.customerbootjparest.service;

import java.util.List;

import org.cap.apps.customerbootjparest.entities.Customer;

public interface ICustomerService {
	
	Customer register(Customer customer);
	
	Customer updateName(long id, String firstName, String lastName);
	
	List<Customer> findByFirstName(String name);

	List<Customer> findByLastName(String name);
	
	public List<Customer> findAll();
	
}
