package com.cred.io.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cred.io.dao.CustomerDao;
import com.cred.io.model.Address;
import com.cred.io.model.ContactInfo;
import com.cred.io.model.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired CustomerDao customerDao;
	
	@Override
	public void insertContactInfo(Customer cus) {
		customerDao.insertContactInfo(cus);
	}
	
	@Override
	public void insertAddress(Customer cus) {
		customerDao.insertAddress(cus);
	}
	
	@Override
	public void insert(Customer cus) {
		customerDao.insert(cus);
	}
	
	@Override
	public void deleteContactInfo(int id) {
		customerDao.deleteContactInfo(id);
	}
	
	@Override
	public void deleteAddress(int id) {
		customerDao.deleteAddress(id);
	}
	
	@Override
	public void delete(int id) {
		customerDao.delete(id);
	}
	
	@Override
	public void updateContactInfo(int id, String firstName, String lastName, String dateOfBirth, String email, int phoneNumber) {
		customerDao.updateContactInfo(id, firstName, lastName, dateOfBirth, email, phoneNumber);
	}
	
	@Override
	public void updateAddress(int id, String addressline1, String addressline2, String city, String state, int zipcode) {
		customerDao.updateAddress(id, addressline1, addressline2, city, state, zipcode);
	}
	
	@Override
	public List<Customer> returnCustomers() {
		return customerDao.returnCustomers();
	}
	
	@Override
	public String findNameByID(int id) {
		return customerDao.findNameByID(id);
	}
	
	@Override 
	public ContactInfo findContactInfoByID(int id) {
		return customerDao.findContactInfoByID(id);
	}
	
	@Override
	public Address findAddressByID(int id) {
		return customerDao.findAddressByID(id);
	}
	
	@Override
	public Customer findByID(int id) {
		return customerDao.findByID(id);
	}
	
	@Override 
	public int returnCount() {
		return customerDao.returnCount();
	}

}
