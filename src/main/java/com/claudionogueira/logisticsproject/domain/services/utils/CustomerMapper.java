package com.claudionogueira.logisticsproject.domain.services.utils;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.claudionogueira.logisticsproject.api.dtos.CustomerDTO;
import com.claudionogueira.logisticsproject.domain.models.Customer;

@Component
public class CustomerMapper {

	private final ModelMapper mapper;

	public CustomerMapper(ModelMapper mapper) {
		super();
		this.mapper = mapper;
	}

	public CustomerDTO toDTO(Customer entity) {
		return mapper.map(entity, CustomerDTO.class);
	}

	public Customer toEntity(CustomerDTO dto) {
		return mapper.map(dto, Customer.class);
	}
}
