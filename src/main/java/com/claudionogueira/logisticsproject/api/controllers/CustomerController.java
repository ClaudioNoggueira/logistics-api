package com.claudionogueira.logisticsproject.api.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.claudionogueira.logisticsproject.domain.models.Customer;
import com.claudionogueira.logisticsproject.domain.services.CustomerService;

@RestController
@RequestMapping(value = "/api/v1/customers")
public class CustomerController {

	private final CustomerService service;

	public CustomerController(CustomerService service) {
		this.service = service;
	}

	@GetMapping()
	public List<Customer> findAll() {
		return service.findAll();
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Customer> findById(@PathVariable Long id) {
		return ResponseEntity.ok(service.findById(id));
	}

	@PostMapping(value = "/add")
	@ResponseStatus(value = HttpStatus.CREATED)
	public void add(@RequestBody Customer obj) {
		service.add(obj);
	}
}
