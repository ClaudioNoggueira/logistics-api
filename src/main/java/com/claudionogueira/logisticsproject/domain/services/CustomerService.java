package com.claudionogueira.logisticsproject.domain.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.claudionogueira.logisticsproject.api.dtos.CustomerDTO;
import com.claudionogueira.logisticsproject.domain.exceptions.DomainException;
import com.claudionogueira.logisticsproject.domain.exceptions.ObjectNotFoundException;
import com.claudionogueira.logisticsproject.domain.models.Customer;
import com.claudionogueira.logisticsproject.domain.repositories.CustomerRepo;
import com.claudionogueira.logisticsproject.domain.services.interfaces.ICustomerService;
import com.claudionogueira.logisticsproject.domain.services.utils.CustomerMapper;

@Service
public class CustomerService implements ICustomerService {

	private final CustomerRepo repo;
	private final CustomerMapper mapper;

	public CustomerService(CustomerRepo repo, CustomerMapper mapper) {
		super();
		this.repo = repo;
		this.mapper = mapper;
	}

	@Override
	public List<CustomerDTO> findAll() {
		return mapper.toListDTO(repo.findAll());
	}

	@Override
	public CustomerDTO findById(Long id) {
		return repo.findById(id).map(entity -> mapper.toDTO(entity))
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
		Customer objToBeUpdated = mapper.toEntity(this.findById(id));

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
		Customer obj = mapper.toEntity(this.findById(id));
		repo.delete(obj);
	}
}
