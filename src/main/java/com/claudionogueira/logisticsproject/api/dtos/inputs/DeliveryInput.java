package com.claudionogueira.logisticsproject.api.dtos.inputs;

import java.math.BigDecimal;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.claudionogueira.logisticsproject.api.dtos.ReceiverDTO;

public class DeliveryInput {

	@Valid
	@NotNull
	private CustomerIDInput customer;

	@Valid
	@NotNull
	private ReceiverDTO receiver;

	@NotNull
	private BigDecimal fee;

	public DeliveryInput() {

	}

	public DeliveryInput(CustomerIDInput customer, ReceiverDTO receiver, BigDecimal fee) {
		super();
		this.customer = customer;
		this.receiver = receiver;
		this.fee = fee;
	}

	public CustomerIDInput getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerIDInput customer) {
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

	public static class CustomerIDInput {

		@NotNull
		private Long id;

		public CustomerIDInput() {

		}

		public CustomerIDInput(Long id) {
			super();
			this.id = id;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}
	}
}
