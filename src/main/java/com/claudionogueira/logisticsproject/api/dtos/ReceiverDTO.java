package com.claudionogueira.logisticsproject.api.dtos;

public class ReceiverDTO {

	private String name;
	private String address;
	private String number;
	private String district;
	private String complement;

	public ReceiverDTO() {
	}

	public ReceiverDTO(String name, String address, String number, String district, String complement) {
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

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
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
