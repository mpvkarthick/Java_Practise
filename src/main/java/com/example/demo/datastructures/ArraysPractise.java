package com.example.demo.datastructures;

public class ArraysPractise {

	public static void main(String[] args) {

		int[] nums = {12,345,2,6,7896,1};
		System.out.println("Count is "+findNumbers(nums));

	}

	public static int findNumbers(int[] nums) {
        int count = 0;
        for(int n:nums){
            if(findLength(n,-1) %2 ==0) {
            	count++;
            }
            
            
        }
        return count;
    }
    
	static int findLength(int n, int sum) {
		
		if(n/10 == 0) {
			return sum;
		}
		return findLength(n/10, ++sum);
	}
}
