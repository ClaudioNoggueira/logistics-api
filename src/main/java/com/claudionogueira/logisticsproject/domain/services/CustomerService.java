package com.claudionogueira.logisticsproject.domain.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.claudionogueira.logisticsproject.api.dtos.CustomerDTO;
import com.claudionogueira.logisticsproject.api.dtos.inputs.CustomerInput;
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
	public void add(CustomerInput input) {
		Customer entity = mapper.fromInputToEntity(input);
		boolean emailExists = repo.findByEmail(entity.getEmail()).stream()
				.anyMatch(existingCustomer -> !existingCustomer.equals(entity));

		if (emailExists)
			throw new DomainException("Email is already in use.");

		repo.save(mapper.fromInputToEntity(input));
	}

	@Override
	public void update(Long id, CustomerInput input) {
		Customer objToBeUpdated = mapper.toEntity(this.findById(id));

		if (input.getName() != null && !input.getName().isBlank())
			objToBeUpdated.setName(input.getName());

		if (input.getEmail() != null && !input.getEmail().isBlank())
			objToBeUpdated.setEmail(input.getEmail());

		if (input.getPhone() != null && !input.getPhone().isBlank())
			objToBeUpdated.setPhone(input.getPhone());

		repo.save(objToBeUpdated);
	}

	@Override
	public void delete(Long id) {
		Customer obj = mapper.toEntity(this.findById(id));
		repo.delete(obj);
	}
}
