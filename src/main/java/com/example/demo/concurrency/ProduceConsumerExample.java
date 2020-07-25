package com.example.demo.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Stream;

import com.example.demo.inerfaces.MyCustomBlockingQueue;

public class ProduceConsumerExample {


	public static void main(String[] args) {

		System.out.println("Testing with Lock and Conditions");
		testProdConswithCustomQueue(new MyBlockingQueue<>(10));
		
		System.out.println("Testing with Synchronized Block");
		testProdConswithCustomQueue(new MySynchronizedBQueue<>(10));

	}

	private static void testProdConswithCustomQueue(MyCustomBlockingQueue<String> blockingQueue) {
		ExecutorService producerService = Executors.newFixedThreadPool(10);

		ExecutorService consumerService = Executors.newFixedThreadPool(10);

		Stream.iterate(1, i -> i + 1).limit(20).forEach(i -> {
			producerService.submit(() -> {
				try {
					String data = "Tickets";
					System.out.println("Adding Data " + data + " With Thread " + Thread.currentThread().getName());
					blockingQueue.add(data);

				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			});
		});

		Stream.iterate(1, i -> i + 1).limit(20).forEach(i -> {
			consumerService.submit(() -> {
				try {
					String data = blockingQueue.remove();
					System.out.println("Getting " + data + " With Thread " + Thread.currentThread().getName());

				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			});
		});

		producerService.shutdown();
		consumerService.shutdown();
	}

}
