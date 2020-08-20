/**
 * @author Karthik Mannepalli
 * Problem Statement : 
 * Level : 
 */
package com.example.demo.datastructures;

/**
 * @author Karthik Mannepalli
 * @ProblemStatement : https://leetcode.com/problems/single-number-ii/
 * @Level : Medium
 */
public class LC_SingleNumberII_137 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(singleNumber(new int[] {0,1,0,1,0,1,99}));

	}

	public static int singleNumber(int[] nums) {
		int ans = 0, x = 0, sum = 0;
		for (int i = 0; i < 32; i++) {
			sum = 0;
			x = 1 << i;
			for (int j = 0; j < nums.length; j++) {
				if ((nums[j] & x) != 0) {
					sum++;
				}
			}
			if (sum % 3 != 0) {
				ans |= x;
			}
		}
		return ans;
	}
}
