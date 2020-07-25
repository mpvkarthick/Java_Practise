/**
 * 
 */
package com.example.demo.datastructures;

import java.util.Arrays;

/**
 * @author Karthik Mannepalli
 * Problem Statement
 * Given an array nums. We define a running sum of an array as 
 * runningSum[i] = sum(nums[0]…nums[i]).
 * Return the running sum of nums.
 *
 * Level Easy
 */
public class RunningSumOf1DArray_1480 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		RunningSumOf1DArray_1480 r = new RunningSumOf1DArray_1480();
		System.out.println(Arrays.toString(r.runningSum(new int[] {3,1,2,10,1})));

	}

	/**
	 * @param nums
	 * @return
	 * Time Complexity - O(n), Space Complexity - O(1)
	 */
	public int[] runningSum(int[] nums) {

		for(int i=1;i<nums.length;i++){
			nums[i] = nums[i]+nums[i-1];
		}
		
		return nums;
	}

}
