package com.example.demo.concurrency;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReEntrantLockExample {

	static Lock lock = new ReentrantLock();
	static Condition conditionMet = lock.newCondition();

	public static void main(String[] args) {

		Executor service = Executors.newFixedThreadPool(5);
		service.execute(() -> {
			try {
				method1();
			} catch (InterruptedException e) {
				System.out.println("Exception Occured");
			}
		});

		service.execute(() -> {
			try {
				method1();
			} catch (InterruptedException e) {
				System.out.println("Exception Occured in method 1");
			}
		});

		service.execute(() -> {
			try {
				method2();
			} catch (Exception e) {
				System.out.println("Exception Occured in method 2");
			}
		});

	}

	public static void method1() throws InterruptedException {

		boolean isLocked = lock.tryLock(3000,TimeUnit.MILLISECONDS);
		if (isLocked) {
			System.out.println("Thread " + Thread.currentThread().getName() + "acquired lock");
			try {
				conditionMet.await();
			} finally {
				lock.unlock();
			}
		} else {
			System.out.println("Thread " + Thread.currentThread().getName() + " couldn't acquired lock");
		}
	}

	public static void method2() throws InterruptedException {
		System.out.println("Thread " + Thread.currentThread().getName() 
				+ " signalling condition is met");
		conditionMet.signal();
	}
}
