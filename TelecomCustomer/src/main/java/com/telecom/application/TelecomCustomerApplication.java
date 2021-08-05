package com.telecom.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.telecom.entity")
@ComponentScan({"com.telecom.controller","com.telecom.service"})
@EnableJpaRepositories("com.telecom.repository")
public class TelecomCustomerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TelecomCustomerApplication.class, args);
	}

}
