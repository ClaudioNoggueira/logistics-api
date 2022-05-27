package com.claudionogueira.logisticsproject.domain.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.claudionogueira.logisticsproject.domain.exceptions.DomainException;
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
		boolean emailExists = repo.findByEmail(entity.getEmail()).stream()
				.anyMatch(existingCustomer -> !existingCustomer.equals(entity));

		if (emailExists)
			throw new DomainException("Email is already in use.");

		repo.save(entity);
	}

	@Override
	public void update(Long id, Customer entity) {
		Customer objToBeUpdated = this.findById(id);

		if (entity.getName() != null && !entity.getName().isBlank())
			objToBeUpdated.setName(entity.getName());

		if (entity.getEmail() != null && !entity.getEmail().isBlank())
			objToBeUpdated.setEmail(entity.getEmail());

		if (entity.getPhone() != null && !entity.getPhone().isBlank())
			objToBeUpdated.setPhone(entity.getPhone());

		repo.save(objToBeUpdated);
	}

	@Override
	public void delete(Long id) {
		Customer obj = this.findById(id);
		repo.delete(obj);
	}
}
