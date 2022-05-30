package com.claudionogueira.logisticsproject.domain.services.interfaces;

import java.util.List;

import com.claudionogueira.logisticsproject.api.dtos.OccurenceDTO;

public interface IOccurenceService {

	List<OccurenceDTO> findAll(Long deliveryID);

	void register(Long deliveryID, String description);
}
