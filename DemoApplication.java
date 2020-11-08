package com.cred.io;

import org.springframework.boot.CommandLineRunner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cred.io.model.Customer;
import com.cred.io.service.CustomerService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner{
	
	@Autowired
	CustomerService cusService; 

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		 
		 // Customer 1
		 Customer cus_1 = new Customer();
		 cus_1.setCustId(5);
		 cus_1.setName("demoCustomer_1");
		 cus_1.setAge(30);
		 
		 // Customer 2
		 Customer cus_2 = new Customer();
		 cus_2.setCustId(2);
		 cus_2.setName("demoCustomer_2");
		 cus_2.setAge(30);
		 
		 // Customer 3
		 Customer cus_3 = new Customer();
		 cus_3.setCustId(3);
		 cus_3.setName("demoCustomer_3");
		 cus_3.setAge(30);
		 
		 cusService.insert(cus_1);
		 cusService.insert(cus_2);
		 cusService.insert(cus_3);
		 
		 /*
		 List<Customer> customers = new ArrayList<Customer>();
		 customers.add(cus_2);
		 customers.add(cus_3);
		 cusService.insertBatch(customers);
		 */
		 cusService.loadAllCustomer();
		 cusService.getCustomerById(5);
		 cusService.getCustomerNameById(2);
		 cusService.getTotalNumerCustomer();


		
	}

}
