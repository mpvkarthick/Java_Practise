package com.example.demo.datastructures;

import java.util.Arrays;
import java.util.PriorityQueue;

//package com.example.demo.datastructures;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Collections;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//public class Solution {
//
//	public static void main(String[] args) {
//		// String[] logs = {"1 n u", "r 527", "j 893", "6 14", "6 82"};
//		// System.out.println(Arrays.toString(reorderLogFiles(logs)));
//		// System.out.println(Arrays.toString(reorderLogFiles(new String[] {"dig1 8 1 5
//		// 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"})));
//		// System.out.println(Arrays.toString(reorderLogFiles(new String[] {"g1 act","a8
//		// act aoo"})));
//		// System.out.println(Arrays.toString(sample(new String[] {"g1 act","a8 act
//		// aoo"})));
//		System.out.println("Result " + mostCommonWord("Bob!", new String[] { "hit" }));
//	}
//
//	public static String[] reorderLogFiles(String[] logs) {
//
//		String numberIndex = "0123456789";
//		List<String> digitSet = new ArrayList<>();
//		List<String> letSet = new ArrayList<>();
//		for (int i = 0; i < logs.length; i++) {
//			if (numberIndex.indexOf((logs[i].split(" "))[1].charAt(0)) != -1) {
//				digitSet.add(logs[i]);
//			} else
//				letSet.add(logs[i]);
//		}
//
//		Collections.sort(letSet, (o1, o2) -> {
//
//			String s1 = o1.substring(o1.indexOf(" ") + 1, o1.length());
//			String s2 = o2.substring(o2.indexOf(" ") + 1, o2.length());
//			if (s1.compareTo(s2) == 0) {
//				return (o1.split(" "))[0].compareTo((o2.split(" "))[0]);
//			}
//			return (s1.compareTo(s2));
//		});
//		letSet.addAll(digitSet);
//		return letSet.toArray(new String[letSet.size()]);
//	}
//
//	public static String[] sample(String[] logs) {
//		Arrays.sort(logs, (log1, log2) -> {
//			String[] split1 = log1.split(" ", 2);
//			String[] split2 = log2.split(" ", 2);
//			boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
//			boolean isDigit2 = Character.isDigit(split2[1].charAt(0));
//			if (!isDigit1 && !isDigit2) {
//				int cmp = split1[1].compareTo(split2[1]);
//				if (cmp != 0)
//					return cmp;
//				return split1[0].compareTo(split2[0]);
//			}
//			return isDigit1 ? (isDigit2 ? 0 : 1) : -1;
//		});
//		// ("[ ^, ,.\\s\\h!]");
//		return logs;
//	}
//
//	public static String mostCommonWord(String paragraph, String[] banned) {
//		String[] words = paragraph.toLowerCase().replaceAll("[^a-zA-Z0-9\\s+]", " ").split(" ");
//		Map<String, Integer> countMap = new HashMap<>();
//		int highestCount = 0;
//		String wordWithHighestCount = null;
//		int wordCount = 0;
//		String bannedWords = Arrays.toString(banned);
//		for (String s : words) {
//			if (!bannedWords.contains(s.trim())) {
//				wordCount = countMap.getOrDefault(s, 0) +1 ;
//						//(countMap.get(s.trim()) != null ? countMap.get(s.trim()) : 0) + 1;
//				if (wordCount >= highestCount) {
//					highestCount = wordCount;
//					wordWithHighestCount = s.trim();
//				}
//				countMap.put(s, wordCount);
//			}
//		}
//		return wordWithHighestCount;
//	}
//}
class Solution {
    
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
     
        // Build the adjacency matrix
        int adjMatrix[][] = new int[n][n];
        for (int[] flight: flights) {
            adjMatrix[flight[0]][flight[1]] = flight[2];
        }
        
        // Shortest distances array
        int[] distances = new int[n];
        
        // Shortest steps array
        int[] currentStops = new int[n];
        Arrays.fill(distances, Integer.MAX_VALUE);
        Arrays.fill(currentStops, Integer.MAX_VALUE);
        distances[src] = 0;
        currentStops[src] = 0;
        
        // The priority queue would contain (node, cost, stops)
        PriorityQueue<int[]> minHeap = new PriorityQueue<int[]>((a, b) -> a[1] - b[1]);
        minHeap.offer(new int[]{src, 0, 0});
        
         while (!minHeap.isEmpty()) {
             
            int[] info = minHeap.poll();
            int node = info[0], stops = info[2], cost = info[1];
             
             // If destination is reached, return the cost to get here
            if (node == dst) {
                return cost;
            }
             
            // If there are no more steps left, continue 
            if (stops == K + 1) {
                continue;
            }
             
            // Examine and relax all neighboring edges if possible 
            for (int nei = 0; nei < n; nei++) {
                if (adjMatrix[node][nei] > 0) {
                    int dU = cost, dV = distances[nei], wUV = adjMatrix[node][nei];
                    
                    // Better cost?
                    if (dU + wUV < dV) {
                        minHeap.offer(new int[]{nei, dU + wUV, stops + 1});
                        distances[nei] = dU + wUV;
                    }
                    else if (stops < currentStops[nei]) {
                        
                        // Better steps?
                        minHeap.offer(new int[]{nei, dU + wUV, stops + 1});
                        currentStops[nei] = stops;
                    }
                }
            }
         }
        
        return distances[dst] == Integer.MAX_VALUE? -1 : distances[dst];
    }
}