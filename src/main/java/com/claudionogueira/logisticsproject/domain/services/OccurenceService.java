package com.claudionogueira.logisticsproject.domain.services;

import java.time.OffsetDateTime;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.claudionogueira.logisticsproject.domain.models.Delivery;
import com.claudionogueira.logisticsproject.domain.models.Occurence;
import com.claudionogueira.logisticsproject.domain.services.interfaces.IOccurenceService;
import com.claudionogueira.logisticsproject.domain.services.utils.DeliveryMapper;

@Service
public class OccurenceService implements IOccurenceService {

	private final DeliveryService deliveryService;
	private final DeliveryMapper deliveryMapper;

	public OccurenceService(DeliveryService deliveryService, DeliveryMapper deliveryMapper) {
		super();
		this.deliveryService = deliveryService;
		this.deliveryMapper = deliveryMapper;
	}

	@Transactional
	@Override
	public void register(Long deliveryID, String description) {
		Delivery delivery = deliveryMapper.fromDTOtoEntity(deliveryService.findById(deliveryID));
		delivery.addOccurence(new Occurence(null, delivery, description, OffsetDateTime.now()));
	}
}
