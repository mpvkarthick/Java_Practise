package com.example.demo.datastructures;

import java.util.Arrays;

public class FloodFill {

	public static void main(String[] args) {
		int image[][] = { { 1, 1, 1 }, { 1, 1, 0 }, { 1, 0, 1 } };
		image = floodFill(image, 1, 1, 2);
		for (int i = 0; i < image.length; i++) {
			System.out.println(Arrays.toString(image[i]));
		}

	}

	public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {

		checkNeighboringPixel(image, sr, sc, newColor, image[sr][sc]);
		return image;

	}

	public static int[][] checkNeighboringPixel(int[][] image, int i, int j, int newColor, int srcColor) {

		if (i < 0 || i >= image.length || j < 0 || j >= image[i].length || image[i][j] == newColor
				|| image[i][j] != srcColor) {
			return image;
		}
		if (image[i][j] == srcColor) {
			image[i][j] = newColor;
		}
		checkNeighboringPixel(image, i, j - 1, newColor, srcColor);
		checkNeighboringPixel(image, i, j + 1, newColor, srcColor);
		checkNeighboringPixel(image, i - 1, j, newColor, srcColor);
		checkNeighboringPixel(image, i + 1, j, newColor, srcColor);
		return image;
	}

}
