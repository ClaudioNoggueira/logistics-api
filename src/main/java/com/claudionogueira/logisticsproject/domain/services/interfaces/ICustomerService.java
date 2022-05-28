package com.claudionogueira.logisticsproject.domain.services.interfaces;

import java.util.List;

import com.claudionogueira.logisticsproject.api.dtos.CustomerDTO;
import com.claudionogueira.logisticsproject.api.dtos.inputs.CustomerInput;

public interface ICustomerService {

	List<CustomerDTO> findAll();

	CustomerDTO findById(Long id);

	void add(CustomerInput input);

	void update(Long id, CustomerInput input);

	void delete(Long id);
}
