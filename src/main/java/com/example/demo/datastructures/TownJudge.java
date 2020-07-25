package com.example.demo.datastructures;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class TownJudge {

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		System.out.println(findJudge(2, new int[][] {{1,2}}));
		System.out.println(findJudge(3, new int[][] {{1,3},{2,3}}));
		System.out.println(findJudge(3, new int[][] {{1,3},{2,3},{3,1}}));
		System.out.println(findJudge(3, new int[][] {{1,2},{2,3}}));
		System.out.println(findJudge(4, new int[][] {{1,3},{1,4},{2,3},{2,4},{4,3}}));
		long endTime = System.currentTimeMillis();
		System.out.println("Time of Execution in MS : " +TimeUnit.MILLISECONDS.toMillis(endTime-startTime));

	}

	public static int findJudge(int N, int[][] trust) {

		if (trust.length == 0 || (trust.length == 1 && trust[0].length == 0)) {
			return 1;
		}
		int[] trusteeArray = new int[N];
		Set<Integer> trustSet = new HashSet<>();
		int judge = 0;
		for (int[] trustArray : trust) {
			trusteeArray[trustArray[0] - 1]--;
			trusteeArray[trustArray[1] - 1]++;
			trustSet.add(trustArray[0]);
			if (trusteeArray[trustArray[1] - 1]== N-1) {
				judge = trustArray[1];
			}
		}
		return judge >0 && !trustSet.contains(judge)?judge:-1;
	}
}
