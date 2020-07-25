package com.example.demo.datastructures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class ReconstructItinerary {

	public static void main(String[] args) {
		List<List<String>> tickets = new ArrayList<List<String>>();
		tickets.add(Arrays.asList(new String[] { "JFK", "SFO" }));
		tickets.add(Arrays.asList(new String[] { "JFK", "ATL" }));
		tickets.add(Arrays.asList(new String[] { "SFO", "ATL" }));
		tickets.add(Arrays.asList(new String[] { "ATL", "JFK" }));
		tickets.add(Arrays.asList(new String[] { "ATL", "SFO" }));
		for (String airport : findItinerary(tickets)) {
			System.out.println(airport);
		}
		System.out.println("===================");
		tickets = new ArrayList<List<String>>();
		tickets.add(Arrays.asList(new String[] { "MUC", "LHR" }));
		tickets.add(Arrays.asList(new String[] { "JFK", "MUC" }));
		tickets.add(Arrays.asList(new String[] { "SFO", "SJC" }));
		tickets.add(Arrays.asList(new String[] { "LHR", "SFO" }));
		for (String airport : findItinerary(tickets)) {
			System.out.println(airport);
		}
		System.out.println("===================");
		tickets = new ArrayList<List<String>>();
		tickets.add(Arrays.asList(new String[] { "JFK", "KUL" }));
		tickets.add(Arrays.asList(new String[] { "JFK", "NRT" }));
		// tickets.add(Arrays.asList(new String[] {"JFK", "SFO"}));
		tickets.add(Arrays.asList(new String[] { "NRT", "JFK" }));
		// tickets.add(Arrays.asList(new String[] {"SFO", "JFK"}));
		for (String airport : findItinerary(tickets)) {
			System.out.println(airport);
		}

		System.out.println("===================");
		tickets = new ArrayList<List<String>>();
		tickets.add(Arrays.asList(new String[] { "EZE", "AXA" }));
		tickets.add(Arrays.asList(new String[] { "TIA", "ANU" }));
		tickets.add(Arrays.asList(new String[] { "ANU", "JFK" }));
		tickets.add(Arrays.asList(new String[] { "JFK", "ANU" }));
		tickets.add(Arrays.asList(new String[] { "ANU", "EZE" }));
		tickets.add(Arrays.asList(new String[] { "TIA", "ANU" }));
		tickets.add(Arrays.asList(new String[] { "AXA", "TIA" }));
		tickets.add(Arrays.asList(new String[] { "TIA", "JFK" }));
		tickets.add(Arrays.asList(new String[] { "ANU", "TIA" }));
		tickets.add(Arrays.asList(new String[] { "JFK", "TIA" }));
		for (String airport : findItinerary(tickets)) {
			System.out.println(airport);
		}

	}

	public static List<String> findItinerary(List<List<String>> tickets) {

		LinkedList<String> airports = new LinkedList<String>();
		Map<String, PriorityQueue<String>> srcDestinationMap = new HashMap<String, PriorityQueue<String>>();
		PriorityQueue<String> destinationQueue;
		for (List<String> ticket : tickets) {
			destinationQueue = srcDestinationMap.getOrDefault(ticket.get(0),
					new PriorityQueue<String>((a, b) -> a.compareTo(b)));
			destinationQueue.offer(ticket.get(1));
			srcDestinationMap.put(ticket.get(0), destinationQueue);
		}
		if (!srcDestinationMap.containsKey("JFK")) {
			return airports;
		}
		generateItinerary(srcDestinationMap, "JFK", airports);
		return airports;
	}

	public static void generateItinerary(Map<String, PriorityQueue<String>> srcDestinationMap, String src,
			LinkedList<String> airports) {
		PriorityQueue<String> destinationQueue = srcDestinationMap.get(src);
		String destination;
		while (null != destinationQueue && !destinationQueue.isEmpty()) {
			destination = destinationQueue.poll();
			generateItinerary(srcDestinationMap, destination, airports);
		}
		airports.offerFirst(src);
	}
}
