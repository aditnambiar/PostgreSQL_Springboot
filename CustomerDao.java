package com.cred.io.dao;

import java.util.List;

import com.cred.io.model.Customer;

public interface CustomerDao {
	  void insert(Customer cus);
	  void inserBatch(List<Customer> customers);
	  List<Customer> loadAllCustomer();
	  Customer findCustomerById(int cust_id);
	  String findNameById(int cust_id);
	  int getTotalNumberCustomer();
	}