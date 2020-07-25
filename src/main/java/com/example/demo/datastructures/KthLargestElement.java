package com.example.demo.datastructures;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KthLargestElement {

	public static void main(String[] args) {

		System.out.println(findKthLargest(new int[] { 3,2,1,5,6,4 }, 5));
	}

	public static int findKthLargest(int[] nums, int k) {

		// start with left most child node

		//System.out.println(Arrays.toString(heapify(nums)));
		PriorityQueue<Integer> heap =  new PriorityQueue<>((n1,n2) ->n1-n2);
		for(int i= 0;i<nums.length;i++) {
			heap.add(i);
			if(heap.size() > k) {
				heap.poll();
			}
		}
		return heap.poll();
	}

	public static int[] heapify(int[] nums) {
		
		for(int i=nums.length -1;i>=0;i--) {
			
			swap(nums, i);
		}
		
		return nums;
	}

	public static void swap(int nums[], int currentNodeIndex) {

		int parentIndex = (currentNodeIndex) /2;
		int temp = 0;
		while(parentIndex >= 0 && nums[currentNodeIndex] > nums[parentIndex]) {
			
			temp = nums[currentNodeIndex];
			nums[currentNodeIndex] = nums[parentIndex];
			nums[parentIndex] = temp;
			swap(nums, parentIndex);
		}
	}
}
