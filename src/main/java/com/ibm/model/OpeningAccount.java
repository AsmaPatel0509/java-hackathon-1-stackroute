package com.ibm.model;

import java.sql.Date;

public class OpeningAccount {

	private int id;
	private String name;
	private String address;
	private int age;
	private String dobString;
	private String email;
	
	public OpeningAccount() {
		super();
	}
	
	public OpeningAccount(int id, String name, String address, int age, String dobString, String email) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.age = age;
		this.dobString = dobString;
		this.email = email;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public String getDobString() {
		return dobString;
	}

	public void setDobString(String dobString) {
		this.dobString = dobString;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "OpeningAccount [id=" + id + ", name=" + name + ", address=" + address + ", age=" + age + ", dobString="
				+ dobString + ", email=" + email + "]";
	}

}
