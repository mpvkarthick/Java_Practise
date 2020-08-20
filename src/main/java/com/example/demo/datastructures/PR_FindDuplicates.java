
package com.example.demo.datastructures;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Karthik Mannepalli
 * @ProblemStatement : Given two sorted arrays arr1 and arr2 of passport
 *                   numbers, implement a function findDuplicates that returns
 *                   an array of all passport numbers that are both in arr1 and
 *                   arr2. Note that the output array should be sorted in an
 *                   ascending order. Level :
 */
public class PR_FindDuplicates {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		findDuplicates(new int[] {1, 2, 3, 5, 6, 7}, new int[] {3, 6, 7, 8, 20});
	}

	static int[] findDuplicates(int[] arr1, int[] arr2) {

		int arr1Index = 0, arr2Index = 0;
		List<Integer> duplicates =  new ArrayList<Integer>();
		while (arr1Index < arr1.length && arr2Index < arr2.length) {

			if (arr1[arr1Index] < arr2[arr2Index]) {
				arr1Index++;
			} else if (arr2[arr2Index] < arr1[arr1Index]) {
				arr2Index++;
			} else {
				duplicates.add(arr1[arr1Index]);
				arr1Index++;
				arr2Index++;
			}
		}
		int[] arr =  new int[duplicates.size()];
		int index = -1;
		for(int num:duplicates) {
			arr[++index] = num;
		}
		System.out.println(duplicates.toString());
		
		return arr;
	}

}
