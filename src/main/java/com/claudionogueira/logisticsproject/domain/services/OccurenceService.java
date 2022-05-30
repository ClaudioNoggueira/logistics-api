package com.claudionogueira.logisticsproject.domain.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.claudionogueira.logisticsproject.api.dtos.OccurenceDTO;
import com.claudionogueira.logisticsproject.domain.exceptions.ObjectNotFoundException;
import com.claudionogueira.logisticsproject.domain.models.Delivery;
import com.claudionogueira.logisticsproject.domain.repositories.DeliveryRepo;
import com.claudionogueira.logisticsproject.domain.services.interfaces.IOccurenceService;
import com.claudionogueira.logisticsproject.domain.services.utils.OccurenceMapper;

@Service
public class OccurenceService implements IOccurenceService {

	private final DeliveryRepo deliveryRepo;
	private final DeliveryService deliveryService;
	private final OccurenceMapper occurenceMapper;

	public OccurenceService(DeliveryRepo deliveryRepo, DeliveryService deliveryService,
			OccurenceMapper occurenceMapper) {
		super();
		this.deliveryRepo = deliveryRepo;
		this.deliveryService = deliveryService;
		this.occurenceMapper = occurenceMapper;
	}

	@Transactional
	@Override
	public void register(Long deliveryID, String description) {
		deliveryService.addOccurence(deliveryID, description);
	}

	@Transactional
	@Override
	public List<OccurenceDTO> findAll(Long deliveryID) {
		Delivery entity = deliveryRepo.findById(deliveryID)
				.orElseThrow(() -> new ObjectNotFoundException("Delivery with ID: '" + deliveryID + "' not found."));

		return occurenceMapper.toListDTO(entity.getOccurences());
	}
}
