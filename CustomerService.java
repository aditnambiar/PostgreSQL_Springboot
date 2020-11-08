package com.cred.io.service;

import java.util.List;

import com.cred.io.model.Customer;

public interface CustomerService {
	  void insert(Customer cus);
	  void insertBatch(List<Customer> customers);
	  void loadAllCustomer();
	  void getCustomerById(int cust_id);
	  void getCustomerNameById(int cust_id);
	  void getTotalNumerCustomer();
}
