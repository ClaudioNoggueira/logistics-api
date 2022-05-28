package com.claudionogueira.logisticsproject.domain.services;

import java.time.OffsetDateTime;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.claudionogueira.logisticsproject.api.dtos.DeliveryDTO;
import com.claudionogueira.logisticsproject.domain.exceptions.ObjectNotFoundException;
import com.claudionogueira.logisticsproject.domain.models.Delivery;
import com.claudionogueira.logisticsproject.domain.models.enums.DeliveryStatus;
import com.claudionogueira.logisticsproject.domain.repositories.DeliveryRepo;
import com.claudionogueira.logisticsproject.domain.services.interfaces.IDeliveryService;
import com.claudionogueira.logisticsproject.domain.services.utils.DeliveryMapper;

@Service
public class DeliveryService implements IDeliveryService {

	private final DeliveryRepo deliveryRepo;
	private final CustomerService customerService;
	private final DeliveryMapper deliveryMapper;

	public DeliveryService(DeliveryRepo deliveryRepo, CustomerService customerService, DeliveryMapper deliveryMapper) {
		this.deliveryRepo = deliveryRepo;
		this.customerService = customerService;
		this.deliveryMapper = deliveryMapper;
	}

	@Transactional
	@Override
	public void add(Delivery entity) {
		entity.setCustomer(customerService.findById(entity.getCustomer().getId()));
		entity.setRequestDate(OffsetDateTime.now());
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
	public DeliveryDTO findById(Long id) {
		return deliveryRepo.findById(id).map(delivery -> deliveryMapper.toDTO(delivery))
				.orElseThrow(() -> new ObjectNotFoundException("Delivery with ID: '" + id + "' not found."));
	}

}
