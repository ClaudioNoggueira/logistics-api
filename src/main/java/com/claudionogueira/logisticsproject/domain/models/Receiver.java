package com.claudionogueira.logisticsproject.domain.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;

@Embeddable
public class Receiver implements Serializable {
	private static final long serialVersionUID = 1L;

	@NotBlank
	@Column(name = "receiver_name")
	private String name;

	@NotBlank
	@Column(name = "receiver_address")
	private String address;

	@NotBlank
	@Column(name = "receiver_number")
	private Integer number;

	@NotBlank
	@Column(name = "receiver_district")
	private String district;

	@Column(name = "receiver_complement")
	private String complement;

	public Receiver() {
		// TODO Auto-generated constructor stub
	}

	public Receiver(String name, String address, Integer number, String district, String complement) {
		this.name = name;
		this.address = address;
		this.number = number;
		this.district = district;
		this.complement = complement;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getComplement() {
		return complement;
	}

	public void setComplement(String complement) {
		this.complement = complement;
	}
}
