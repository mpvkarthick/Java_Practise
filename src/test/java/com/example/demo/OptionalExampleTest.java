package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;

import com.example.demo.model.Person;

class OptionalExampleTest {

	@Test
	void whenCreateOfNullableOptional_thenOk() {
		//Person person = new Person("Isha", "Mannepalli", 3, "Karthik_Mannepalli@hna.honda.com");
		Person person = null;
		String emailAddress = "Karthik_Mannepalli@hna.honda.com";

		// Method 1
//		Optional<Person> opt = Optional.ofNullable(person);
//		assertEquals(emailAddress, person.getEmailAddress());

		// Method 2
		Optional.ofNullable(person).ifPresent(u -> assertEquals(emailAddress, person.getEmailAddress()));

	}

	@Test
	public void whenCheckIfPresent_thenOk() {

		Person person = new Person("Isha", "Mannepalli", 3);

	}
}
