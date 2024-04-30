package com.demoproject.dto;

import java.lang.reflect.Constructor;

public class BeanCreationWitoutNoArgConstructor {
	
	private String name;
	private String Address;
	
	public BeanCreationWitoutNoArgConstructor(String name, String address) {		
		this.name = name;
		Address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}
	
	
	
	

}
