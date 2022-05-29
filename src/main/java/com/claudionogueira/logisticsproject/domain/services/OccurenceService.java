package com.claudionogueira.logisticsproject.domain.services;

import org.springframework.stereotype.Service;

import com.claudionogueira.logisticsproject.domain.repositories.DeliveryRepo;
import com.claudionogueira.logisticsproject.domain.services.interfaces.IOccurenceService;

@Service
public class OccurenceService implements IOccurenceService {

	private final DeliveryRepo deliveryRepo;

	public OccurenceService(DeliveryRepo deliveryRepo) {
		super();
		this.deliveryRepo = deliveryRepo;
	}
}
