package com.example.demo.datastructures;

public class NumberOfIslands {

	public static void main(String[] args) {
		char grid[][] = { { '1', '1', '1' }, { '1', '1', '0' }, { '1', '0', '1' } };
		System.out.println(numIslands(grid));

	}

	public static int numIslands(char[][] grid) {

		int islands = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == '1') {
					checkNeighboringIsland(grid, i, j);
					islands++;
				}
			}
		}
		return islands;
	}

	public static boolean checkNeighboringIsland(char[][] grid, int i, int j) {

		if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == '2' || grid[i][j] == '0') {
			return true;
		}
		grid[i][j] = '2';
		checkNeighboringIsland(grid, i, j - 1);
		checkNeighboringIsland(grid, i, j + 1);
		checkNeighboringIsland(grid, i - 1, j);
		checkNeighboringIsland(grid, i + 1, j);
		return false;
	}

}
