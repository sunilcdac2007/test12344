package com.harman.blockingQueue;

public class TestOverload {

	public static void main(String[] args) {
		method("again");

	}

	public static void method(Object str)
	{
		System.out.println("This is the object");
	}
	
/*	
	public static void method(String str)
	{
		System.out.println("This is the testing");
	} */
	public static void method(TestOverload str)
	{
		System.out.println("custom");
	}

}
