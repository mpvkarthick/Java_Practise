package com.example.demo.datastructures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;

public class ThreeSum {

	public static void main(String[] args) {
		System.out.println(String.valueOf(threeSum(new int[] { 12, 3, 4, 1, 6, 9 })));
	}

	public static List<List<Integer>> threeSum(int[] nums) {

		List<List<Integer>> threeSumList = new ArrayList<List<Integer>>();
		Arrays.sort(nums);
		for (int i = 0; i < nums.length; i++) {
			if (!(nums[i] > 0 || (i > 0 && nums[i] == nums[i - 1]))) {

				threeSumList.addAll(twoSum(nums, 0 - nums[i], i + 1, nums[i]));
			}
		}

		return threeSumList;
	}

	public static List<List<Integer>> twoSum(int[] nums, int sum, int index, int currentValue) {

		Map<Integer, Integer> twoSumMap = new HashMap<Integer, Integer>();
		List<List<Integer>> threeSumList = new ArrayList<>();
		List<Integer> templist;
		Set<String> keySet = new HashSet<String>();
		for (int i = index; i < nums.length; i++) {
			if (twoSumMap.containsKey(nums[i])) {
				templist = new ArrayList<Integer>();
				templist.add(nums[i]);
				templist.add(twoSumMap.get(nums[i]));
				templist.add(currentValue);
				if (!keySet.contains(String.valueOf(templist))) {
					threeSumList.add(templist);
					keySet.add(String.valueOf(templist));
				}

			} else {
				twoSumMap.put(sum - nums[i], nums[i]);
			}

		}
		return threeSumList;
	}
}
