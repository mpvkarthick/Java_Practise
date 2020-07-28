
package com.example.demo.datastructures;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Karthik Mannepalli
 * @Problem Statement : https://www.hackerrank.com/challenges/cut-the-sticks/problem
 * @Level : Unknown
 */
public class HR_CutTheStick {

	// Complete the cutTheSticks function below.
    static int[] cutTheSticks(int[] arr) {
    	
    	int leastSizeIndex = 0;
    	int sliceCount=0;
    	int [] arrCount = new int[arr.length];
    	int arrCountIndex = -1;
    	Arrays.sort(arr);
    	while(true) {
    		sliceCount=0;
    		for(int i=leastSizeIndex+1;i<arr.length;i++) {
    			if(arr[i] > 0) {
    				arr[i] = arr[i]-arr[leastSizeIndex];
        			sliceCount++;
    			}
    			
    		}
    		if(sliceCount == 0) {
    			break;
    		}
    		arr[leastSizeIndex]=0;
    		//index = leastSizeIndex+1;
    		
    		while(leastSizeIndex<arr.length) {
    			if(arr[leastSizeIndex]>0) {
    				//leastSizeIndex = index;
    				//++leastSizeIndex;
    				break;
    			}
    			leastSizeIndex++;
    		}
    		++arrCountIndex;
    		arrCount[arrCountIndex] = ++sliceCount;
    		if(leastSizeIndex == arr.length-1) {
    			++arrCountIndex;
    			arrCount[arrCountIndex] = 1;
    			break;
    		} 
    		
    		
    	}
    	int[] stickCount = new int[arrCountIndex+1];
    	for(int i=0;i<arrCountIndex+1;i++) {
    		stickCount[i] = arrCount[i];
    	}
    	return stickCount;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int[] result = cutTheSticks(arr);

        System.out.println(Arrays.toString(result));
        scanner.close();
    }

}
