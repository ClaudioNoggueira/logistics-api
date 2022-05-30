package com.claudionogueira.logisticsproject.api.dtos.inputs;

import javax.validation.constraints.NotBlank;

public class OccurenceInput {

	@NotBlank
	private String description;

	public OccurenceInput() {

	}

	public OccurenceInput(@NotBlank String description) {
		super();
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
