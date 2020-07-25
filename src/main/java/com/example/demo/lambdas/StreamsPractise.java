package com.example.demo.lambdas;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ForkJoinPool;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.example.demo.model.Person;

public class StreamsPractise {

	static int compute(int k, int n) {

		return 0;
	}

	public Person returnPerson(String fname) {

		System.out.println("Entering Return Person for Fname " + fname);
		Map<String, Person> persons = new HashMap<>();
		persons.put("Karthik", new Person("Karthik", "Mannepalli", 35));
		persons.put("Isha", new Person("Isha", "Mannepalli", 3));
		persons.put("Raji", new Person("Raji", "Karthik", 35));
		persons.put("Thara", new Person("Thara", "Dinesh", 3));
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return persons.get(fname);
	}

	public static void main(String[] args) throws InterruptedException {

		System.out.println(Stream.of(1, 3, 4, 15, 4, 5).parallel());
		System.out.println(Runtime.getRuntime().availableProcessors());
		System.out.println(ForkJoinPool.commonPool().getPoolSize());

		StreamsPractise streamsPractise = new StreamsPractise();
		List<Person> persons = Arrays.asList(new Person("Karthik", "Mannepalli", 35),
				new Person("Isha", "Mannepalli", 3), new Person("Raji", "Karthik", 35),
				new Person("Thara", "Dinesh", 3));

		System.out.println(IntStream.range(1, 10).skip(5).average());

		Stream.of("karthik", "Isha", "Raji", "indira").sorted().filter(name -> name.startsWith("I")).findFirst()
				.ifPresent(System.out::println);

		double value = Arrays.stream(new int[] { 1, 2, 3, 4, 5 })
				// .map(x -> x)
				.average().orElseThrow();
		System.out.println(value);

//		persons.stream()
//				// .map(StreamsPractise::updateAge)
//				.map(p -> {
//					p.setAge(p.getAge() + 1);
//					return p;
//				}).filter(p -> p.getAge() <= 4).findAny().ifPresent(p ->System.out.println("Updating Age "+p));

		persons.stream().filter(p -> p.getAge() <= 4).collect(Collectors.toList()).stream()
				.forEach(System.out::println);

		persons.stream().filter(p -> p.getAge() <= 4).collect(Collectors.toList()).forEach(System.out::println);
		// kids.forEach(System.out::println);

		Iterator<List<Person>> iterator = Stream.of(persons).iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		Stream.Builder<String> streamBuilder = Stream.builder();
		streamBuilder.add("Karthik Mannepalli");
		streamBuilder.build();
		// streamBuilder.accept("Dummy");

		List<List<String>> namesNested = Arrays.asList(Arrays.asList("Jeff", "Bezos"), Arrays.asList("Bill", "Gates"),
				Arrays.asList("Mark", "Zuckerberg"));

		List<String> namesFlatStream = namesNested.stream().flatMap(Collection::stream).collect(Collectors.toList());

		namesFlatStream.forEach(System.out::println);

		Stream<Person> pStream = persons.stream()
				// .map(StreamsPractise::updateAge)
				.peek(p -> p.setAge(p.getAge() + 1));
		pStream.forEach(p -> System.out.println("Hello Peek 1" + p));
		// .filter(p -> p.getAge() <= 4)
		// .forEach(p -> System.out.println("Hello Peek 1 "+p));

		persons.stream()
				// .map(StreamsPractise::updateAge)
				.peek(p -> p.setAge(p.getAge() + 1))
				// .filter(p -> p.getAge() <= 4)
				.forEach(p -> System.out.println("Hello Peek 2 " + p));

		Stream<Integer> infiniteStream = Stream.iterate(2, i -> i * 2);

		// List<Integer> items =
		infiniteStream.skip(3).limit(5)
				// .collect(Collectors.toList());
				.forEach(System.out::println);
		// items.forEach(System.out::println);

		Instant startTime = Instant.now();
		System.out.println(Stream.of("Raji", "Isha", "Karthik", "Thara").parallel().map(streamsPractise::returnPerson)
				.filter(p -> p.getAge() <= 40).filter(p -> p.getLname().equalsIgnoreCase("Mannepalli")).findFirst()
				.toString());
		Instant endTime = Instant.now();
		System.out.println(Duration.between(startTime, endTime).getSeconds());

		persons.sort((p1, p2) -> p1.getFname().compareTo(p2.getFname()));
		persons.stream().sorted((p1, p2) -> p1.getFname().compareTo(p2.getFname())).forEach(System.out::println);

		Optional<Person> person = persons.stream().min((p1, p2) -> p1.getAge() - p2.getAge());

		Optional.ofNullable(persons.stream().min((p1, p2) -> p1.getAge() - p2.getAge())).ifPresent(System.out::println);

		persons.stream().mapToInt(p -> p.getAge()).max().ifPresent(System.out::println);

		Integer ageSum = persons.stream().map(p -> p.getAge()).reduce(0, Integer::sum);
		System.out.println(ageSum);
		
		persons.stream()
		.map(p -> p.getFname())
		.collect(Collectors.joining(","))
		.toString();
		
		System.out.println(persons.stream()
				.collect(Collectors.toMap(Person::getFname, Function.identity()))
				.toString());
	}

}
