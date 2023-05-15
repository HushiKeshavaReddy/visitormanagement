package com.jsp.VisitorManagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jsp.VisitorManagement.dto.CustomerDTO;
import com.jsp.VisitorManagement.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Integer>
{	
	List<Customer> findByName(String name);
		               
	@Query(" select c from Customer c where c.name=:name AND c.email=:email ")
	List<Customer> validateCustomer(@Param("name") String name,@Param("email") String email);
}
