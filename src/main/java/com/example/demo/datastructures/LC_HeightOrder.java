package com.example.demo.datastructures;

public class LC_HeightOrder {

	public static void main(String[] args) {
		System.out.println(heightChecker(new int[] {1,1,4,2,1,3}));

	}

	public static int heightChecker(int[] heights) {

		
		boolean isDone = true;
		int temp;
		int swaps = 0;
		boolean isSwapped = false;
		for(int j=0;j<heights.length;j++){
			isSwapped = false;
			for(int i=heights.length-1;i>=0;i--) {
				if(i-1 >=0 && heights[i] < heights[i-1]) {
					isSwapped =true;
					temp = heights[i];
					heights[i] = heights[i-1];
					heights[i-1] = temp;
				}
			}
			if(isSwapped) {
				swaps++;
			}
		}
		
		return swaps;
	}
}
