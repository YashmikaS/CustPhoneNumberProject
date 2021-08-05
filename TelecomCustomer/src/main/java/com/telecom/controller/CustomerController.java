package com.telecom.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.telecom.model.CustomerInfo;
import com.telecom.service.CustomerService;

/**
 * @author y.surendrababu
 *
 */
@RestController
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	/**
	 * Get Phone Number list
	 *
	 */
	@GetMapping("/phonenumbers")
	public List<String> getPhoneNumbers() {
		return customerService.getPhoneNumbers();
	}

	/**
	 * Get Phone Numbers associated with a customer
	 */
	@GetMapping("/phonenumbers/{customerName}")
	public CustomerInfo getPhoneNumbers(@PathVariable String customerName) {
		return customerService.getCustomerDetails(customerName);
	}

	/**
	 * Activate Phone Number
	 */
	@PostMapping("/activate")
	public String activatePhoneNumber(@RequestParam String phoneNumber, @RequestParam String customerName) {
		return customerService.activatePhoneNumber(phoneNumber, customerName);
	}

}
