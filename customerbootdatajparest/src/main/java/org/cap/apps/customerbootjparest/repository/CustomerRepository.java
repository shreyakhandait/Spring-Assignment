package org.cap.apps.customerbootjparest.repository;

import java.util.List;

import org.cap.apps.customerbootjparest.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CustomerRepository extends JpaRepository<Customer, Long>{
	
	 @Query("from Customer where firstName=:fname")
	 List<Customer> findByFirstName(@Param("fname") String name);


	 List<Customer> findByLastName(String name);


}
