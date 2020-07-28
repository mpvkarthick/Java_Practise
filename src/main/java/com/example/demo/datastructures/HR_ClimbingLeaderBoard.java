
package com.example.demo.datastructures;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Karthik Mannepalli
 * @Problem Statement :
 *          https://www.hackerrank.com/challenges/climbing-the-leaderboard/problem
 * @Level : Medium
 */
public class HR_ClimbingLeaderBoard {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(Arrays.toString(
				climbingLeaderboard(new int[] { 100,90,90,80,75,60 }, new int[] { 50,65,77,90,102 })));
	}

	// {1=1, 2=1, 3=2, 4=3, 5=3, 6=4, 7=5}
	static int[] climbingLeaderboard(int[] scores, int[] alice) {

		int [] result = new int[alice.length];
		// precompute the score
		
		Map<Integer, Integer> positionRankMap = new HashMap<Integer, Integer>();
		positionRankMap.put(1, 1);
		for(int index = 1;index<scores.length;index++) {
			if(scores[index]==scores[index-1]) {
				positionRankMap.put(index+1, positionRankMap.get(index));
			} else {
				positionRankMap.put(index+1, positionRankMap.get(index)+1);
			}
		}
		
		for(int index =0;index<alice.length;index++) {
			int aliceScore = alice[index];
			int position = returnScorePosition(scores, aliceScore);
			//System.out.println("Alice Score "+aliceScore+", Position is "+position);
			if(scores[position] > aliceScore) {
				result[index] = positionRankMap.get(position+1)+1;
			} else if (scores[position] <= aliceScore) {
				result[index] = positionRankMap.get(position+1);
			}
		}
		
 		return result;
    }

	static int returnScorePosition(int[] scores, int aliceScore) {

		int begin = 0, end = scores.length - 1, mid = (begin + end) / 2;

		while (begin < end) {
			if (aliceScore < scores[mid]) {
				begin = mid + 1;
			} else {
				end = mid - 1;
			}
			mid = (begin + end) / 2;
		}

		return mid;
	}

}
