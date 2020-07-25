package com.example.demo.datastructures;

import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class HRSolution1 {

    // Complete the sockMerchant function below.
    static int sockMerchant(int n, int[] ar) {
        int[] newAr = new int[100];

        int socksPair = 0;
        Set<Integer> pairSet =  new HashSet<Integer>();
        for(int i=0;i<n;i++){
            newAr[ar[i]-1] = newAr[ar[i] -1 ]+1;
            if(pairSet.contains(ar[i])) {
            	socksPair++;
            	pairSet.remove(ar[i]);
            } else {
            	pairSet.add(ar[i]);
            }
        }

//        for(int i=0;i<100;i++){
//            if(newAr[i] > 1) {
//            	socksPair = socksPair + newAr[i]/2 ;
//            }
//        }
        return socksPair;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
       // BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] ar = new int[n];
        
        
        //ar[Integer.parseUnsignedInt(scanner.nextLine().split(" "))]++;

        String[] arItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arItem = Integer.parseInt(arItems[i]);
            ar[i] = arItem;
        }

        int result = sockMerchant(n, ar);
        System.out.println(result);

//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();

        scanner.close();
    }
}

