package com.claudionogueira.logisticsproject.domain.models;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import com.claudionogueira.logisticsproject.domain.models.enums.DeliveryStatus;

@Entity
public class Delivery {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	private BigDecimal fee;

	@Column(name = "request_date")
	private OffsetDateTime requestDate;

	@Column(name = "conclusion_date")
	private OffsetDateTime conclusionDate;

	@ManyToOne
	private Customer customer;

	@Embedded
	private Receiver receiver;

	@Enumerated(EnumType.STRING)
	private DeliveryStatus status;

	@OneToMany(mappedBy = "delivery")
	private List<Occurence> occurences = new ArrayList<>();

	public Delivery() {
		// TODO Auto-generated constructor stub
	}

	public Delivery(Long id, BigDecimal fee, OffsetDateTime requestDate, OffsetDateTime conclusionDate,
			Customer customer, Receiver receiver, DeliveryStatus status) {
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


	public List<Occurence> getOccurences() {
		return occurences;
	}

	public void addOccurence(Occurence obj) {
		occurences.add(obj);
	}

	public void removeOccurence(Occurence obj) {
		occurences.remove(obj);
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
