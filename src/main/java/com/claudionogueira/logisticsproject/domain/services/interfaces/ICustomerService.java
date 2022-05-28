package com.claudionogueira.logisticsproject.domain.services.interfaces;

import java.util.List;

import com.claudionogueira.logisticsproject.api.dtos.CustomerDTO;
import com.claudionogueira.logisticsproject.domain.models.Customer;

public interface ICustomerService {

	List<CustomerDTO> findAll();

	CustomerDTO findById(Long id);

	void add(Customer entity);

	void update(Long id, Customer entity);

	void delete(Long id);
}
