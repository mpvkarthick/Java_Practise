package com.example.demo.datastructures;

import java.io.IOException;
import java.util.Scanner;

public class HRSolution4 {

	static int countingValleys(int n, String s) {
		
		int valleys = 0;
		int sum1 = 0,sum2 =0;
		for(int i=0;i<n;i++) {
			if(s.charAt(i) == 'U') {
				sum2++;
			} else {
				sum2--;
			}
			
			if(sum2 == -1 && sum1 ==0) {
				valleys++;
				sum1=1;
			}
			if(sum2 ==0) {
				sum1 = 0;
			}
		}
		
		return valleys;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();

        int result = countingValleys(n, s);
        
        System.out.println(result);

        scanner.close();
    }

}
