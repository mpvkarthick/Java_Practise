
package com.example.demo.datastructures;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Karthik Mannepalli
 * @ProblemStatement :
 *                   https://www.hackerrank.com/contests/hack-the-interview-vi/challenges/maximum-sum-10-1
 * @Level : Easy
 */
public class HR_ArraySumOperation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Integer> op = new ArrayList<Integer>();
		op.add(4);
		op.add(2);
		List<Long> operationResult = performOperations(3, op);
		operationResult.stream().forEach(i -> System.out.println(i));
	}

	@SuppressWarnings("unlikely-arg-type")
	public static List<Long> performOperations(int N, List<Integer> op) {

		List<Integer> nums = new ArrayList<Integer>();
		long sum = 0;
		for (int i = 1; i <= N; i++) {
			nums.add(i);
			sum += i;
		}
		int temp;
		List<Long> operationResult = new ArrayList<Long>();
		for (int ops : op) {
			if (nums.contains(ops)) {
				temp = nums.get(0);
				nums.set(0, nums.get(nums.size() - 1));
				nums.set(nums.size() - 1, temp);
			} else {
				sum -= nums.get(nums.size() - 1);
				nums.remove(nums.size() - 1);
				nums.add(ops);
				sum += ops;
			}
			operationResult.add(sum);
		}
		return operationResult;
	}

}
