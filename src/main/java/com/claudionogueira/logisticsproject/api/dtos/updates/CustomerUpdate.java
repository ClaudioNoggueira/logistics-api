package com.claudionogueira.logisticsproject.api.dtos.updates;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.claudionogueira.logisticsproject.domain.ValidationGroups;

public class CustomerUpdate {

	@NotBlank(groups = ValidationGroups.CustomerName.class)
	@Size(max = 60)
	private String name;

	@Email
	@Size(max = 255)
	private String email;

	@NotBlank(groups = ValidationGroups.CustomerPhone.class)
	@Size(max = 20)
	private String phone;

	public CustomerUpdate() {

	}

	public CustomerUpdate(String name, String email, String phone) {
		super();
		this.name = name;
		this.email = email;
		this.phone = phone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
}
