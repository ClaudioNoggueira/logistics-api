package com.claudionogueira.logisticsproject.domain.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.claudionogueira.logisticsproject.domain.models.Customer;
import com.claudionogueira.logisticsproject.domain.repositories.CustomerRepo;
import com.claudionogueira.logisticsproject.domain.services.interfaces.ICustomerService;

@Service
public class CustomerService implements ICustomerService {

	private final CustomerRepo repo;

	public CustomerService(CustomerRepo repo) {
		this.repo = repo;
	}

	@Override
	public List<Customer> findAll() {
		return repo.findAll();
	}

	@Override
	public Customer findById(Long id) {
		return repo.findById(id).map(customer -> customer).orElse(null);
	}

}
