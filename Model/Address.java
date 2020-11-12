package com.cred.io.model;

public class Address {
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String state;
    private int zipCode;

    // Setters and Getters for Address Class
    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }
    
    public void setZipcode(long zipCode) {
    	int zip = (int) zipCode;
    	this.zipCode = zip;
    }
    
    public String print() {
    	String s0 = "Address Line 1: " + this.addressLine1 + " ";
    	String s1 = "Address Line 2: " + this.addressLine2 + " ";
    	String s2 = "City: " + this.city + " ";
    	String s3 = "State: " + this.state + " ";
    	String s4 = "Zipcode: " + Integer.toString(this.zipCode) + " ";
    	
    	return s0 + s1 + s2 + s3 + s4;
    }

    // Constructors for Address class, one default, one with all variables
    public Address() {
        this.addressLine1 = "B504, Buenavista";
        this.addressLine2 = "Balewadi";
        this.city = "Pune";
        this.state = "Maharashtra";
        this.zipCode = 411032;
    }

    public Address(String addressLine1, String addressLine2, String city, String state, int zipCode) {
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }
}

