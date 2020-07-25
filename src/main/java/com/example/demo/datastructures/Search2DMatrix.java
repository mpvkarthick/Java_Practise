package com.example.demo.datastructures;

public class Search2DMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = {{1,   4,  7, 11, 15},{2,   5,  8, 12, 19},{3,   6,  9, 16, 22},{10, 13, 14, 17, 24},{18, 21, 23, 26, 30}};

		Search2DMatrix matrix2 =  new Search2DMatrix();
		System.out.println("Value found "+ matrix2.searchMatrix(matrix, 1));
	}

	public boolean searchMatrix(int[][] matrix, int target) {

		return searchMatrix(matrix, target, 0, matrix.length-1, 0, matrix[0].length-1);
		
	}
	
	public boolean searchMatrix(int[][] matrix, int target, int beginRow, int endRow, int beginCol,int endCol) {
		int midrow=(beginRow+endRow)/2;
		int midCol=(beginCol+endCol)/2;
		int tempEndCol=endCol,tempBeginCol=beginCol;
		int tempEndRow=endRow,tempBeginRow=beginRow;
		if(beginRow > endRow || beginCol > endCol ) {
			return false;
		}
		
		if(matrix[beginRow][midCol] == target || matrix[midrow][beginCol] == target) {
			return true;
		}
		
		if(matrix[beginRow][midCol] > target) {
			tempEndCol = midCol;
		} else {
			tempBeginCol = midCol;
		}
		
		if(matrix[midrow][beginCol] > target) {
			tempEndRow = midrow;
		} else {
			tempBeginRow = midrow;
		}
		
		return searchMatrix(matrix, target, tempBeginRow, tempEndRow, tempBeginCol, tempEndCol);
	}
}
