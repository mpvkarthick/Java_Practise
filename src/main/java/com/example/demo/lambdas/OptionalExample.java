package com.example.demo.lambdas;

import java.util.Optional;

import com.example.demo.model.Person;

public class OptionalExample {

	public static void main(String[] args) {
		Optional<Person> emptyPerson = Optional.empty();
		emptyPerson.get();
	}
	
	public void workoutOptional() {
		
	}
}
