package com.cred.io;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cred.io.model.Address;
import com.cred.io.model.ContactInfo;
import com.cred.io.model.Customer;
import com.cred.io.service.CustomerService;

@SpringBootApplication
public class SpringBootPostgreSqlApplication {

	/*
	@Autowired
	CustomerService cusService;
	*/
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootPostgreSqlApplication.class, args);
	}

	/*
	@Override
	public void run(String... args) throws Exception {
		
		Address address_1 = new Address("B501", "Buenavista", "Pune", "MAHA", 411021);
		ContactInfo contactInfo_1 = new ContactInfo(8344, "Aditya", "Nambiar", "ecfhf", "dkfje", 57548);
		Customer cus_1 = new Customer(contactInfo_1, false, address_1);
		
		Address address_2 = new Address("C4", "Marvel", "Mumbai", "MAHA", 411045);
		ContactInfo contactInfo_2 = new ContactInfo(832923, "Bob", "Bobby", "ehfr", "hdie", 39587);
		Customer cus_2 = new Customer(contactInfo_2, true, address_2);
		
		cusService.insert(cus_1);
		cusService.insert(cus_2);
			
	}
	*/

}
