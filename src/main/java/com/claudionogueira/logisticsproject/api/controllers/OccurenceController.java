package com.claudionogueira.logisticsproject.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.claudionogueira.logisticsproject.api.dtos.OccurenceDTO;
import com.claudionogueira.logisticsproject.api.dtos.inputs.OccurenceInput;
import com.claudionogueira.logisticsproject.domain.services.OccurenceService;

@RestController
@RequestMapping(value = "/api/v1/deliveries/{deliveryId}/occurences")
public class OccurenceController {

	private final OccurenceService service;

	public OccurenceController(OccurenceService service) {
		super();
		this.service = service;
	}

	@GetMapping
	public List<OccurenceDTO> findAll(@PathVariable Long deliveryId) {
		return service.findAll(deliveryId);
	}

	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public void register(@PathVariable Long deliveryId, @Valid @RequestBody OccurenceInput input) {
		service.register(deliveryId, input.getDescription());
	}
}
