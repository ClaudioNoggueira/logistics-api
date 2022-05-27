package com.claudionogueira.logisticsproject.domain.services;

import org.springframework.stereotype.Service;

import com.claudionogueira.logisticsproject.domain.repositories.DeliveryRepo;
import com.claudionogueira.logisticsproject.domain.services.interfaces.IDeliveryService;

@Service
public class DeliveryService implements IDeliveryService {

	private final DeliveryRepo repo;

	public DeliveryService(DeliveryRepo repo) {
		this.repo = repo;
	}
}
