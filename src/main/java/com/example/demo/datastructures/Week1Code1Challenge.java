package com.example.demo.datastructures;

public class Week1Code1Challenge {

	public static void main(String[] args) {

		System.out.println(firstBadVersion(2));
	}

	public static int firstBadVersion(int n) {

		if (n == 1) {
			return 1;
		}
		long low = 0, high = n;
		long mid = 0;
		while (low <= high) {
			mid = (low + high) / 2;
			if (isBadVersion((int) mid)) {
				high = mid - 1;
			} else {
				if (isBadVersion((int) mid + 1)) {
					return (int) mid + 1;
				} else {
					low = mid + 1;
				}
			}
		}
		return (int) mid;

	}

	public static boolean isBadVersion(int version) {

		if (version >= 1) {
			return true;
		}
		return false;
	}
}
