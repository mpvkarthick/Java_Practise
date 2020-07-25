package com.example.demo.datastructures;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ActiveCells {

	public static void main(String[] args) {
		int[] returnList = cellCompete(new int[] { 0,1,1,1,0,0,0,0 }, 99);
		for (int i : returnList) {
			System.out.print(i + " ");
		}
	}

	// METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
	public static int[] cellCompete(int[] states, int days) {
		// WRITE YOUR CODE HERE

		int lCell = 0;
		int rCell = 0;
		int cCell = 0;
		Map<String, int[]> statetoNextDayMap = new HashMap<String, int[]>();
		int[] returnList = new int[states.length];
		int[] dailyList;
		int rIndex = 0;
		String mapKey;
		// Day 0 State--> current states
		while (days >= 0) {
			mapKey = Arrays.toString(states);
			if (statetoNextDayMap.containsKey(mapKey)) {
				states = statetoNextDayMap.get(mapKey);
				System.out.println(days);
				if (days == 1) {
					returnList = states;
				}
			} else {
				dailyList = new int[states.length];
				rIndex=0;
				for (int j = 0; j < states.length; j++) {
					
					// current cell = previous left cell - previous right cell
					// previous current then becomes previous left cell for next cell.

					if (j == 0) {

						lCell = -1;
						rCell = states[j + 1];
						cCell = states[j];
					} else if (j == states.length - 1) {

						lCell = cCell;
						rCell = -1;
						cCell = states[j];
					} else {

						lCell = cCell;
						rCell = states[j + 1];
						cCell = states[j];
					}

					states[j] = lCell == rCell ? 1 : 0;
					if (days == 1) {
						returnList[rIndex] = states[j];
						rIndex++;
					} else {
						dailyList[rIndex] = states[j];
						rIndex++;
						
					}
				}
				statetoNextDayMap.put(mapKey, dailyList);
				
				System.out.println(mapKey + " - " + Arrays.toString(states));
				System.out.println(days);
			}
			// Day i = 1 to 5

			days--;
		}

		return returnList;
	}
	// METHOD SIGNATURE ENDS
}
