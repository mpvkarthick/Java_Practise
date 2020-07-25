package com.example.demo.inerfaces;

public abstract class MyCustomBlockingQueue<T> {

	public synchronized void add(T t) throws InterruptedException {
		
	}
	
	public T remove() throws InterruptedException {
		return null;
	}
}
