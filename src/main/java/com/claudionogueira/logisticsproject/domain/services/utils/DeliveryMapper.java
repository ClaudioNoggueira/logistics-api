package com.claudionogueira.logisticsproject.domain.services.utils;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.claudionogueira.logisticsproject.api.dtos.DeliveryDTO;
import com.claudionogueira.logisticsproject.domain.models.Delivery;

@Component
public class DeliveryMapper {

	private final ModelMapper mapper;

	public DeliveryMapper(ModelMapper mapper) {
		this.mapper = mapper;
	}

	public DeliveryDTO toDTO(Delivery entity) {
		return mapper.map(entity, DeliveryDTO.class);
	}
}
