package com.example.demo.concurrency;

import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class HelloWorldCallable {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService service = Executors.newFixedThreadPool(10);
		Future<Integer> future = service.submit(() -> {
			System.out.println("Sleeping for 3 Seconds");
			Thread.sleep(3000);
			System.out.println("Waking Up");
			return new Random().nextInt();
		});
		
		System.out.println("Just Submitted a Request for Integer");
		System.out.println("Hmm...Waiting....");
		try {
			System.out.println("Here is the requested Integer "+future.get(1, TimeUnit.MILLISECONDS));
			service.shutdown();
		} catch (InterruptedException | ExecutionException | TimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			System.out.println("Shutting Down");
			service.shutdown();
		}
		System.out.println("Here is the requested Integer "+future.get());
		service.submit(() -> {
			System.out.println("Sleeping for 3 Seconds");
			Thread.sleep(3000);
			System.out.println("Waking Up");
			return new Random().nextInt();
		});
		
	}
}
