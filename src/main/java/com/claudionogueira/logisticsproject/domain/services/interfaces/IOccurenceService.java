package com.claudionogueira.logisticsproject.domain.services.interfaces;

import java.util.List;

import com.claudionogueira.logisticsproject.api.dtos.OccurenceDTO;

public interface IOccurenceService {

	void register(Long deliveryID, String description);

	List<OccurenceDTO> findAll(Long deliveryID);
}
