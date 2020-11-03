package org.cap.apps.customerbootjparest.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.cap.apps.customerbootjparest.dto.CustomerDetails;
import org.cap.apps.customerbootjparest.entities.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerUtil {
	  public List<CustomerDetails> toDetails(Collection<Customer> customers) {
	        List<CustomerDetails> desired = new ArrayList<>();
	        for (Customer customer : customers) {
	            CustomerDetails details = toDetails(customer);
	            desired.add(details);
	        }
	        return desired;
	    }

	    public CustomerDetails toDetails(Customer customer) {
	    	CustomerDetails details = new CustomerDetails(customer.getId(), customer.getFirstName(), customer.getLastName());
	        return details;

	    }

}
