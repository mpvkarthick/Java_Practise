package com.example.demo.lambdas;

import com.example.demo.inerfaces.GreetingInterface;

public class Greetings {


	public void greetings(GreetingInterface greetingInterface) {
		greetingInterface.greet();
	}
	
	public static void main(String[] args) {
		
		GreetingInterface greetingInterfaceLambda = () -> System.out.println("Hello Lambda World");
		
		GreetingInterface greetingClass =  new  GreetingInterface() {
			
			@Override
			public void greet() {
				System.out.println("Hello Anonymous World");
				
				
			}
		};
		
		Greetings greet =  new Greetings();
		greet.greetings(greetingInterfaceLambda);
		greet.greetings(greetingClass);
		greet.greetings(()->System.out.println("Hello Inline String Functions"));
		greetingInterfaceLambda.greet();
		greetingClass.greet();
		
		printLambda(s -> s.length(), "Hello Lambda");
		
	}
	
	public static void printLambda(StringLength s, String str) {
		System.out.println(s.getLength(str));
	}
	
	interface StringLength{
		 public int getLength(String s);
	}
}
