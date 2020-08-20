/**
 * @author Karthik Mannepalli
 * Problem Statement : 
 * Level : 
 */
package com.example.demo.datastructures;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Karthik Mannepalli
 * @ProblemStatement :
 *                   https://leetcode.com/problems/flower-planting-with-no-adjacent/
 * @Level : Easy
 */
public class LC_FloweringPlant_1042 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int[] gardenNoAdj(int N, int[][] paths) {

		Map<Integer, HashSet<Integer>> adjMatrix =  new HashMap<>();
		HashSet<Integer> pathSet =  new HashSet<>();
		for(int row=0;row<paths.length;row++) {
			pathSet = adjMatrix.getOrDefault(paths[row][0],new HashSet<>());
			pathSet.add(paths[row][1]);
		}
		String pathString;
		Set<Integer> visitedGardens =  new HashSet<>();
		
		
		return null;
	}

	private static void generateUniqueSet(Map<Integer, HashSet<Integer>> adjMatrix, Set<Integer> visitedGardens) {
		HashSet<Integer> pathSet;
		for(Map.Entry<Integer, HashSet<Integer>> entry:adjMatrix.entrySet()) {
			
			visitedGardens.add(entry.getKey());
			pathSet = entry.getValue();
			for(int path:pathSet) {
				if(!visitedGardens.contains(path)) {
				}
			}
			
		}
	}

}
