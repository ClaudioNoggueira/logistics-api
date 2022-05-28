package com.claudionogueira.logisticsproject.domain.services.utils;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {

	private final ModelMapper mapper;

	public CustomerMapper(ModelMapper mapper) {
		super();
		this.mapper = mapper;
	}

}
