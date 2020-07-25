package com.example.demo.datastructures;

import java.util.Collections;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

public class HitCounter {

	/** Initialize your data structure here. */
	SortedSet<Integer> hitSet;
	 Map<Integer,Integer> hitCountMap;
	 int counter;
	public HitCounter() {
		hitSet = Collections.synchronizedSortedSet(new TreeSet<Integer>((a,b) -> a-b));
		hitCountMap = new TreeMap<Integer,Integer>();
		counter = 0;
	}

	/**
	 * Record a hit.
	 * 
	 * @param timestamp - The current timestamp (in seconds granularity).
	 */
	public void hit(int timestamp) {
		hitSet.add(timestamp);
		hitCountMap.put(timestamp, ++counter);
		
	}

	/**
	 * Return the number of hits in the past 5 minutes.
	 * 
	 * @param timestamp - The current timestamp (in seconds granularity).
	 */
	public int getHits(int timestamp) {

		int hits = 0;
		for(int hitIndex: hitSet.subSet(timestamp-300 <0?1:timestamp-300, timestamp+1)) {
			hits = hitCountMap.getOrDefault(hitIndex, 0)+hits;
		}
		return hits;
	}
	
	public static void main(String[] args) {
		HitCounter counter = new HitCounter();
		counter.hit(1);
		counter.hit(1);
		counter.hit(1);
		counter.hit(300);
		System.out.println(counter.getHits(300));
		
		
	}

}
