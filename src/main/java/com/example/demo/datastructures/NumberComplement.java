package com.example.demo.datastructures;

public class NumberComplement {

	public static void main(String[] args) {
		System.out.println(findComplement(5));
	}

	public static int findComplement(int num) {

		if (num <= 0) {
			return 0;
		}
		int sum = 0, exp = 0;
		while (num > 0) {
			sum = sum + ((num % 2 ^ 1) * (int)Math.pow(2, exp));
			num = num / 2;
			exp++;
		}
		return sum;
	}
}
