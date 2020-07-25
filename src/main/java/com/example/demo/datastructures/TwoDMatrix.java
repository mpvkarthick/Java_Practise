package com.example.demo.datastructures;

public class TwoDMatrix {

	public static void main(String[] args) {

		int matrix[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		rotate(matrix);
		for (int i = 0; i < matrix.length; i++) {
			
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}

	}

	public static void rotate(int[][] matrix) {

		// first transpose the matrix
		int temp;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = i; j < matrix.length; j++) {

				temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;

			}
		}
		int n =  matrix.length;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < n/2; j++) {
				temp = matrix[i][j];
				matrix[i][j] = matrix[i][n-j-1];
				matrix[i][n-j-1] = temp;

			}
		}

	}
}
