package com.example.demo.datastructures;

import java.util.Arrays;

public class CoinChange2 {

	public static void main(String[] args) {
		System.out.println(change(5,new int[] {1,2,5}));

	}

	public static int change(int amount, int[] coins) {

		
		//first sort the coins array
		Arrays.sort(coins);
		//initialize an array that is of size amount
		int[] combinations = new int[amount+1];
		combinations[0]=1;
		
		// iterate through the coins array
		
		for(int coin:coins) {
			
			// if the coin is less than combination index ignore else 
			// subtract the amount and pull the number from the index of difference
			// combination[index] = combination[coin-index] +combination[index]
			for(int index = coin;index<combinations.length;index++) {
				combinations[index] = combinations[index]+combinations[index-coin];
			}
		}
		System.out.println(Arrays.toString(combinations));
		return combinations[amount];

	}

}
