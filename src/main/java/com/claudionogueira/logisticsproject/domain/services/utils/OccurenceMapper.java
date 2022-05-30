package com.claudionogueira.logisticsproject.domain.services.utils;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.claudionogueira.logisticsproject.api.dtos.OccurenceDTO;
import com.claudionogueira.logisticsproject.domain.models.Occurence;

@Component
public class OccurenceMapper {

	private final ModelMapper mapper;

	public OccurenceMapper(ModelMapper mapper) {
		super();
		this.mapper = mapper;
	}

	public List<OccurenceDTO> toListDTO(List<Occurence> list) {
		return list.stream().map(occurence -> mapper.map(occurence, OccurenceDTO.class)).collect(Collectors.toList());
	}
}
