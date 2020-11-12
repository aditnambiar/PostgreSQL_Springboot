package com.cred.io.model;

public class ContactInfo {
    private int customerID;
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private String email;
    private int phoneNumber;

    // Setters and Getters for ContactInfo class
    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
    // print function
    public String print() {
    	String s0 = "ID: " + Integer.toString(this.customerID) + " ";
    	String s1 = "Name: " + this.firstName + " " + this.lastName + " ";
    	String s2 = "Date of Birth: " + this.dateOfBirth + " ";
    	String s3 = "Email: " + this.email + " ";
    	String s4 = "Phone Number: " + Integer.toString(this.phoneNumber) + " ";
    	
    	return s0 + s1 + s2 + s3 + s4;
    	
    }

    // Constructors for ContactInfo class, one default, one with all variables
    public ContactInfo() {
        this.customerID = 1;
        this.firstName = "Aditya";
        this.lastName = "Nambiar";
        this.dateOfBirth = "05/08/1998";
        this.email = "xyz@gmail.com";
        this.phoneNumber = 0;
    }

    public ContactInfo(int customerID, String firstName, String lastName, String dateOfBirth, String email, int phoneNumber) {
        this.customerID = customerID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
    
 

}

