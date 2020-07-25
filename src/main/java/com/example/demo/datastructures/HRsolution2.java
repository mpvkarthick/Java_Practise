package com.example.demo.datastructures;

import java.io.IOException;
import java.util.Scanner;

/**
 * @author Karthik Mannepalli
 *         https://www.hackerrank.com/challenges/jumping-on-the-clouds/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=warmup
 *
 * 
 * 
 * 
 */
public class HRsolution2 {

	// Complete the jumpingOnClouds function below.
	static int jumpingOnClouds(int[] c) {

		int jumps = 0;
		for (int i = 0; i < c.length; i++) {
			if ((i <= c.length-2) && (c[i + 2] == 0)) {
				
				i = i + 1;
			} jumps++;
		}
		return jumps;
	}

	static void test(int[] nums) {
		
		 int count = 0;
	        int sum = 0;
	        for(int i=0;i<nums.length;i++){
	            if(nums[i] == 1){
	                count++;
	                if(count >sum){
	                    sum = count;
	                }
	            } else {
	                count = 0;
	            }
	        }
	        System.out.println(sum);
	}
	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		// BufferedWriter bufferedWriter = new BufferedWriter(new
		// FileWriter(System.getenv("OUTPUT_PATH")));

		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int[] c = new int[n];

		String[] cItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < n; i++) {
			int cItem = Integer.parseInt(cItems[i]);
			c[i] = cItem;
		}

		test(c);
//		int result = jumpingOnClouds(c);
//		System.out.println(result);

//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();

		scanner.close();
	}

}
