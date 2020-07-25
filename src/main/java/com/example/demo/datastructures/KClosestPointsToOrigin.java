package com.example.demo.datastructures;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KClosestPointsToOrigin {

	public static void main(String[] args) {
		int[][] points = { { 3, 3 }, { 5, -1 }, { -2, 4 } };
		points = kClosest(points, 2);
		for (int[] point : points) {
			System.out.println(Arrays.toString(point));
		}

	}

	public static int[][] kClosest(int[][] points, int K) {

		PriorityQueue<int[]> pointQueue = new PriorityQueue<>(
				(a, b) -> (b[0] * b[0] + b[1] * b[1]) - (a[0] * a[0] + a[1] * a[1]));

		for (int[] point : points) {

			pointQueue.offer(point);
			if (pointQueue.size() > K) {
				pointQueue.poll();
			}
		}

		points = new int[K][];
		for(int pointsIndex=0;pointsIndex<K;pointsIndex++) {
			points[pointsIndex] = pointQueue.poll();
		}
		return points;
	}
}
