package org.cap.apps.customerbootjparest.service;

import java.util.List;

import javax.transaction.Transactional;

import org.cap.apps.customerbootjparest.entities.Customer;
import org.cap.apps.customerbootjparest.exceptions.CustomerAlreadyExistsException;
import org.cap.apps.customerbootjparest.repository.CustomerRepository;
import org.cap.apps.customerbootjparest.util.ValidationUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Transactional
@Service
public class CustomerServiceImpl implements ICustomerService{
//	private static final Logger Log = LoggerFactory.getLogger(CustomerServiceImpl.class);
	@Autowired
	private CustomerRepository repository; 
	
	@Override
	public Customer register(Customer customer) {
		ValidationUtil.checkArgumentNotNull(customer);
		ValidationUtil.checkName(customer.getFirstName());
		ValidationUtil.checkName(customer.getLastName());
		Long id=customer.getId();
		 boolean exists= id!= null && repository.existsById(customer.getId());
	        if(exists){
	            throw new CustomerAlreadyExistsException("student already exists for id="+customer.getId());
	        }
		customer=repository.save(customer);
		return customer;
	}

	@Override
	public Customer updateName(long id, String firstName, String lastName) {
		ValidationUtil.checkName(firstName);
		ValidationUtil.checkName(lastName);
		Customer customer=new Customer();
		customer.setId(id);
		customer.setFirstName(firstName);
		customer.setLastName(lastName);
		customer=repository.save(customer);
		return customer;
	}

	@Override
	public List<Customer> findByFirstName(String firstName) {
		ValidationUtil.checkName(firstName);
		 List<Customer> customer=repository.findByFirstName(firstName);
		return customer;
	}

	@Override
	public List<Customer> findByLastName(String lastName) {
		ValidationUtil.checkName(lastName);
		List<Customer> customer=repository.findByFirstName(lastName);
		return customer;
	}
	@Override
	public List<Customer> findAll() {
	    List<Customer> list = repository.findAll();
	    return list;
	}

}
