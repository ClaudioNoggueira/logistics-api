package com.claudionogueira.logisticsproject.api.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.claudionogueira.logisticsproject.domain.services.OccurenceService;

@RestController
@RequestMapping(value = "/api/v1/deliveries/{id}/occurences")
public class OccurenceController {

	private final OccurenceService service;

	public OccurenceController(OccurenceService service) {
		super();
		this.service = service;
	}

}
