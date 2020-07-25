package com.example.demo.concurrency;

import java.util.Collections;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ScatterGatherExample {

	public static void main(String[] args) throws InterruptedException, ExecutionException {

		testScatterGatherWCompletableFuture();
		testScatterGatherWExecutoService();
		
	
	}

	@SuppressWarnings("unchecked")
	private static void testScatterGatherWExecutoService() throws InterruptedException {

		Set<Integer> prices = Collections.synchronizedSet(new HashSet<>());

		CountDownLatch latch = new CountDownLatch(3);

		ExecutorService executorService = Executors.newFixedThreadPool(3);
		executorService.submit(new Task(prices, latch));
		executorService.submit(new Task(prices, latch));
		executorService.submit(new Task(prices, latch));
		executorService.submit(new Task(prices, latch));

		latch.await();

		executorService.shutdown();

		System.out.println(prices.toString());
	}
	
	private static void testScatterGatherWCompletableFuture() throws InterruptedException, ExecutionException {

		Set<Integer> prices = Collections.synchronizedSet(new HashSet<>());

		CompletableFuture<Void> task1 = CompletableFuture.runAsync(new RunnableTask(prices));
		CompletableFuture<Void> task2 = CompletableFuture.runAsync(new RunnableTask(prices));
		CompletableFuture<Void> task3 = CompletableFuture.runAsync(new RunnableTask(prices));
		CompletableFuture<Void> task4 = CompletableFuture.runAsync(new RunnableTask(prices));
		CompletableFuture<Void> allTasks = CompletableFuture.allOf(task1,task2,task3,task4);
		allTasks.get();


		System.out.println(prices.toString());
	}

}

class Task implements Callable {

	private Set<Integer> prices;
	private CountDownLatch latch;

	public Task(Set<Integer> prices, CountDownLatch latch) {
		super();
		this.prices = prices;
		this.latch = latch;
	}
	
	public Task(Set<Integer> prices) {
		super();
		this.prices = prices;
	}
	

	public Set<Integer> getPrices() {
		return prices;
	}

	public void setPrices(Set<Integer> prices) {
		this.prices = prices;
	}

	public CountDownLatch getLatch() {
		return latch;
	}

	public void setLatch(CountDownLatch latch) {
		this.latch = latch;
	}

	@Override
	public Object call() throws Exception {
		prices.add(new Random().nextInt());
		if (null != latch) {
			latch.countDown();
		}
		Thread.sleep(2000);
		return null;
	}
	
}
class RunnableTask implements Runnable {

	private Set<Integer> prices;

	
	public RunnableTask(Set<Integer> prices) {
		this.prices = prices;
	}
	

	public Set<Integer> getPrices() {
		return prices;
	}

	public void setPrices(Set<Integer> prices) {
		this.prices = prices;
	}




	@Override
	public void run() {
		prices.add(new Random().nextInt());
	}
}
