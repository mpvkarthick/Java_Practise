package com.example.demo.concurrency;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.example.demo.lambdas.Greetings;

public class CompletableFutureExample {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
//		ExecutorService service = Executors.newFixedThreadPool(10);
//		Future<Integer> future = service.submit(() -> {
//			System.out.println("Sleeping for 3 Seconds");
//			Thread.sleep(3000);
//			System.out.println("Waking Up");
//			return CompletableFutureExample.getRandomNumber();
//		});
//		
//		System.out.println("Just Submitted a Request for Integer");
//		System.out.println("Hmm...Waiting....");
//		try {
//			System.out.println("Here is the requested Integer "+future.get());
//			service.shutdown();
//		} catch (InterruptedException | ExecutionException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {
//			System.out.println("Shutting Down");
//			service.shutdown();
//		}
		for (int i = 0; i < 10; i++) {
			CompletableFuture.supplyAsync(() -> getRandomNumber()).thenApply(n -> getSumOfAnotherRandomNumber(n));
		}
		// System.out.println("Here is the requested Integer "+future.get());
//		service.submit(() -> {
//			System.out.println("Sleeping for 3 Seconds");
//			Thread.sleep(3000);
//			System.out.println("Waking Up");
//			return new Random().nextInt();
//		});

	}

	public static int getRandomNumber() {

		System.out.println("Thread Name Get Random Number " + Thread.currentThread().getName());

		return new Random().nextInt();
	}

	public static int getSumOfAnotherRandomNumber(int n) {
		System.out.println("Thread Name Get Sum Random Number " + Thread.currentThread().getName());
		return n + new Random().nextInt();
	}

}
