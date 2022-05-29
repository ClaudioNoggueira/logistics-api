package com.claudionogueira.logisticsproject.domain.services.utils;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.claudionogueira.logisticsproject.api.dtos.DeliveryDTO;
import com.claudionogueira.logisticsproject.api.dtos.inputs.DeliveryInput;
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

	public Delivery fromDTOtoEntity(DeliveryDTO dto) {
		return mapper.map(dto, Delivery.class);
	}

	public Delivery fromInputToEntity(DeliveryInput input) {
		return mapper.map(input, Delivery.class);
	}

	public List<DeliveryDTO> toListDTO(List<Delivery> deliveries) {
		return deliveries.stream().map(this::toDTO).collect(Collectors.toList());
	}
}
