package com.example.demo.datastructures;

public class RainWaterTrapping {

	public static void main(String[] args) {

		System.out.println(trap(new int[] {4,2,3}));
	}

	public static int trap(int[] height) {

		int n = height.length;
		if (n < 3) {
			return 0;
		}
		int lmax = height[0];
		int rmax = height[n - 1];
		int totalWater = 0;
		int i = 0;
		int j = n - 1;
		while (i<=j) {
			lmax = Math.max(lmax, height[i]);
			rmax = Math.max(rmax, height[j]);
			if(lmax < rmax) {
				totalWater = totalWater+(lmax - height[i]);
				i++;
			} else {
				totalWater = totalWater+(rmax - height[j]);
				j--;
			}
		}
		return totalWater;
	}
}
