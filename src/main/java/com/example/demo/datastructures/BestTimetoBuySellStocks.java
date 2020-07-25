package com.example.demo.datastructures;

public class BestTimetoBuySellStocks {

	public static void main(String[] args) {

		System.out.println(maxProfit(new int[] { 2,4,1,8,5,2,14}));
	}

	public static int maxProfit(int[] prices) {

		int cp = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < cp)
                cp = prices[i];
            else if (prices[i] - cp > maxprofit)
                maxprofit = prices[i] - cp;
        }
        return maxprofit;
	}
}
