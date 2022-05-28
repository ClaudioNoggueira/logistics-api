package com.claudionogueira.logisticsproject.domain.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.claudionogueira.logisticsproject.api.dtos.CustomerDTO;
import com.claudionogueira.logisticsproject.api.dtos.inputs.CustomerInput;
import com.claudionogueira.logisticsproject.api.dtos.updates.CustomerUpdate;
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
	public void update(Long id, CustomerUpdate update) {
		Customer objToBeUpdated = mapper.toEntity(this.findById(id));

		if (update.getName() != null && !update.getName().isBlank()) {
			objToBeUpdated.setName(update.getName());
		}

		if (update.getEmail() != null && !update.getEmail().isBlank()) {
			boolean emailExists = repo.findByEmail(update.getEmail()).stream()
					.anyMatch(existingCustomer -> !existingCustomer.equals(objToBeUpdated));
			if (emailExists)
				throw new DomainException("Email is already in use.");

			objToBeUpdated.setEmail(update.getEmail());
		}

		if (update.getPhone() != null && !update.getPhone().isBlank())
			objToBeUpdated.setPhone(update.getPhone());

		repo.save(objToBeUpdated);
	}

	@Override
	public void delete(Long id) {
		Customer obj = mapper.toEntity(this.findById(id));
		repo.delete(obj);
	}
}
