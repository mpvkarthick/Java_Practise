package com.example.demo.datastructures;

import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class CheapestFlights {

	public static void main(String[] args) {

//		int[][] edges = { { 1, 2, 2 }, { 1, 3, 4 }, { 2, 3, 1 }, { 2, 4, 7 }, { 3, 5, 3 }, { 4, 6, 1 }, { 5, 4, 2 },
//				{ 5, 6, 5 } };
		//int[][] edges = {{4,1,1},{1,2,3},{0,3,2},{0,4,10},{3,1,1},{1,4,3}};
//		int[][] edges = {{3,4,4},{2,5,6},{4,7,10},{9,6,5},{7,4,4},{6,2,10},
//				{6,8,6},{7,9,4},{1,5,4},{1,0,4},{9,7,3},{7,0,5},{6,5,8},{1,7,6},
//				{4,0,9},{5,9,1},{8,7,3},{1,2,6},{4,1,5},{5,2,4},{1,9,1},{7,8,10},
//				{0,4,2},{7,2,8}};
		int[][] edges= {{0,1,1},{0,2,5},{1,2,1},{2,3,1}};
		System.out.println(returnShortestPath(4, edges, 0, 3, 1));
	}

	/**
	 * @param edges
	 * @param nodes
	 * @param source
	 * @return
	 */
	public static int returnShortestPath(int nodes, int[][] edges, int source, int dst, int k) {

		int[] shortestPath = new int[nodes];
		int[] workingPath = new int[nodes];
		int dU = 0;
		int cUV = 0;
		Set<Integer> relaxedNodeSet = new HashSet<Integer>();
		// Step 1 - Create a adjacencyMatrix with length equal to number of nodes + 1
		// and initialize it to max
		int[][] adjacencyMatrix = new int[nodes + 1][nodes + 1];
		for (int row = 0; row < adjacencyMatrix.length; row++) {
			for (int col = 0; col < adjacencyMatrix[0].length; col++) {
				adjacencyMatrix[row][col] = Integer.MAX_VALUE;
			}
		}
		// Step 2 - fill the adjacencyMatrix with data
		updateAdjacencyMatrix(edges, nodes, adjacencyMatrix);

		// Step 3 -
		// Depending on the source node, choose the row in adjacencyMatrix and initalize
		// it
		// as the shortestPath
		shortestPath = adjacencyMatrix[source];

		if (k == 0) {
			if(shortestPath[dst] != Integer.MAX_VALUE) {
				return shortestPath[dst];
			} else {
				return -1;
			}
		}

		// Step 4 - Apply Djikstra Algorithm
		Queue<int[]> pq;
		for (int row = source+1; row < nodes && k>0; row++) {
			pq = fetchSortedQueue(shortestPath, relaxedNodeSet);
			if(!pq.isEmpty()) {
				workingPath = adjacencyMatrix[pq.peek()[0]];
				relaxedNodeSet.add(pq.peek()[0]);
				for (int index = 0; index < workingPath.length; index++) {
					dU = workingPath[index];
					if (dU != Integer.MAX_VALUE) {
						cUV = shortestPath[pq.peek()[0]];
						if (dU + cUV < shortestPath[index]) {
							shortestPath[index] = dU + cUV;
							if(index == dst) {
								k--;
							}
						}
					}
				}
				System.out.println(Arrays.toString(shortestPath));
			}
		}
		return shortestPath[dst] != Integer.MAX_VALUE?shortestPath[dst]:-1;
	}

	/**
	 * @param edges
	 * @param nodes
	 * @return
	 */
	public static int[][] updateAdjacencyMatrix(int[][] edges, int nodes, int[][] adjacencyMatrix) {
		int[] edgeInfo;
		for (int row = 0; row < edges.length; row++) {
			edgeInfo = edges[row];
			adjacencyMatrix[edgeInfo[0]][edgeInfo[1]] = edgeInfo[2];
		}

		return adjacencyMatrix;
	}

	/**
	 * @param workingPath
	 * @return
	 */
	public static Queue<int[]> fetchSortedQueue(int[] workingPath, Set<Integer> relaxedNodeSet) {
		Queue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
		for (int index = 0; index < workingPath.length; index++) {
			if (workingPath[index] != Integer.MAX_VALUE && !relaxedNodeSet.contains(index)) {
				pq.offer(new int[] { index, workingPath[index] });
			}
		}
		return pq;
	}

}
