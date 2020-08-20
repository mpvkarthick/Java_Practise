
package com.example.demo.datastructures;

import java.util.LinkedList;
import java.util.Queue;

import com.example.demo.model.TreeNode;

/**
 * @author Karthik Mannepalli
 * @ProblemStatement :
 *                   https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree/
 * @Level : Medium
 */
public class LC_MaxLevelSumBinaryTree_1161 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//TreeNode nodec11 =  new TreeNode(8);
		//TreeNode nodec12 =  new TreeNode(7);
		
		TreeNode nodec111 = new TreeNode(-63491);
		TreeNode nodec11 =  new TreeNode(57785,null,nodec111);
		TreeNode nodec1 =  new TreeNode(98129,null,nodec11);
		TreeNode n3 = new TreeNode(-63367);
		TreeNode n2 = new TreeNode(-75141,n3,null);
		TreeNode n1 = new TreeNode(-26118,n2,null);
		TreeNode nodec2 =  new TreeNode(62101,null,n1);
		TreeNode nodec3 =  new TreeNode(84856,nodec1,null);
		TreeNode nodec4 =  new TreeNode(-34332,nodec2,nodec3);
		TreeNode head = new TreeNode(39608,null,nodec4);
		
		System.out.println(maxLevelSum(head));

	}

	public static int maxLevelSum(TreeNode root) {

		// initialize maxsum to 0
		// assign root value to max sum
		// take root node and sum its left and right node value
		// if the sum > maxSum, assign max sum = sum
		// check if the left node and right node have children
		// if they have children, repeat the above steps recursively until we hit
		// leaf nodes
		// BFS with recursion

		int maxSum = root.val;
		int level = 1;

		if (null == root.left && null == root.right) {
			return level;
		} else {
			Queue<TreeNode> nodeQueue = new  LinkedList<TreeNode>();
			if(null != root.left)
			nodeQueue.add(root.left);
			if(null != root.right)
			nodeQueue.add(root.right);
			return findMaxLevel(nodeQueue, maxSum,level,level);
		}

	}

	public static int findMaxLevel(Queue<TreeNode> nodeQueue, int maxSum,int level,int maxLevel) {

		if(nodeQueue.isEmpty()) {
			return maxLevel;
		}
		Queue<TreeNode> tempQueue = new  LinkedList<TreeNode>();
		int sum = 0;
		TreeNode node;
		level++;
		while (!nodeQueue.isEmpty()) {
			node = nodeQueue.poll();
			sum += node.val;
			if (null != node.left && !isLeafNode(node)) {
				tempQueue.add(node.left);
			}
			if (null != node.right && !isLeafNode(node)) {
				tempQueue.add(node.right);
			}
		}
		if(sum > maxSum) {
			maxLevel = level;
		} 
		maxSum = Math.max(sum, maxSum);
		maxLevel = findMaxLevel(tempQueue, maxSum,level,maxLevel);
		
		return maxLevel;

	}

	public static boolean isLeafNode(TreeNode node) {
		if (null == node.left && null == node.right) {
			return true;
		}
		return false;
	}

}
