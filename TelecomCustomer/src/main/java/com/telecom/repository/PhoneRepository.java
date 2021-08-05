package com.telecom.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.telecom.entity.PhoneNumber;
/**
 * @author y.surendrababu
 *
 */
@Repository
public interface PhoneRepository extends JpaRepository<PhoneNumber,String>{

	public List<PhoneNumber> findAllByCustomerId(Long customerId);
}
