package com.claudionogueira.logisticsproject.domain.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.claudionogueira.logisticsproject.api.dtos.OccurenceDTO;
import com.claudionogueira.logisticsproject.domain.models.Delivery;
import com.claudionogueira.logisticsproject.domain.services.interfaces.IOccurenceService;
import com.claudionogueira.logisticsproject.domain.services.utils.DeliveryMapper;
import com.claudionogueira.logisticsproject.domain.services.utils.OccurenceMapper;

@Service
public class OccurenceService implements IOccurenceService {

	private final DeliveryService deliveryService;
	private final DeliveryMapper deliveryMapper;
	private final OccurenceMapper occurenceMapper;

	public OccurenceService(DeliveryService deliveryService, DeliveryMapper deliveryMapper,
			OccurenceMapper occurenceMapper) {
		super();
		this.deliveryService = deliveryService;
		this.deliveryMapper = deliveryMapper;
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
		Delivery entity = deliveryMapper.fromDTOtoEntity(deliveryService.findById(deliveryID));
		return occurenceMapper.toListDTO(entity.getOccurences());
	}
}
