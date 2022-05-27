package com.claudionogueira.logisticsproject.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.claudionogueira.logisticsproject.api.dtos.DeliveryDTO;
import com.claudionogueira.logisticsproject.domain.models.Delivery;
import com.claudionogueira.logisticsproject.domain.services.DeliveryService;

@RestController
@RequestMapping(value = "/api/v1/deliveries")
public class DeliveryController {

	private final DeliveryService service;

	public DeliveryController(DeliveryService service) {
		this.service = service;
	}

	@GetMapping()
	public List<Delivery> findAll() {
		return service.findAll();
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<DeliveryDTO> findById(@PathVariable Long id) {
		return ResponseEntity.ok(service.findById(id));
	}

	@PostMapping(value = "/add")
	@ResponseStatus(value = HttpStatus.CREATED)
	public void add(@Valid @RequestBody Delivery entity) {
		service.add(entity);
	}
}
