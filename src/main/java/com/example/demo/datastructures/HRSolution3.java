package com.example.demo.datastructures;

import java.io.IOException;
import java.util.Scanner;

public class HRSolution3 {

	// Complete the repeatedString function below.
    static long repeatedString(String s, long n) {
    	
    	long aCount=0;
    	for(int i=0;i<s.length();i++) {
    		if(s.charAt(i) == 'a') {
    			aCount++;
    		}
    	}
    	aCount = (n/s.length())*aCount;
    	for(int j=0;j<n%s.length();j++) {
    		if(s.charAt(j) == 'a') {
    			aCount++;
    		}
    	}
    	return aCount;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        long n = scanner.nextLong();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long result = repeatedString(s, n);
        System.out.println(result);

//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();

        scanner.close();
    }
}
