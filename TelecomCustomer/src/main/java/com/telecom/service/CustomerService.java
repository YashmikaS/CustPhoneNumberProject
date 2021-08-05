package com.telecom.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.telecom.entity.Customer;
import com.telecom.entity.PhoneNumber;
import com.telecom.model.CustomerInfo;
import com.telecom.repository.CustomerRepository;
import com.telecom.repository.PhoneRepository;

/**
 * @author y.surendrababu
 *
 */
@Service
public class CustomerService {

	@Autowired
	private PhoneRepository phoneRepository;

	@Autowired
	private CustomerRepository customerRepository;

	/**
	 * Get Phone Number list from the PhoneNumber table
	 *
	 */
	public List<String> getPhoneNumbers() {
		List<PhoneNumber> phonenumberlist = phoneRepository.findAll();
		return phonenumberlist.stream().map(n -> n.getNumber()).collect(Collectors.toList());
	}

	/**
	 * Get Phone Numbers associated with a customer
	 *
	 */
	public CustomerInfo getCustomerDetails(String customerName) {
		Customer cust = customerRepository.findByCustomerName(customerName);
		CustomerInfo customerInfo = new CustomerInfo();
		if (cust != null) {
			List<PhoneNumber> phonenumber = phoneRepository.findAllByCustomerId(cust.getId());
			List<String> phoneNumbers = phonenumber.stream().map(n -> n.getNumber()).collect(Collectors.toList());
			customerInfo.setCustomerName(cust.getCustomerName());
			customerInfo.setPhoneNumbers(phoneNumbers);
		}
		return customerInfo;
	}

	/**
	 * Activates the phone number
	 *
	 * if number is not in the phone table then return "Invalid number" if number is
	 * in table but if it already taken return "Select another number" if number is
	 * both available and not taken persist in the database
	 */

	public String activatePhoneNumber(String phoneNumber, String customerName) {
		Customer customer = customerRepository.findByCustomerName(customerName);
		Optional<PhoneNumber> number = phoneRepository.findById(phoneNumber);
		if (number.isEmpty()) {
			return "Invalid Phone Number";
		} else if (number.get().getCustomerId() != null) {
			return "Selected number not available.Choose another one";
		} else {
			// New Customer and activating the new number
			if (customer == null) {
				Customer cust = new Customer();
				cust.setCustomerName(customerName);
				cust = customerRepository.save(cust);
				PhoneNumber num = new PhoneNumber();
				num.setNumber(phoneNumber);
				num.setCustomerId(cust.getId());
				phoneRepository.save(num);
			} else {
				// Old customer activating new number
				PhoneNumber phoneNum = new PhoneNumber();
				phoneNum.setNumber(phoneNumber);
				phoneNum.setCustomerId(customer.getId());
				phoneRepository.save(phoneNum);
			}
		}
		return "Phone Number Activated";
	}

}