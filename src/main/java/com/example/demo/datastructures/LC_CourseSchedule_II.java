
package com.example.demo.datastructures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author Karthik Mannepalli Problem Statement : Level :
 */
public class LC_CourseSchedule_II {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println(Arrays.toString(findOrder(2, new int[][] { })));

	}

	public static int[] findOrder(int numCourses, int[][] prerequisites) {

		int index=-1;
		if(null == prerequisites || prerequisites.length ==0) {
			int[] orderedCourses = new int[numCourses];
            for(int i=numCourses-1;i>0;i--){
                orderedCourses[++index] = i;
            }
            
            return orderedCourses;
		}
		Map<Integer, List<Integer>> dMap = new HashMap<>();
		List<Integer> courses =  new ArrayList<Integer>();
		// create adjacency matrix
		List<Integer> vertices;
		for (int[] preReq : prerequisites) {

			vertices = dMap.getOrDefault(preReq[0], new ArrayList<>());
			vertices.add(preReq[1]);
			dMap.put(preReq[0], vertices);

		}

		// iterate through the matrix, using DFS and create a new array

		for (int course = 0; course < numCourses; course++) {

			if (dMap.containsKey(course)) {
				courses = findDependencies(dMap, new HashSet<>(), course, new ArrayList<>());
				if(courses.size() == numCourses) {
					break;
				}
			}
		}

		int[] orderedCourses = new int[numCourses];
		 index=-1;
		for(int course:courses) {
			orderedCourses[++index] = course;
		}
		return orderedCourses;
	}

	public static List<Integer> findDependencies(Map<Integer, List<Integer>> dMap, Set<Integer> visitedNodes,
			int course, List<Integer> courses) {

		// base condition
		if(visitedNodes.contains(course)) {
			return courses;
		} 
		visitedNodes.add(course);
		if(!dMap.containsKey(course)) {
			courses.add(course);
			return courses;
		}
		
		// iterate through the vertices and generate an array of courses
		for (int vertex : dMap.get(course)) {
			courses = findDependencies(dMap, visitedNodes, vertex, courses);
		}
		courses.add(course);

		return courses;

	}

}
