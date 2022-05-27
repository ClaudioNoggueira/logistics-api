package com.claudionogueira.logisticsproject.domain.services.interfaces;

import java.util.List;

import com.claudionogueira.logisticsproject.api.dtos.DeliveryDTO;
import com.claudionogueira.logisticsproject.domain.models.Delivery;

public interface IDeliveryService {

	void add(Delivery entity);
	
	List<Delivery> findAll();
	
	DeliveryDTO findById(Long id);
}
