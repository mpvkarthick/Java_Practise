/**
 * @author Karthik Mannepalli
 * Problem Statement : 
 * Level : 
 */
package com.example.demo.datastructures;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Karthik Mannepalli
 * @ProblemStatement : https://www.geeksforgeeks.org/find-a-triplet-that-sum-to-a-given-value/
 * @Level : Medium
 */
public class GFG_TripletSumToValue {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(Arrays.toString(getTriplets(new int[] {12, 3, 4, 2, 6, 9}, 24)));

	}
	
	public static int[] getTriplets(int [] input, int sum) {
		
		int e1;
		int [] threeSum = new int[3];
		for(int i=0;i<input.length;i++) {
			threeSum = new int[3];
			e1 = input[i];
			// find the 2 sum for remaining numbers
			threeSum = findTwoSum(input, sum-e1, i);
			if(threeSum[0]+threeSum[1]+e1 == sum) {
				threeSum[2] =e1;
				break;
			}
		}
		return threeSum;
	}
	
	public static int[] findTwoSum(int []input, int sum,int index) {
		
		int []twoSum = new int[3];
		Map<Integer, Integer> diffIndexMap =  new HashMap<>();
		for(int i=index+1;i<input.length;i++) {
				if(diffIndexMap.containsKey(input[i])) {
					twoSum[0] = input[i];
					twoSum[1] = input[diffIndexMap.get(input[i])];
					return twoSum;
				}
				diffIndexMap.put(sum-input[i], i);
		}
		return twoSum;
	}

}
