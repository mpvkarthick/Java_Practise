package com.example.demo.concurrency;

import java.time.LocalTime;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ForkJoinPoolExample {

	public static void main(String[] arg) throws InterruptedException, ExecutionException {
		LocalTime before = LocalTime.now();
		int processors = Runtime.getRuntime().availableProcessors();
		System.out.println("Available core: " + processors);
		ForkJoinPool pool = new ForkJoinPool(processors);

		System.out.println(pool.submit(new Fibonacci(5)).get());

		LocalTime after = LocalTime.now();
	}
}

 class Fibonacci extends RecursiveTask<Integer> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int num;

	Fibonacci(int n) {
		num = n;
	}

	@Override
	protected Integer compute() {
		if (num <= 1)
			return num;

		Fibonacci fib1 = new Fibonacci(num - 1);
		fib1.fork();
		Fibonacci fib2 = new Fibonacci(num - 2);
		fib2.fork();

		return fib1.join() + fib2.join();
	}
}
