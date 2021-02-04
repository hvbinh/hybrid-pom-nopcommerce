package com.oop.user;

import org.testng.annotations.Test;

public class Class_B {
	@Test
	public void TC_01()
	{
		Class_A a = new Class_A();
		System.out.println(a.name);
		System.out.println("protected cung package se show: "+a.getCity());
		System.out.println("protected cung package se show: "+a.getState());
		System.out.println("default cung package se show: "+a.phone);
		System.out.println("default cung package se show: "+a.email);
		System.out.println("default cung package se show: "+a.getPhone());
		System.out.println("default cung package se show: "+a.getEmail());
		System.out.println("private cung package se khong show:");

	}
}
