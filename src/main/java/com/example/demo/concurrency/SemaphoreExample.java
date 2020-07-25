package com.example.demo.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class SemaphoreExample {
	
	final static Semaphore semaphore = new Semaphore(3, false);

	public static void main(String[] args) throws InterruptedException {
		ExecutorService service = Executors.newFixedThreadPool(10);
		service.awaitTermination(5000,TimeUnit.SECONDS);
		Stream.iterate(1, i -> i + 1).limit(10).forEach(i -> service.execute(() -> {
			
			try {
				semaphore.acquire();
				System.out.println("Thread "+Thread.currentThread().getName()
						+"has acquired permit and sleeping for 2 seconds");
				Thread.sleep(2000);
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				semaphore.release();
				System.out.println("Thread "+Thread.currentThread().getName()
						+"released permit");
			}
			
			
		}));
		
		service.shutdown();
	}

	static void run() {
		System.out.println("Current thread acquired the permit " 
						+ Thread.currentThread().getName());
	}
}
