package com.claudionogueira.logisticsproject.domain.models;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.groups.ConvertGroup;
import javax.validation.groups.Default;

import com.claudionogueira.logisticsproject.domain.ValidationGroups;
import com.claudionogueira.logisticsproject.domain.models.enums.DeliveryStatus;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
public class Delivery {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	private BigDecimal fee;

	@JsonProperty(access = Access.READ_ONLY)
	private LocalDateTime requestDate;

	@JsonProperty(access = Access.READ_ONLY)
	private LocalDateTime conclusionDate;

	@ConvertGroup(from = Default.class, to = ValidationGroups.CustomerID.class)
	@Valid
	@NotNull
	@ManyToOne
	private Customer customer;

	@NotNull
	@Embedded
	private Receiver receiver;

	@JsonProperty(access = Access.READ_ONLY)
	@Enumerated(EnumType.STRING)
	private DeliveryStatus status;

	public Delivery() {
		// TODO Auto-generated constructor stub
	}

	public Delivery(Long id, BigDecimal fee, LocalDateTime requestDate, LocalDateTime conclusionDate, Customer customer,
			Receiver receiver, DeliveryStatus status) {
		this.id = id;
		this.fee = fee;
		this.requestDate = requestDate;
		this.conclusionDate = conclusionDate;
		this.customer = customer;
		this.receiver = receiver;
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getFee() {
		return fee;
	}

	public void setFee(BigDecimal fee) {
		this.fee = fee;
	}

	public LocalDateTime getRequestDate() {
		return requestDate;
	}

	public void setRequestDate(LocalDateTime requestDate) {
		this.requestDate = requestDate;
	}

	public LocalDateTime getConclusionDate() {
		return conclusionDate;
	}

	public void setConclusionDate(LocalDateTime conclusionDate) {
		this.conclusionDate = conclusionDate;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Receiver getReceiver() {
		return receiver;
	}

	public void setReceiver(Receiver receiver) {
		this.receiver = receiver;
	}

	public DeliveryStatus getStatus() {
		return status;
	}

	public void setStatus(DeliveryStatus status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Delivery other = (Delivery) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
