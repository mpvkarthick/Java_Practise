package com.example.demo.concurrency;

public class InterruptedExample {

	public static void main(String[] args) {
		
		Thread t = new Thread(() -> System.out.println("Hello Thread world!!!!"));
		
		t.start();
		System.out.println("Is thread interrupted " +t.isAlive());
		
		System.out.println("Is thread running " +t.isInterrupted());
		
		t.interrupted();
		
		System.out.println("Is thread running " +t.isAlive());

	}


}
