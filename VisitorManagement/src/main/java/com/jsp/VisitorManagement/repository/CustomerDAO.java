package com.jsp.VisitorManagement.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import com.jsp.VisitorManagement.dto.CustomerDTO;
import com.jsp.VisitorManagement.entity.Customer;

@Repository
public class CustomerDAO 
{
	@Autowired
	private CustomerRepository customerRepository;
	
	public Customer saveCustomer(Customer customer)
	{
		
		return customerRepository.save(customer);
	}
	public List<Customer> getAllVisitorData()
	{
		return customerRepository.findAll();
	}
	
	public Customer getVisitordatabyId(int id)
	{
		return customerRepository.findById(id).orElse(new Customer(HttpStatus.NOT_FOUND.value(),HttpStatus.NOT_FOUND.name(),HttpStatus.NOT_FOUND.name()));
	} 
	
	public Customer deletevisitorbyid(int id)
	{
		Customer customer = getVisitordatabyId(id);
		if(customer.getId()!=404)
		{
			return deletevisitorbyid(id);
		}
		return customer;
	}
	public List<Customer> getCustomerByName(String name)
	{
		return customerRepository.findByName(name);
	}
	
	public List<Customer> validatecustomer(String name,String email)
	{
		return customerRepository.validateCustomer(name, email);
	}
}
