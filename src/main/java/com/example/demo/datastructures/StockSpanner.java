package com.example.demo.datastructures;

import java.util.Stack;

public class StockSpanner {
	Stack<Integer> prices;
	int weights;

	public StockSpanner() {
		prices = new Stack<Integer>();
		weights = 0;;
	}

	public int next(int price) {
		int w = 1;
		while (!prices.isEmpty() && prices.peek() <= price) {
			prices.pop();
			w += weights;
		}
		prices.push(price);
		
//		if (w == 0) {
//			w = 1;
//		} else {
//			weights = weights + w ;
//			w = weights;
//		}
		weights = w;
		return w;
	}
}
