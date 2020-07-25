package com.example.demo.datastructures;

import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class DijkstraDirectedWeighted {

	public static void main(String[] args) {

		int[][] edges = { { 1, 2, 2 }, { 1, 3, 4 }, { 2, 3, 1 }, { 2, 4, 7 }, { 3, 5, 3 }, { 4, 6, 1 }, { 5, 4, 2 },
				{ 5, 6, 5 } };
		int nodes = 6;
		int[] shortestPath = new int[nodes];
		shortestPath = returnShortestPath(edges, nodes, 1);
		System.out.println(Arrays.toString(shortestPath));
	}

	/**
	 * @param edges
	 * @param nodes
	 * @param source
	 * @return
	 */
	public static int[] returnShortestPath(int[][] edges, int nodes, int source) {

		int[] shortestPath = new int[nodes];
		int[] workingPath = new int[nodes];
		int dU=0;
		int cUV=0;
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
		updateAdjacencyMatrix(edges, nodes,adjacencyMatrix);

		// Step 3 - 
		// Depending on the source node, choose the row in adjacencyMatrix and initalize it
		// as the shortestPath
		shortestPath = adjacencyMatrix[source];
		
		// Step 4 - Apply Djikstra Algorithm
		Queue<int[]> pq;
		for(int row = source+1;row<nodes;row++) {
			pq=fetchSortedQueue(shortestPath,relaxedNodeSet);
			workingPath = adjacencyMatrix[pq.peek()[0]];
			relaxedNodeSet.add(pq.peek()[0]);
			for(int index = source+1;index<workingPath.length;index++) {
					dU = workingPath[index];
					if(dU != Integer.MAX_VALUE) {
						cUV = shortestPath[pq.peek()[0]];
						if(dU+cUV<shortestPath[index]) {
							shortestPath[index] = dU+cUV;
						}
					}
			}
			//System.out.println(Arrays.toString(shortestPath));
		}
		return shortestPath;
	}

	/**
	 * @param edges
	 * @param nodes
	 * @return
	 */
	public static int[][] updateAdjacencyMatrix(int[][] edges, int nodes,int[][] adjacencyMatrix) {
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
	public static Queue<int[]> fetchSortedQueue(int[] workingPath, Set<Integer> relaxedNodeSet){
		Queue<int[]> pq = new PriorityQueue<>((a,b) -> a[1]-b[1]);
		for(int index=0;index<workingPath.length;index++) {
			if(workingPath[index] != Integer.MAX_VALUE && !relaxedNodeSet.contains(index)) {
				pq.offer(new int[] {index,workingPath[index]});
			}
		}
		return pq;
	}

}
