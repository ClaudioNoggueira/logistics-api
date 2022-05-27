package com.claudionogueira.logisticsproject.domain.services;

import java.time.LocalDateTime;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.claudionogueira.logisticsproject.domain.exceptions.ObjectNotFoundException;
import com.claudionogueira.logisticsproject.domain.models.Delivery;
import com.claudionogueira.logisticsproject.domain.models.enums.DeliveryStatus;
import com.claudionogueira.logisticsproject.domain.repositories.DeliveryRepo;
import com.claudionogueira.logisticsproject.domain.services.interfaces.IDeliveryService;

@Service
public class DeliveryService implements IDeliveryService {

	private final DeliveryRepo deliveryRepo;
	private final CustomerService customerService;

	public DeliveryService(DeliveryRepo deliveryRepo, CustomerService customerService) {
		this.deliveryRepo = deliveryRepo;
		this.customerService = customerService;
	}

	@Transactional
	@Override
	public void add(Delivery entity) {
		entity.setCustomer(customerService.findById(entity.getCustomer().getId()));
		entity.setRequestDate(LocalDateTime.now());
		entity.setStatus(DeliveryStatus.PENDING);
		deliveryRepo.save(entity);
	}

	@Transactional
	@Override
	public List<Delivery> findAll() {
		return deliveryRepo.findAll();
	}

	@Transactional
	@Override
	public Delivery findById(Long id) {
		return deliveryRepo.findById(id).map(delivery -> delivery)
				.orElseThrow(() -> new ObjectNotFoundException("Delivery with ID: '" + id + "' not found."));
	}

}
