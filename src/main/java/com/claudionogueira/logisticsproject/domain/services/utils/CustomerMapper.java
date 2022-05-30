package com.claudionogueira.logisticsproject.domain.services.utils;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.claudionogueira.logisticsproject.api.dtos.CustomerDTO;
import com.claudionogueira.logisticsproject.api.dtos.inputs.CustomerInput;
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

	public Customer fromInputToEntity(CustomerInput input) {
		return mapper.map(input, Customer.class);
	}

	public List<CustomerDTO> toListDTO(List<Customer> list) {
		return list.stream().map(this::toDTO).collect(Collectors.toList());
	}
}
