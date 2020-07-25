package com.example.demo.datastructures;

public class MostWaterContainer {

	public static void main(String[] args) {
	 
		System.out.println(maxArea(new int[] {1,8,6,2,5,4,8,3,7}));

	}

	public static int maxArea(int[] height) {

		// target is to chose 2 bars that will have
		// max heights
		// separated by max distance

		// how to chose max heights?
		// iterate through the array, have variables for left and right container and
		// distance
		
		int maxArea = 0;
		int left = 0;
		int right = height.length-1;
		int area;
		while (right > left) {
			area = Math.min(height[left], height[right])*(right-left) ;
			maxArea = Math.max(area, maxArea);
			if (height[left] <height[right]) {
				left++;
			} else {
				right--;
			}
		}
		
		return maxArea;
	}
}
