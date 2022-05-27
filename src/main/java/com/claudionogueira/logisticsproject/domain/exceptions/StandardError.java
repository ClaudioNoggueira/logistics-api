package com.claudionogueira.logisticsproject.domain.exceptions;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(content = Include.NON_NULL)
public class StandardError {

	private OffsetDateTime instant;
	private Integer status;
	private String error;
	private String message;

	private List<Field> fields = new ArrayList<>();

	public StandardError() {

	}

	public StandardError(OffsetDateTime instant, Integer status, String error, String message) {
		this.instant = instant;
		this.status = status;
		this.error = error;
		this.message = message;
	}

	public OffsetDateTime getInstant() {
		return instant;
	}

	public void setInstant(OffsetDateTime instant) {
		this.instant = instant;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<Field> getFields() {
		return fields;
	}

	public void addField(String name, String message) {
		fields.add(new Field(name, message));
	}

	public void removeField(String name, String message) {
		fields.remove(new Field(name, message));
	}

	public static class Field {
		private String name;
		private String message;

		public Field(String name, String message) {
			this.name = name;
			this.message = message;
		}

		public String getName() {
			return name;
		}

		public String getMessage() {
			return message;
		}
	}
}
