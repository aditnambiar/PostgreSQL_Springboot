package com.cred.io.service;

import java.util.List;

import com.cred.io.model.Address;
import com.cred.io.model.ContactInfo;
import com.cred.io.model.Customer;
import com.cred.io.service.CustomerServiceImpl;

public interface CustomerService {
	
	  void insertContactInfo(Customer cus);
	  
	  void insertAddress(Customer cus);
	  
	  void insert(Customer cus);
	  
	  void deleteContactInfo(int id);
	  
	  void deleteAddress(int id);
	  
	  void delete(int id);
	  
	  void updateContactInfo(int id, String firstName, String lastName, String dateOfBirth, String email, int phoneNumber);
	  
	  void updateAddress(int id, String addressline1, String addressline2, String city, String state, int zipcode);
	  
	  String findNameByID(int id);
	  
	  List<Customer> returnCustomers();
	  
	  ContactInfo findContactInfoByID(int id);
	  
	  Address findAddressByID(int id);
	  
	  Customer findByID(int id);

	  int returnCount();
	  
}
