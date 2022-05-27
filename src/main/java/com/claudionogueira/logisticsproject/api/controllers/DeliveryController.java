package com.claudionogueira.logisticsproject.api.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.claudionogueira.logisticsproject.domain.services.DeliveryService;

@RestController
@RequestMapping(value = "/delivery")
public class DeliveryController {

	private final DeliveryService service;

	public DeliveryController(DeliveryService service) {
		this.service = service;
	}
}
