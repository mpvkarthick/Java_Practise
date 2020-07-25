package com.example.demo.datastructures;

import java.util.Arrays;

public class NextGreaterElement {

	public static void main(String[] args) {
		int[] newNums = nextGreaterElements(new int[] {});
		System.out.println(Arrays.toString(newNums));

	}

	public static int[] nextGreaterElements(int[] nums) {

		
		
		int[] newNums = new int[nums.length];
		if(nums.length ==1) {
			return new int[] {-1};
		}
		if(nums.length == 2) {
			newNums[0] = nums[1]>nums[0]?nums[1]:-1;
			newNums[1] = nums[0]>nums[1]?nums[0]:-1;
			return newNums;
		}
		int j=0;
		int end = 0;
		boolean found = false;
		for(int i=0;i<nums.length;i++) {
			
			if(i == nums.length -1) {
				j=0; 
				end = nums.length-2;
			} else {
				j = i+1;
				end = i-1 < 0? nums.length-2:i-1;
			}
			
			found = false;
			while(j != end+1) {
				//logic to find the next largest
				if(nums[j] > nums[i]) {
					newNums[i] = nums[j];
					found=true;
					break;
				}
				if(j == nums.length-1) {
					j=0;
				} else {
					j++;
				}
			}
			if(!found) {
				newNums[i] = -1;
			}
			
		}
		
		return newNums;
	}

}
