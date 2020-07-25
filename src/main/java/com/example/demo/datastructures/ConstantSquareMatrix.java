package com.example.demo.datastructures;

import java.util.HashSet;
import java.util.Set;

public class ConstantSquareMatrix {

	public static void main(String[] args) {

		//int[][] matrix = { { 0, 1, 1, 1 }, { 1, 1, 1, 1 }, { 0, 1, 1, 1 } };
		
		int[][] matrix = { {1} };
		System.out.println(countSquares(matrix));
	}

	public static int countSquares(int[][] matrix) {

		Set<String> indexSet = new HashSet<String>();
		int count = 0;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if ((matrix[i][j] == 0 && !indexSet.contains(i + "|" + j)) || indexSet.contains(i + "|" + j)) {
					indexSet.add(i + "|" + j);
					continue;
				} else {
					count = count + 1 + subSquareCount(1, matrix, i, j);
				}

			}
		}
		return count;
	}

	public static int subSquareCount(int index, int[][] matrix, int i, int j) {
		int maxSquareSize = matrix.length <= matrix[0].length ? matrix.length : matrix[0].length;
		int count = 0;
		if (index == maxSquareSize || i+index >=matrix.length || j+index >= matrix[0].length) {
			return count;
		}
		for (int iIndex = i; iIndex <= (i + index); iIndex++) {
			for (int jIndex = j; jIndex <= (j + index); jIndex++) {
				if (matrix[iIndex][jIndex] == 0) {
					return count;
				}
			}
		}
		count++;
		//System.out.println("Square with sides " + (index + 1) + "for co-ordinates (" + i + "," + j + ") is " + count);
		count += subSquareCount(++index, matrix, i, j);
		return count;
	}
}
