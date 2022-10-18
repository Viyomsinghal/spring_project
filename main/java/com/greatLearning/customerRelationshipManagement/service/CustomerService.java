package com.greatLearning.customerRelationshipManagement.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


import com.greatLearning.customerRelationshipManagement.entity.Customer;

//@Service
@Component("customerService")
public interface CustomerService {
	public List<Customer>findAll();

	 public void save(Customer theCustomer);
	 public void deleteById(int theId);

	public Customer findById(int theId);
}
