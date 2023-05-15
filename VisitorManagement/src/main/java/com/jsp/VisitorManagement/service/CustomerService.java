package com.jsp.VisitorManagement.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.jsp.VisitorManagement.dto.CustomerDTO;
import com.jsp.VisitorManagement.dto.ResponseStructure;
import com.jsp.VisitorManagement.entity.Customer;
import com.jsp.VisitorManagement.repository.CustomerDAO;
import com.jsp.VisitorManagement.repository.CustomerRepository;

@Service

public class CustomerService 
{
	@Autowired
	private CustomerDAO customerDAO;
	
	public ResponseStructure<Customer> saveCustomer(CustomerDTO customer)
	{
		 Customer customer2 = new Customer(customer);
		  Customer saveCustomer = customerDAO.saveCustomer(customer2);
		 ResponseStructure<Customer> rs=new ResponseStructure<>();
		 rs.setData(saveCustomer);
		 rs.setStatuscode(HttpStatus.OK.value());
		 rs.setMessage("customer data saved successfully");
		 rs.setTimestamp(LocalDateTime.now());
		 
		 return rs;
	}
	
	public ResponseStructure<Customer> updateCustomer(Customer customer)
	{
		Customer customer2 = customerDAO.saveCustomer(customer);
		ResponseStructure<Customer> structure = new ResponseStructure<Customer>();
		structure.setData(customer2);
		structure.setStatuscode(HttpStatus.ACCEPTED.value());
		structure.setTimestamp(LocalDateTime.now());
		structure.setMessage(HttpStatus.ACCEPTED.name());
		
		return structure;
	}
	
	public ResponseStructure<List<Customer>> findallcustomer()
	{
		 List<Customer> list = customerDAO.getAllVisitorData();
		 
		 ResponseStructure<List<Customer>> rs=new ResponseStructure<List<Customer>>();
		 if(list.size()!=0)
		 {
			 rs.setData(list);
			 rs.setStatuscode(HttpStatus.FOUND.value());
			 rs.setTimestamp(LocalDateTime.now());
			 rs.setMessage("customer entry found in database");
		 }
		 return rs;
	}
	
	public Customer deletevisitorbyId(int id)
	{
		return customerDAO.deletevisitorbyid(id);
	}
	
	public List<Customer> getcustomerByName(String name)
	{
		return customerDAO.getCustomerByName(name);
	}
	
	public List<Customer> validatecustomer(String name,String email)
	{
		return customerDAO.validatecustomer(name, email);
	}
	
}
