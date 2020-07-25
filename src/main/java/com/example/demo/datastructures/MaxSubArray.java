package com.example.demo.datastructures;

public class MaxSubArray {

	public static void main(String[] args) {
		System.out.println(maxSubArray(new int[] {-2,1,-3,4,-1,2,1,-5,4}));
	}

	public static int maxSubArray(int[] nums) {

		if(nums.length == 0) {
			return 0;
		}
		int sum=nums[0],maxsum=nums[0];
		
		for(int i=1;i<nums.length;i++) {
			
			sum=Math.max(nums[i], sum+nums[i]);
			maxsum = Math.max(sum, maxsum);
			
		}
		
		return maxsum;
	}
}
