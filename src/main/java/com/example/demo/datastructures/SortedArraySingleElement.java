package com.example.demo.datastructures;

public class SortedArraySingleElement {

	public static void main(String[] args) {
		System.out.println("Answer is " + singleNonDuplicate(new int[] { 1,1,2,3,3,4,4,8,8 }));

	}

	public static int singleNonDuplicate(int[] nums) {

		if (nums.length == 1) {
			return nums[0];
		}
		int mid = 0;
		int low = 0;
		int n = -1;
		int high = nums.length-1;
		while (high >= low) {
			mid = (low + high) / 2;
			System.out.println(mid);
			if ((mid == 0 && nums[mid] != nums[mid + 1]) || (mid == nums.length - 1 && nums[mid] != nums[mid - 1])
					|| (mid != 0 && mid != nums.length - 1
							&& !(nums[mid] == nums[mid - 1] || nums[mid] == nums[mid + 1]))) {
				return nums[mid];
			}
			if ((nums[mid] == nums[mid - 1] && mid % 2 == 1) || (mid % 2 == 0 && nums[mid] == nums[mid + 1])) {
				low = mid + 1;
			} else {	
				high = mid;
			}
			//n = singleNonDuplicate(nums, low, high);
		}
		return n;
	}

	public static int singleNonDuplicate(int[] nums, int low, int high) {

		int mid = 0;
		int n = -1;
		while (high >= low) {
			mid = (low + high) / 2;
			System.out.println(mid);
			if ((mid == 0 && nums[mid] != nums[mid + 1]) || (mid == nums.length - 1 && nums[mid] != nums[mid - 1])
					|| (mid != 0 && mid != nums.length - 1
							&& !(nums[mid] == nums[mid - 1] || nums[mid] == nums[mid + 1]))) {
				return nums[mid];
			}
			if ((nums[mid] == nums[mid - 1] && mid % 2 == 1) || (mid % 2 == 0 && nums[mid] == nums[mid + 1])) {
				low = mid + 1;
			} else {
				high = mid;
			}
			//n = singleNonDuplicate(nums, low, high);
		}
		return n;
	}

}
