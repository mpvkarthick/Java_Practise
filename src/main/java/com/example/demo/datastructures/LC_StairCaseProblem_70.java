
package com.example.demo.datastructures;

/**
 * @author Karthik Mannepalli
 * @ProblemStatement : https://leetcode.com/problems/climbing-stairs/submissions/
 * @Level : Easy
 */
public class LC_StairCaseProblem_70{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		climbStairs(45);

	}

	public static void climbStairs(int n) {

		int distinctWays = 0;
		distinctWays = climbStairsNoMemoization(n);
		System.out.println("No Memoization " + distinctWays);
		distinctWays = climbStairsWithMemoization(n, new int[n + 1]);
		System.out.println("With Memoization " + distinctWays);
	}

	public static int climbStairsNoMemoization(int n) {
		int distinctWays = 0;
		if (n == 0) {
			return 1;
		} else if (n == 1) {
			return 1;
		} else {
			distinctWays = climbStairsNoMemoization(n - 1) + climbStairsNoMemoization(n - 2);
		}
		return distinctWays;
	}

	public static int climbStairsWithMemoization(int n, int[] memo) {

		if (n == 0) {
			return 1;
		}
		if (n == 1) {
			return 1;
		}
		if (memo[n] > 0) {
			return memo[n];
		}
		memo[n] = climbStairsWithMemoization(n - 1,memo) + climbStairsWithMemoization(n - 2,memo);
		return memo[n];
	}

}
