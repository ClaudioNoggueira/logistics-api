package com.claudionogueira.logisticsproject.domain.models;

import java.time.OffsetDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Occurence {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	private Delivery delivery;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "register_date")
	private OffsetDateTime registerDate;

	public Occurence() {

	}

	public Occurence(Long id, Delivery delivery, String description, OffsetDateTime registerDate) {
		super();
		this.id = id;
		this.delivery = delivery;
		this.description = description;
		this.registerDate = registerDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Delivery getDelivery() {
		return delivery;
	}

	public void setDelivery(Delivery delivery) {
		this.delivery = delivery;
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
		Occurence other = (Occurence) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
