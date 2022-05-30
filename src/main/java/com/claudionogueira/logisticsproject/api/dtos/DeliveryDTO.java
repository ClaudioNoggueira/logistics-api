package com.claudionogueira.logisticsproject.api.dtos;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import com.claudionogueira.logisticsproject.domain.models.enums.DeliveryStatus;

public class DeliveryDTO {

	private Long id;
	private DeliveryCustomerInfo customer;
	private ReceiverDTO receiver;
	private BigDecimal fee;
	private DeliveryStatus status;
	private OffsetDateTime requestDate;
	private OffsetDateTime conclusionDate;

	public DeliveryDTO() {
		// TODO Auto-generated constructor stub
	}

	public DeliveryDTO(Long id, DeliveryCustomerInfo customer, ReceiverDTO receiver, BigDecimal fee,
			DeliveryStatus status, OffsetDateTime requestDate, OffsetDateTime conclusionDate) {
		super();
		this.id = id;
		this.customer = customer;
		this.receiver = receiver;
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

	public DeliveryCustomerInfo getCustomer() {
		return customer;
	}

	public void setCustomer(DeliveryCustomerInfo customer) {
		this.customer = customer;
	}

	public ReceiverDTO getReceiver() {
		return receiver;
	}

	public void setReceiver(ReceiverDTO receiver) {
		this.receiver = receiver;
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

	public static class DeliveryCustomerInfo {

		private Long id;

		private String name;

		public DeliveryCustomerInfo() {

		}

		public DeliveryCustomerInfo(Long id, String name) {
			super();
			this.id = id;
			this.name = name;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
	}
}
