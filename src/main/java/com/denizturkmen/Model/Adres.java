package com.denizturkmen.Model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

// bu model başka modelin içinde gömülceğini söylüyoruz
@Embeddable
public class Adres {
	
	@Column(name="Streeet_Name",length = 50)
	private String street;
	
	@Column(name="City_Name",length = 50,nullable = false)
	private String city;
	
	@Column(name="State_Name")
	private String state;
	
	@Column(name = "Pin_Code")
	private Long pincode;

	public String getStreet() {
		return street;
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

	public Long getPincode() {
		return pincode;
	}

	public void setPincode(Long pincode) {
		this.pincode = pincode;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	@Override
	public String toString() {
		return "Adres [street=" + street + ", city=" + city + ", state=" + state + ", pincode=" + pincode + "]";
	}

	
	


	
	

}
