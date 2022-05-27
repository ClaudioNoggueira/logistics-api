package com.claudionogueira.logisticsproject.api.dtos;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import com.claudionogueira.logisticsproject.domain.models.enums.DeliveryStatus;

public class DeliveryDTO {

	private Long id;
	private String customerName;
	private BigDecimal fee;
	private DeliveryStatus status;
	private OffsetDateTime requestDate;
	private OffsetDateTime conclusionDate;

	public DeliveryDTO() {
		// TODO Auto-generated constructor stub
	}

	public DeliveryDTO(Long id, String customerName, BigDecimal fee, DeliveryStatus status, OffsetDateTime requestDate,
			OffsetDateTime conclusionDate) {
		this.id = id;
		this.customerName = customerName;
		this.fee = fee;
		this.status = status;
		this.requestDate = requestDate;
		this.conclusionDate = conclusionDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public BigDecimal getFee() {
		return fee;
	}

	public void setFee(BigDecimal fee) {
		this.fee = fee;
	}

	public DeliveryStatus getStatus() {
		return status;
	}

	public void setStatus(DeliveryStatus status) {
		this.status = status;
	}

	public OffsetDateTime getRequestDate() {
		return requestDate;
	}

	public void setRequestDate(OffsetDateTime requestDate) {
		this.requestDate = requestDate;
	}

	public OffsetDateTime getConclusionDate() {
		return conclusionDate;
	}

	public void setConclusionDate(OffsetDateTime conclusionDate) {
		this.conclusionDate = conclusionDate;
	}
}
