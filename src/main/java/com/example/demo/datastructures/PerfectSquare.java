package com.example.demo.datastructures;

import java.math.BigInteger;

public class PerfectSquare {

	public static void main(String[] args) {
		System.out.println(isPerfectSquare(Integer.MAX_VALUE));

	}

	public static boolean isPerfectSquare(int num) {

		if (num < 0 || num == 2) {
			return false;
		}
		if (num == 1 || num ==4) {
			return true;
		}
		long low = 1;
		long high = num/2;
		long mid;
		while(low<=high) {
			
			mid = (low+high)/2;//new BigInteger(String.valueOf(low)).add(new BigInteger(String.valueOf(high))).divide(new BigInteger("2"));
			if (mid*mid == num) {
				return true;
			} else {
				if (mid*mid > num) {
					high = mid-1;
				} else {
					low = mid+1;
				}
			}
		}
		
		return false;
	}
}
