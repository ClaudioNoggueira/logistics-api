package com.claudionogueira.logisticsproject.api.controllers;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.claudionogueira.logisticsproject.api.dtos.inputs.OccurenceInput;
import com.claudionogueira.logisticsproject.domain.services.OccurenceService;

@RestController
@RequestMapping(value = "/api/v1/deliveries/{id}/occurences")
public class OccurenceController {

	private final OccurenceService service;

	public OccurenceController(OccurenceService service) {
		super();
		this.service = service;
	}

	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public void register(@PathVariable Long id, @Valid @RequestBody OccurenceInput input) {
		service.register(id, input.getDescription());
	}
}
