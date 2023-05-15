package com.jsp.VisitorManagement.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.jsp.VisitorManagement.dto.CustomerDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "customer_info")
public class Customer implements Serializable
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable = false)
	private String name;
	
	private String email;
    public Customer()
    {
    	
    }
	public Customer(Integer id, String name, String email) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
	}

	public Customer(CustomerDTO dto)
	{
		this.id=dto.getId();
		this.name=dto.getName();
		this.email=dto.getEmail();
	}
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
