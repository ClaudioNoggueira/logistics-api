package com.claudionogueira.logisticsproject.api.dtos;

import java.time.OffsetDateTime;

public class OccurenceDTO {

	private Long id;
	private String description;
	private OffsetDateTime registerDate;

	public OccurenceDTO() {

	}

	public OccurenceDTO(Long id, String description, OffsetDateTime registerDate) {
		super();
		this.id = id;
		this.description = description;
		this.registerDate = registerDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public OffsetDateTime getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(OffsetDateTime registerDate) {
		this.registerDate = registerDate;
	}
}
