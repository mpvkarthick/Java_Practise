package com.example.demo.concurrency;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class HelloExecutorService {

	public static void main(String[] args) throws InterruptedException {
		// ExecutorService executorService;
		// executorService = Executors.newFixedThreadPool(10); CPS - 10, Max - 10, TTL
		// NA
		// executorService = Executors.newCachedThreadPool(); CPS - 0, Max -
		// Integer.Max, TTL - 60 Seconds
		// SingleThreadPool - CPS - 1, Max - 1, TTL - NA
		// allowCoreThreadTimeOut()//Default False
//		ScheduledExecutorService executorService = Executors.newScheduledThreadPool(10);// CPS - 10, Max - Integer.Max, TTL- 60 seconds
//
//		executorService.schedule(() -> System.out.println("Thread Name S1 " + Thread.currentThread().getName()), 10,
//				TimeUnit.SECONDS);
//		
//		executorService.scheduleAtFixedRate(() -> System.out.println("Thread Name S2 " + Thread.currentThread().getName()), 15, 10,
//				TimeUnit.SECONDS);
//		
//		executorService.scheduleWithFixedDelay(() -> System.out.println("Thread Name S3 " + Thread.currentThread().getName()), 15, 10,
//				TimeUnit.SECONDS);
//		// executorService.execute(() -> System.out.println("Thread Name " +
//		// Thread.currentThread().getName()));

//		Stream.iterate(1, i -> i + 1).limit(100).collect(Collectors.toList())
//				.forEach(i -> executorService.execute(new Task()));

//		for (int i = 0; i < 100; i++) {
//			executorService.execute(() -> System.out.println("Thread Name " + Thread.currentThread().getName()));
//		}

		ExecutorService executorService = new ThreadPoolExecutor(10, 100, 30, TimeUnit.SECONDS,
				new ArrayBlockingQueue<>(300), (r, t) -> {
					System.out.println("Rejected Task");
				});
		Stream.iterate(1, i -> i + 1).limit(400).collect(Collectors.toList()).forEach(i -> executorService
				.execute(() -> {
					try {
						System.out.println("Thread Name "+i+" " + Thread.currentThread().getName());
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}));
		executorService.shutdown();
		executorService.execute(() -> System.out.println("Hello World"));
	}

}
