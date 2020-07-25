package com.example.demo.datastructures;

import java.util.HashSet;
import java.util.Set;

public class RottingOranges {

	public static void main(String[] args) {
		System.out.println(
				"Minutes to rot oranges " + orangesRotting(new int[][] { {0,2} }));
	}

	public static int orangesRotting(int[][] grid) {

		int minutes = 0;
		Set<String> visitedNodes;
		if(grid.length == 0) {
			return 0;
		}
		if(grid.length == 1 && grid[0].length == 1) {
			if(grid[0][0] == 0 || grid[0][0] == 2) return 0;
			if(grid[0][0] == 1) return -1;
		}
		int totalOranges = 0, consolidatedOranges = 0;
		for (int row = 0; row < grid.length; row++) {
			for (int column = 0; column < grid[row].length; column++) {
				int rottenOrangesThisRound = 0;
				if (grid[row][column] == 0 || grid[row][column] == 1) {
					if (grid[row][column] == 1) {
						totalOranges = totalOranges + 1;
					}
					continue;
				} else {
					totalOranges = totalOranges + 1;
					visitedNodes = new HashSet<String>();
					rottenOrangesThisRound = updateRottenOranges(grid, row, column, rottenOrangesThisRound,
							visitedNodes);
					//System.out.println("Rotten Oranges this round " + rottenOrangesThisRound);
				}
				if (rottenOrangesThisRound > 0) {
					minutes++;
					consolidatedOranges = consolidatedOranges + rottenOrangesThisRound;
				}
				rottenOrangesThisRound = 0;
			}

		}
		if(consolidatedOranges > 0) consolidatedOranges = consolidatedOranges+1;
		return consolidatedOranges == totalOranges ? minutes : -1;
	}

	public static int updateRottenOranges(int[][] grid, int row, int column, int rottenOrangesThisRound,
			Set<String> visitedNodes) {

		if (row == grid.length - 1 && column == grid[row].length - 1) {
			return rottenOrangesThisRound;
		}

		// same row, the next column
		if (grid[row][column] == 2 && column + 1 <= grid[row].length - 1 && grid[row][column + 1] == 1
				&& !visitedNodes.contains(String.valueOf(row) + String.valueOf(column)) && grid[row][column + 1] == 1) {

			grid[row][column + 1] = 2;
			rottenOrangesThisRound++;
			visitedNodes.add(String.valueOf(row) + String.valueOf(column + 1));
		}

		// row below, same column
		if (grid[row][column] == 2 && row + 1 <= grid.length - 1 && grid[row + 1][column] == 1
				&& !visitedNodes.contains(String.valueOf(row) + String.valueOf(column)) && grid[row + 1][column] == 1) {
			grid[row + 1][column] = 2;
			visitedNodes.add(String.valueOf(row + 1) + String.valueOf(column));
			rottenOrangesThisRound++;
		}
		// row above, same column
		if (grid[row][column] == 2 && row - 1 >= 0 && grid[row - 1][column] == 1
				&& !visitedNodes.contains(String.valueOf(row) + String.valueOf(column)) && grid[row - 1][column] == 1) {
			grid[row - 1][column] = 2;
			visitedNodes.add(String.valueOf(row - 1) + String.valueOf(column));
			rottenOrangesThisRound++;
		}

		if (column == grid[row].length - 1) {
			++row;
		} else {
			++column;
		}
		rottenOrangesThisRound = updateRottenOranges(grid, row, column, rottenOrangesThisRound, visitedNodes);
		return rottenOrangesThisRound;
	}

}
