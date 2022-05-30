package com.claudionogueira.logisticsproject.domain.services;

import java.time.OffsetDateTime;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.claudionogueira.logisticsproject.api.dtos.DeliveryDTO;
import com.claudionogueira.logisticsproject.api.dtos.inputs.DeliveryInput;
import com.claudionogueira.logisticsproject.domain.exceptions.ObjectNotFoundException;
import com.claudionogueira.logisticsproject.domain.models.Delivery;
import com.claudionogueira.logisticsproject.domain.models.Occurence;
import com.claudionogueira.logisticsproject.domain.models.enums.DeliveryStatus;
import com.claudionogueira.logisticsproject.domain.repositories.DeliveryRepo;
import com.claudionogueira.logisticsproject.domain.services.interfaces.IDeliveryService;
import com.claudionogueira.logisticsproject.domain.services.utils.CustomerMapper;
import com.claudionogueira.logisticsproject.domain.services.utils.DeliveryMapper;

@Service
public class DeliveryService implements IDeliveryService {

	private final DeliveryRepo deliveryRepo;
	private final DeliveryMapper deliveryMapper;
	private final CustomerMapper customerMapper;
	private final CustomerService customerService;

	public DeliveryService(DeliveryRepo deliveryRepo, DeliveryMapper deliveryMapper, CustomerMapper customerMapper,
			CustomerService customerService) {
		super();
		this.deliveryRepo = deliveryRepo;
		this.deliveryMapper = deliveryMapper;
		this.customerMapper = customerMapper;
		this.customerService = customerService;
	}

	@Transactional
	@Override
	public void add(DeliveryInput input) {
		Delivery entity = deliveryMapper.fromInputToEntity(input);

		entity.setCustomer(customerMapper.toEntity(customerService.findById(entity.getCustomer().getId())));
		entity.setRequestDate(OffsetDateTime.now());
		entity.setStatus(DeliveryStatus.PENDING);

		deliveryRepo.save(entity);
	}

	@Transactional
	@Override
	public List<DeliveryDTO> findAll() {
		return deliveryMapper.toListDTO(deliveryRepo.findAll());
	}

	@Transactional
	@Override
	public DeliveryDTO findById(Long id) {
		return deliveryRepo.findById(id).map(delivery -> deliveryMapper.toDTO(delivery))
				.orElseThrow(() -> new ObjectNotFoundException("Delivery with ID: '" + id + "' not found."));
	}

	@Transactional
	@Override
	public void addOccurence(Long deliveryID, String description) {
		Delivery delivery = deliveryMapper.fromDTOtoEntity(this.findById(deliveryID));
		delivery.addOccurence(new Occurence(null, delivery, description, OffsetDateTime.now()));
		deliveryRepo.save(delivery);
	}

	@Transactional
	@Override
	public void conclude(Long deliveryID) {
		Delivery entity = deliveryMapper.fromDTOtoEntity(this.findById(deliveryID));

		entity.conclude();

		deliveryRepo.save(entity);
	}
}
