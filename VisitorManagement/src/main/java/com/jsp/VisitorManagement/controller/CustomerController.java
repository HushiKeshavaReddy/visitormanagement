package com.jsp.VisitorManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.VisitorManagement.dto.CustomerDTO;
import com.jsp.VisitorManagement.dto.ResponseStructure;
import com.jsp.VisitorManagement.entity.Customer;
import com.jsp.VisitorManagement.service.CustomerService;

@RestController
public class CustomerController 
{
	@Autowired
	private CustomerService customerService;
	
	@PostMapping("/visitordetails")
	public @ResponseBody ResponseStructure<Customer> saveCustomer(@RequestBody CustomerDTO customer)
	{
		
		return customerService.saveCustomer(customer);
	}
	
	@PutMapping("/visitordetails")
	public @ResponseBody ResponseStructure<Customer> updateCustomer(@RequestBody Customer customer)
	{
		return customerService.updateCustomer(customer);
	}
	@GetMapping("/getallvisitordata")
	public @ResponseBody ResponseStructure<List<Customer>> findAll()
	{
		return customerService.findallcustomer();
	}
	
	@GetMapping("/deletevisitorbyId/{id}")
	public @ResponseBody Customer deletevisitorbyid(@PathVariable("id") int id)
	{
		return customerService.deletevisitorbyId(id);
	}
	
	@GetMapping("/customer/{name}")
	public @ResponseBody List<Customer> getCustomerByName(@PathVariable("name") String name)
	{
		return customerService.getcustomerByName(name);
	}
	
	@PostMapping("/validatecustomer")
	public List<Customer> validateCustomer(@RequestParam("name") String name,@RequestParam("email") String email)
	{
		return customerService.validatecustomer(name, email);
	}
}
