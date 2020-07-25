package com.example.demo.datastructures;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
public class LRUCache {

    private Map<Integer, Integer> cache;
	LinkedList<Integer> keys;
	int capacity;

	public LRUCache(int capacity) {

		this.capacity = capacity;
		keys = new LinkedList<Integer>();
		cache = new HashMap<Integer, Integer>();

	}

	public int get(int key) {

		if (cache.containsKey(key)) {
			keys.remove(key);
			keys.add(key);
			return cache.get(key);
		}
		return -1;
	}

	public void put(int key, int value) {

		if (keys.size() == capacity && !keys.contains(key)) {
			cache.remove(keys.poll());
		}
		cache.put(key, value);
		keys.remove(key);
		keys.add(key);

	}
}
