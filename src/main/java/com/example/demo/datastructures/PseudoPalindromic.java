package com.example.demo.datastructures;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class PseudoPalindromic {

	public static void main(String[] args) {
		PseudoPalindromic goodNodes = new PseudoPalindromic();

		TreeNode n6 = goodNodes.new TreeNode(1);
		TreeNode n5 = goodNodes.new TreeNode(1);
		TreeNode n4 = goodNodes.new TreeNode(3);
		TreeNode n3 = goodNodes.new TreeNode(1, null, n6);
		TreeNode n2 = goodNodes.new TreeNode(3, n4, n5);
		TreeNode n1 = goodNodes.new TreeNode(2, n2, n3);

		System.out.println(pseudoPalindromicPaths(n1));
	}

	public static int pseudoPalindromicPaths(TreeNode root) {

		if (null == root) {
			return 0;
		}
		return palindromicPathCount(root, new int[100000],0);
	}

	public static int palindromicPathCount(TreeNode root, int path[], int pathLen) {

		int palindromeCount = 0;
		if (null == root) {
			return palindromeCount;
		}
		
		path[pathLen] = root.val; 
        pathLen++; 
		
		if (null == root.left && null == root.right) {
			// iterate through the array
			// take the numbers that are even and numbers that are odd
			Map<Integer, Integer> numMap =  new HashMap<Integer, Integer>();
			int evenNumCount = 0, oddNumCount = 0;
			int numCount = 0;
			 for (int i = 0; i < pathLen; i++)   {
				
				numCount = numMap.getOrDefault(path[i], 0);
				++numCount;
				numMap.put(path[i], numCount);
				if(numCount % 2 == 0) {
					// even counts increases
					evenNumCount++;
					if(numCount != 1 && oddNumCount!=0) {
						oddNumCount--;
					}
				} else {
					//odd count increases
					oddNumCount++;
					if(numCount != 1 && evenNumCount!=0) {
						evenNumCount--;
					}
				}
			}
			 if((pathLen %2 !=0 && oddNumCount == 1) || (pathLen %2 ==0 && oddNumCount ==0)) {
				 ++palindromeCount;
			 }
			System.out.println("Even Num Count = "+evenNumCount+", Odd Num Count = "+oddNumCount);
		}
		else {
			
			palindromeCount += palindromicPathCount(root.left,path,pathLen);
			palindromeCount += palindromicPathCount(root.right,path,pathLen);
		}
		

		return palindromeCount;
	}

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}
}
