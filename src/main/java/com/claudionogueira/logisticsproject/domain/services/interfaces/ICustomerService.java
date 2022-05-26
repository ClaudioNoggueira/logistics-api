package com.claudionogueira.logisticsproject.domain.services.interfaces;

import java.util.List;

import com.claudionogueira.logisticsproject.domain.models.Customer;

public interface ICustomerService {

	List<Customer> findAll();
	
	Customer findById(Long id);
	
	void add(Customer entity);
}
