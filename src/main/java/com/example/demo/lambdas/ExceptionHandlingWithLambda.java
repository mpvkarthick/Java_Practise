package com.example.demo.lambdas;

import java.util.function.BiConsumer;

public class ExceptionHandlingWithLambda {

	public static void main(String[] args) {
		int[] somenumbers = { 1, 2, 3, 4 };
		int key = 2;
		process(somenumbers, key, wrapperProcess((v, k) -> System.out.println(v / (v-k))));
	}

	private static void process(int[] somenumbers, int k, BiConsumer<Integer, Integer> bic) {

		for (int v : somenumbers) {
			System.out.println("Entered Process");
			bic.accept(v, k);
		}
	}

	private static BiConsumer<Integer, Integer> wrapperProcess(BiConsumer<Integer, Integer> bic) {

		return (a, b) -> {

			try {
				bic.accept(a, b);
				System.out.println("Executed Operation");
			} catch (Exception e) {
				System.out.println("Error / 0");
			}
		};
	}
}
