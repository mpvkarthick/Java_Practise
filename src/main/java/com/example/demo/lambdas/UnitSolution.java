package com.example.demo.lambdas;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

import com.example.demo.model.Person;

public class UnitSolution {

	public static void main(String[] args) {
		List<Person> persons = Arrays.asList(new Person("Karthik", "Mannepalli", 35),
				new Person("Isha", "Mannepalli", 3), new Person("Raji", "Karthik", 35));

		Collections.sort(persons, (o1, o2) -> o1.getLname().compareTo(o2.getLname()));

//		printConditionally(persons, p -> true);
//		performConditionally(persons, p -> true, p -> System.out.println(p.toString()));
//		performConditionally(persons, p -> true, System.out::println);
//		printConditionally(persons, p -> p.getLname().startsWith("M"));
//		performConditionally(persons, p -> p.getLname().startsWith("M"), p -> System.out.println(p));
//		
		loopData(persons);
	}

	private static void printConditionally(List<Person> persons, Predicate<Person> pr) {

		for (Person p : persons) {
			if (pr.test(p)) {
				System.out.println(p.toString());
			}
		}
	}

	private static void performConditionally(List<Person> persons, Predicate<Person> pr, Consumer<Person> c) {

		for (Person p : persons) {
			if (pr.test(p)) {
				c.accept(p);
			}
		}
	}


	interface Condition {
		boolean test(Person p);
	}
	
	private static void loopData(List<Person> persons) {
		persons.forEach(System.out::println);
	}
}
