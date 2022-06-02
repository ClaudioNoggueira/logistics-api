package com.claudionogueira.logisticsproject.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.claudionogueira.logisticsproject.api.dtos.DeliveryDTO;
import com.claudionogueira.logisticsproject.api.dtos.inputs.DeliveryInput;
import com.claudionogueira.logisticsproject.domain.services.DeliveryService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "*")
@Api(value = "RESTful API for a logistics project")
@RestController
@RequestMapping(value = "/api/v1/deliveries")
public class DeliveryController {

	private final DeliveryService service;

	public DeliveryController(DeliveryService service) {
		this.service = service;
	}

	@ApiOperation(value = "Return list of all deliveries")
	@GetMapping()
	public List<DeliveryDTO> findAll() {
		return service.findAll();
	}

	@ApiOperation(value = "Return one delivery based on it's ID")
	@GetMapping(value = "/{id}")
	public ResponseEntity<DeliveryDTO> findById(@PathVariable Long id) {
		return ResponseEntity.ok(service.findById(id));
	}

	@ApiOperation(value = "Add new delivery")
	@PostMapping(value = "/add")
	@ResponseStatus(value = HttpStatus.CREATED)
	public void add(@Valid @RequestBody DeliveryInput input) {
		service.add(input);
	}

	@ApiOperation(value = "Conclude delivery based on it's ID")
	@PutMapping(value = "/{id}/conclusion")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void conclude(@PathVariable Long id) {
		service.conclude(id);
	}
}
