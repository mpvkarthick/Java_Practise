/**
 * @author Karthik Mannepalli
 * Problem Statement : 
 * Level : 
 */
package com.example.demo.datastructures;

/**
 * @author cpsdadmin
 *
 */
public class LC_ReverseUnSignedInteger {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(reverse(-120));

	}

	public static int reverse(int x) {

		double sum=0;
		
		if (x > Integer.MAX_VALUE || x < Integer.MIN_VALUE) {
			return 0;
		}
		if (x < 0
				&& (0-x) > Integer.MAX_VALUE) {

			return 0;
		}
		else {
			while(Math.abs(x) > 0) {
				sum =(sum*10) + (x%10);
				x=x/10;
			}
		}
		return sum>Integer.MAX_VALUE || sum<Integer.MIN_VALUE?0:(int) Math.round(sum);
	}

}
