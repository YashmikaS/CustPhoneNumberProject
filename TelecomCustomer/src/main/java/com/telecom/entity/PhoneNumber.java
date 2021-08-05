package com.telecom.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author y.surendrababu
 *
 */
@Entity
@Table(name = "phone_number")
public class PhoneNumber {

	@Id
	private String number;

	@Column(name = "customer_id")
	private Long customerId;

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customer_id) {
		this.customerId = customer_id;
	}

}
