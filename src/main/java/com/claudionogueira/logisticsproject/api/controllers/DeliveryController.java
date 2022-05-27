package com.claudionogueira.logisticsproject.api.controllers;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.claudionogueira.logisticsproject.domain.models.Delivery;
import com.claudionogueira.logisticsproject.domain.services.DeliveryService;

@RestController
@RequestMapping(value = "/api/v1/deliveries")
public class DeliveryController {

	private final DeliveryService service;

	public DeliveryController(DeliveryService service) {
		this.service = service;
	}

	@PostMapping(value = "/add")
	@ResponseStatus(value = HttpStatus.CREATED)
	public void add(@Valid @RequestBody Delivery entity) {
		service.add(entity);
	}
}
