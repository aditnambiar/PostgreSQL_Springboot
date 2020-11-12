package com.cred.io.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.cred.io.model.Address;
import com.cred.io.model.ContactInfo;
import com.cred.io.model.Customer;
import com.cred.io.service.CustomerService;



@RestController
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	
	@RequestMapping("/customers")
	public List<Customer> getCustomers() {
		return customerService.returnCustomers();
	}
	
	@RequestMapping("/customers/{customerID}")
	public Customer getCustomer(@PathVariable String customerID) {
		int id = Integer.parseInt(customerID);
        return customerService.findByID(id);
    }
	
	@RequestMapping(method = RequestMethod.POST, value="/customers")
    public void addCustomer(@RequestBody Customer customer){
        customerService.insert(customer);
    }
	
	@RequestMapping(method = RequestMethod.PUT, value="/customers/{customerID}")
    public void updateTopic(@RequestBody Customer customer, @PathVariable String customerID){
        ContactInfo contactInfo = customer.getContactInfo();
        Address address = customer.getAddress();
        
        customerService.updateContactInfo(contactInfo.getCustomerID(),
        									contactInfo.getFirstName(),
        									contactInfo.getLastName(),
        									contactInfo.getDateOfBirth(),
        									contactInfo.getEmail(),
        									contactInfo.getPhoneNumber());
        
        customerService.updateAddress(contactInfo.getCustomerID(),
        								address.getAddressLine1(),
        								address.getAddressLine2(),
        								address.getCity(),
        								address.getState(),
        								address.getZipCode());
        
        
    }
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/customers/{customerID}")
    public void deleteTopic(@PathVariable String customerID) {
		int id = Integer.parseInt(customerID);
        customerService.delete(id);
    }
	

}
