package com.example.demo.datastructures;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class Dummy {

	public static void main(String[] args) {
//
//		String ransomNote = "echfiedd";
//		String magazine = "hbjjddfjceihdieccbjcachfaaabjcjjhehgbhjhgcagc";
//
//		System.out.println(canConstruct(ransomNote, magazine));
//		// (Arrays.asList(a)).indexOf((Character)'a');
//		
//		int[] cnt = new int[128];
//        for (char c : magazine.toCharArray())
//            ++cnt[c];
//        for (char c : ransomNote.toCharArray())
//            if (--cnt[c] < 0) System.out.println("false");;
//        System.out.println("true");

//		StockSpanner spanner =  new StockSpanner();
//		System.out.println(spanner.next(29));
//		System.out.println(spanner.next(91));
//		System.out.println(spanner.next(62));
//		System.out.println(spanner.next(76));
//		System.out.println(spanner.next(51));

		System.out.println(twoCitySchedCost(new int[][] { { 259,777 }, 
			{ 448,54 }, { 926,667 }, { 184,139 }, {840,118},{577,469} }));
	}

	public static int twoCitySchedCost(int[][] costs) {

		Arrays.sort(costs, (a, b) -> (a[0] - a[1]) - (b[0]-b[1]));
		int n = 0;
		int mid = costs.length / 2;
		int costToCityX = 0;
		int travelCost[];
		while ( n < costs.length) {
			travelCost = costs[n];
			if (n >= mid) {
				costToCityX = costToCityX + travelCost[1];
			} else {
				costToCityX = costToCityX + travelCost[0];
			}
			n++;
		}

		return costToCityX;
	}

	public static boolean canConstruct(String ransomNote, String magazine) {

		Map<Character, Integer> mapRNoteCharLastIndexInMgzine = new HashMap<>();
		int indexInMap = -1;
		for (int i = 0; i < ransomNote.length(); i++) {
			if (magazine.indexOf(ransomNote.charAt(i)) != -1) {

				if (!mapRNoteCharLastIndexInMgzine.isEmpty()
						&& null != mapRNoteCharLastIndexInMgzine.get(ransomNote.charAt(i)))
					indexInMap = mapRNoteCharLastIndexInMgzine.get(ransomNote.charAt(i));

				// indexInMap is -1, never occurred before in magazine.
				if (indexInMap == -1) {
					mapRNoteCharLastIndexInMgzine.put(ransomNote.charAt(i), magazine.indexOf(ransomNote.charAt(i)));
				} else {
					// check if there are any other occurrences of the character
					// after that index in magazine, if yes, update the map
					// with the latest index
					if (magazine.indexOf(ransomNote.charAt(i), indexInMap + 1) != -1) {
						mapRNoteCharLastIndexInMgzine.put(ransomNote.charAt(i),
								magazine.indexOf(ransomNote.charAt(i), indexInMap + 1));
					} else {
						// else return false, meaning there is no other occurrence
						// of the character.
						return false;
					}
				}

			} else {
				return false;
			}
			indexInMap = -1;
		}
		return true;
	}

}
