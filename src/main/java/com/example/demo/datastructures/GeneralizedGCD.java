package com.example.demo.datastructures;

public class GeneralizedGCD {

	public static void main(String[] args) {

		System.out.println(generalizedGCD(3, new int[] {0,1,2,3}));
	}

	public static int generalizedGCD(int num, int[] arr) {

		int gcd = arr[0];
		for(int i=1;i<num;){
			
			int reminder = gcd == 0 ?arr[i]:arr[i] % gcd;
			if(reminder != 0) {
				gcd = reminder;
			} 
			i++;
		}
		
		return gcd;
	}
	
	
	static int gcd(int a, int b) 
    { 
        if (a == 0) 
            return b; 
        return gcd(b % a, a); 
    } 
  
    // Function to find gcd of array of 
    // numbers 
    static int findGCD(int arr[], int n) 
    { 
        int result = arr[0]; 
        for (int i = 1; i < n; i++) 
            result = gcd(arr[i], result); 
  
        return result; 
    } 
}
