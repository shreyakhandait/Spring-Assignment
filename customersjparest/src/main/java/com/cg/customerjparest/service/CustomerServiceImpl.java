package com.cg.customerjparest.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.cg.customerjparest.dao.ICustomerDao;
import com.cg.customerjparest.entities.Customer;
import com.cg.customerjparest.util.ValidationUtil;

import java.util.List;

import javax.persistence.EntityManager;

@Transactional
@Service
public class CustomerServiceImpl implements ICustomerService {
    private static final Logger Log= LoggerFactory.getLogger(CustomerServiceImpl.class);
    @Autowired
    private ICustomerDao dao;


    @Override
    public Customer register(Customer customer) {
        ValidationUtil.checkArgumentNotNull(customer);
        ValidationUtil.checkName(customer.getName());
        customer = dao.add(customer);
        return customer;
    }


	@Override
	public Customer updateName(long id, String name) {
		Customer customer=dao.findById(id);
		ValidationUtil.checkName(name);
		customer.setId(id);
		customer.setName(name);
        customer=dao.update(customer);
        return customer;
	}
	
	  @Override
	    public List<Customer> findAll() {
	        List<Customer> list = dao.findAll();
	        return list;
	    }



}
