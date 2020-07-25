package com.example.demo.concurrency;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import com.example.demo.inerfaces.MyCustomBlockingQueue;

public class MySynchronizedBQueue<T> extends MyCustomBlockingQueue<T>{

	private Queue<T> queue;
	private int maxSize;
	Lock lock =  new ReentrantLock(true);
	private Object syncObject = new Object();
	
	public MySynchronizedBQueue(int maxSize) {
		queue =new LinkedList<T>();
		this.maxSize = maxSize;
	}

	public synchronized void add(T t) throws InterruptedException {
		lock.lock();
		String threadName = "Thread "+Thread.currentThread().getName()+ " ";
		try {
			if(queue.size() == maxSize) {
				System.out.println("Queue Full, Thread "+threadName+" waiting to add data to queue");
				syncObject.wait();
			}
			System.out.println("Thread "+threadName+" adding data to queue");
			queue.add(t);
			syncObject.notifyAll();
			//System.out.println("Thread "+threadName+" Signalled Consumer");
		} finally {
			lock.unlock();
		}
	}

	public synchronized T remove() throws InterruptedException {
		lock.lock();
		String threadName = "Thread "+Thread.currentThread().getName()+ " ";
		try {
			if(queue.size() == 0) {
				//System.out.println("Queue Empty, Thread "+threadName+" waiting for items in queue");
				syncObject.wait();
			}
			System.out.println("Item Consumed by Thread "+threadName);
			T t = queue.remove();
			syncObject.notifyAll();
			//System.out.println("Thread "+threadName+" Signalled Producer");
			return t;
		} finally {
			lock.unlock();
		}
	}
	
	@Override
	public String toString() {
		return "MyBlockingQueue [queue=" + queue + ", maxSize=" + maxSize + "]";
	}
	
	
	
	
}
