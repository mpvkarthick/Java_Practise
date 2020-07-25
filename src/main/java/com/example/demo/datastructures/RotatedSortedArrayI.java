package com.example.demo.datastructures;

public class RotatedSortedArrayI {

	public static void main(String[] args) {

		int a[] = { 8,9,2,3,4};
		int b[] = { 3, 4, 5, 6, 7, 8, 9, 1,2 };
		int c[] = {10,11,12,1,2};
		int d[] = {10,11,12,1,2,3,4,5,6,7,8,9};
		for (int i =0;i<a.length;i++) {
			System.out.println("Index of "+a[i]+ " = "+search(a, a[i]));
		}
		System.out.println("*******");
		for (int i =0;i<b.length;i++) {
			System.out.println("Index of "+b[i]+ " = "+search(b, b[i]));
		}
		System.out.println("*******");
		for (int i =0;i<c.length;i++) {
			System.out.println("Index of "+c[i]+ " = "+search(c, c[i]));
		}
		System.out.println("*******");
		for (int i =0;i<d.length;i++) {
			System.out.println("Index of "+d[i]+ " = "+search(d, d[i]));
		}
		//System.out.println(search(a, 1));

	}

	public static int search(int[] nums, int target) {

		int start = 0, end = nums.length - 1;
		int mid = 0;
		if(nums.length == 0) {
			return -1;
		}
		if(nums.length == 1 && target == nums[0]) return 0;
		while (start < end) {

			mid = (start+end)/2;
			if(nums[mid] == target) return mid;
			if(nums[start] == target) return start;
			if(nums[end] == target) return end;
			
			// clean sub array and can apply regular binary search
			
			if(nums[start] <= nums[end] && target > nums[mid]) {
				
				start = mid+1;
			} else if (nums[start] <= nums[end] && target <nums[mid]) {
				end = mid - 1;
			
				// right side sub array and  pivoted
			} else if(nums[mid] >= nums[end] && nums[mid]>=nums[start]) {
				// if number is on right side of mid
				if(target <nums[mid] && target >=nums[start]) {
					end = mid - 1;
				}
				//if number is left side of mid
				else {
					start = mid+1;
				}
				
				
			} // left side sub array and pivoted 
			else {
				// number on left side of mid
				if(target > nums[mid] && target <= nums[end]) {
					start = mid +1;
				} else {
					end = mid-1;
				}
				
				
			}
		}

		return -1;
	}
}
