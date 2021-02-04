package com.opp.account;

import java.io.ObjectInputStream.GetField;

import org.testng.annotations.Test;

import com.oop.user.Class_A;



public class Class_C extends Class_A{
	@Test
	public void TC_01()
	{
		Class_A a = new Class_A();
		System.out.println(a.name);
		System.out.println("protected khac package se show: "+getCity());
		System.out.println("protected khac package se show: "+getState());
		System.out.println("protected khac package se show: "+city);
		System.out.println("protected khac package se show: "+state);
		System.out.println("static khac package se khong show: "+numberItem);
	}
}
