package com.telecom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.telecom.entity.Customer;

/**
 * @author y.surendrababu
 *
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

	public Customer findByCustomerName(String customerName);

}
