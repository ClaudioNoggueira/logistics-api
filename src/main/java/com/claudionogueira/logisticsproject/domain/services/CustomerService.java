package com.claudionogueira.logisticsproject.domain.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.claudionogueira.logisticsproject.domain.exceptions.ObjectNotFoundException;
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
		return repo.findById(id).map(entity -> entity)
				.orElseThrow(() -> new ObjectNotFoundException("Customer with ID: '" + id + "' not found."));
	}

	@Override
	public void add(Customer entity) {
		repo.save(entity);
	}

	@Override
	public void update(Long id, Customer entity) {
		Customer objToBeUpdated = this.findById(id);
		objToBeUpdated.setName(entity.getName());
		objToBeUpdated.setEmail(entity.getEmail());
		objToBeUpdated.setPhone(entity.getPhone());
		repo.save(objToBeUpdated);
	}

	@Override
	public void delete(Long id) {
		Customer obj = this.findById(id);
		repo.delete(obj);
	}
}
