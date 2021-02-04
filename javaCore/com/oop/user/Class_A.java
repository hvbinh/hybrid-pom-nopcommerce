package com.oop.user;

public class Class_A {
	public String name = "Automation", address="123 Truong Chinh";
	protected String city ="Ha noi", state="Hoan Kiem";
	String phone = "0908767766", email ="automationfc@gmail.com";
	private String firstName = "automation test";
	public static final String numberItem = "1000";
	
	public String getName()
	{
		return this.name;
	}
	public String geAddress()
	{
		return this.address;
	}
	protected String getCity()
	{
		return this.city;
	}
	protected String getState()
	{
		return this.state;
	}
	String getPhone()
	{
		return this.phone;
	}
	String getEmail()
	{
		return this.email;
	}
	private String getFirstName()
	{
		return firstName;
	}


}
