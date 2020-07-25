package com.example.demo.datastructures;

import java.util.ArrayDeque;
import java.util.Deque;

public class MyCircularQueue {
	public static void main(String[] args) {
		MovingAverage obj = new MovingAverage(3);
		System.out.println(obj.next(1));
		System.out.println(obj.next(1));
		System.out.println(obj.next(1));
		System.out.println(obj.next(1));
		MovingAverage obj1 = new MovingAverage(true,3);
		System.out.println(obj1.nextVal(1));
		System.out.println(obj1.nextVal(1));
		System.out.println(obj1.nextVal(1));
		System.out.println(obj1.nextVal(1));
		
	}
	
}

class MovingAverage {

	Deque<Integer> queue;
	int[] aqueue;
	int size=0;
	int head=0;
	int windowSum = 0;
	int count = 0;
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        
    	queue= new ArrayDeque<>();
    	this.size = size;
    }
    public MovingAverage(boolean flag, int size) {
        
    	this.size = size;
    	aqueue = new int[size];
    }
    
    
    public double next(int val) {
    	++count;
        // calculate the new sum by shifting the window
        queue.add(val);
        int head = count > size ? (int)queue.poll() : 0;
         
        windowSum = windowSum - head + val;

        return windowSum * 1.0 / Math.min(size, count);
    }
    
    public double nextVal(int val) {
        ++count;
        // calculate the new sum by shifting the window
        int tail = (head + 1) % size;
        windowSum = windowSum - aqueue[tail] + val;
        // move on to the next head
        head = (head + 1) % size;
        aqueue[head] = val;
        return windowSum * 1.0 / Math.min(size, count);
      }
}
