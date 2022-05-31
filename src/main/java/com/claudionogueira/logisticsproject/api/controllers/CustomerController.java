package com.claudionogueira.logisticsproject.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.claudionogueira.logisticsproject.api.dtos.CustomerDTO;
import com.claudionogueira.logisticsproject.api.dtos.inputs.CustomerInput;
import com.claudionogueira.logisticsproject.api.dtos.updates.CustomerUpdate;
import com.claudionogueira.logisticsproject.domain.services.CustomerService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "RESTful API for a logistics project")
@RestController
@RequestMapping(value = "/api/v1/customers")
public class CustomerController {

	private final CustomerService service;

	public CustomerController(CustomerService service) {
		this.service = service;
	}

	@ApiOperation(value = "Return list of all customers")
	@GetMapping()
	public List<CustomerDTO> findAll() {
		return service.findAll();
	}

	@ApiOperation(value = "Return one customer based on it's ID")
	@GetMapping(value = "/{id}")
	public ResponseEntity<CustomerDTO> findById(@PathVariable Long id) {
		return ResponseEntity.ok(service.findById(id));
	}

	@ApiOperation(value = "Add new customer")
	@PostMapping(value = "/add")
	@ResponseStatus(value = HttpStatus.CREATED)
	public void add(@Valid @RequestBody CustomerInput input) {
		service.add(input);
	}

	@ApiOperation(value = "Update customer info based on it's ID")
	@PutMapping(value = "/update/{id}")
	public void update(@PathVariable Long id, @Valid @RequestBody CustomerUpdate update) {
		service.update(id, update);
	}

	@ApiOperation(value = "Delete customer based on it's ID")
	@DeleteMapping(value = "/{id}")
	public void delete(@PathVariable Long id) {
		service.delete(id);
	}
}
