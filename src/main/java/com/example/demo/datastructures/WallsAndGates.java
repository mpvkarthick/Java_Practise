package com.example.demo.datastructures;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class WallsAndGates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] rooms = new int[][] {{2147483647,-1,0,2147483647},
			   {2147483647,2147483647,2147483647,-1},
			   {2147483647,-1,2147483647,-1},
			   {0,-1,2147483647,2147483647}
				};
		
		wallsAndGates(rooms);
		for(int[] room:rooms) {
			System.out.println(Arrays.toString(room));
		}
		//System.out.println(Arrays.toString(rooms));
		

	}

	public static void wallsAndGates(int[][] rooms) {

		// Initialzing a queue
		Queue<int[]> nodeQueue = new LinkedList<int[]>();
		// initializing directions list to traverse from a single position in matrix
		List<int[]> directions = Arrays.asList(new int[] { 0, -1 }, new int[] { 0, 1 }, new int[] { -1, 0 },
				new int[] { 1, 0 }
		
		);
		int rowLength = rooms.length;
		int colLength = rooms[0].length;
		
		// iterate the matrix and add all the positions that have the value as gate i.e 0
		for (int row = 0; row < rooms.length; row++) {
			for (int column = 0; column < rooms[0].length; column++) {
				if (rooms[row][column] == 0) {
					nodeQueue.add(new int[] { row, column });
				}
			}
		}
		int[] position;
		int row, column;
		//Iterate through the node queue, poll the element and check in all directions if the value is not infinity
		// if not infinity in the direction being checked add +1 from the previous location
		while (!nodeQueue.isEmpty()) {
			position = nodeQueue.poll();
			for (int[] direction : directions) {
				row = position[0] + direction[0];
				column = position[1] + direction[1];

				if (row < 0 || column < 0 || row >= rowLength || column >= colLength
						|| rooms[row][column] != Integer.MAX_VALUE) {
					continue;
				}
				rooms[row][column] = rooms[position[0]][position[1]]+1;
				nodeQueue.add(new int[] { row, column });
			}
		}
	}

//	public int findShortestRouteToGate(int[][] rooms, int row, 
//			int column, int route, Map<String, Integer> infShortestDistanceMap) {
//
//		int shortestRoute= 0;
//		int temproute = 0;
//		if (rooms[row][column] == -1) {
//			return -1;
//		}
//		if (rooms[row][column] == 0) {
//			return ++route;
//		}
//		if (rooms[row][column] == Integer.MAX_VALUE) {
//			route++;
//			temproute = route;
//			temproute = findShortestRouteToGate(rooms, row, column+1, temproute,infShortestDistanceMap);
//			if(temproute != -1) {
//				shortestRoute = infShortestDistanceMap.getOrDefault(row+"-"+column, Integer.MAX_VALUE);
//				if(temproute < shortestRoute) {
//					infShortestDistanceMap.put(row+"-"+column, temproute);
//					rooms[row][column] = temproute;
//				}
//			}
//			
//			
//			
//			
//		}
//
//		return 0;
//	}
}
