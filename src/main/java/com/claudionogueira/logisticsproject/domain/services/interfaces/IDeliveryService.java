package com.claudionogueira.logisticsproject.domain.services.interfaces;

import java.util.List;

import com.claudionogueira.logisticsproject.api.dtos.DeliveryDTO;
import com.claudionogueira.logisticsproject.api.dtos.inputs.DeliveryInput;

public interface IDeliveryService {

	void add(DeliveryInput entity);
	
	void addOccurence(Long deliveryID, String description);
	
	void conclude(Long deliveryID);
	
	List<DeliveryDTO> findAll();
	
	DeliveryDTO findById(Long id);
}
