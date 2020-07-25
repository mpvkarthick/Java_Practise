package com.example.demo.lambdas;

import java.util.Arrays;
import java.util.List;

import com.example.demo.model.Person;

public class StreamsExample {

	public static void main(String[] args) {

		List<Person> persons = Arrays.asList(new Person("Karthik", "Mannepalli", 35),
				new Person("Isha", "Mannepalli", 3), new Person("Raji", "Karthik", 35));

		persons.stream().forEach(p -> System.out.println(p.getFname()));
		
		persons.stream()
		.filter(p -> p.getLname().startsWith("M"))
		.forEach(System.out::println);

//		for (Person p : persons) {
//			System.out.println(p.getFname());
//		}
	}
}
