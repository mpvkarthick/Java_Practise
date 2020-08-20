/**
 * @author Karthik Mannepalli
 * Problem Statement : 
 * Level : 
 */
package com.example.demo.datastructures;

import java.util.Arrays;

/**
 * @author cpsdadmin
 *
 */
public class LC_Array_PartitionI_561 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(arrayPairSum(new int[] {9,2,4,1,6,5}));

	}

	public static int arrayPairSum(int[] nums) {
		
		Arrays.sort(nums);
		int sum = 0;
		
		int index=0;
		while(index < nums.length) {
			sum += Math.min(nums[index], nums[index+1]);
			index+=2;
		}

		return sum;
	}

}
