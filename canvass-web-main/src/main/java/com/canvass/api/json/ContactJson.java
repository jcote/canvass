package com.canvass.api.json;

import javax.persistence.Basic;
import javax.persistence.Column;

import org.hibernate.annotations.NaturalId;

import com.canvass.data.model.Bill;
import com.canvass.data.model.BillVersion;

public class ContactJson {
	private String email;
    private String firstName;
    private String lastName;
    private String zipCode;
    
    public ContactJson(){}
    
    public ContactJson(
    		String email,
		    String firstName,
		    String lastName,
		    String zipCode) 
    {
    	setEmail(email);
    	setFirstName(firstName);
    	setLastName(lastName);
    	setZipCode(zipCode);
    	
    }
    
    public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}


    
}
