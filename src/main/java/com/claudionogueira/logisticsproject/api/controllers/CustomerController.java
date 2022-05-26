package com.claudionogueira.logisticsproject.api.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.claudionogueira.logisticsproject.domain.services.CustomerService;

@RestController
@RequestMapping(value = "/api/v1/customers")
public class CustomerController {

	private final CustomerService service;

	public CustomerController(CustomerService service) {
		this.service = service;
	}
}
