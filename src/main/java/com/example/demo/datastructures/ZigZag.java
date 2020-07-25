package com.example.demo.datastructures;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;

public class ZigZag {

	public static void main(String[] args) {
		ZigZag zigZag = new ZigZag();
		
//		TreeNode l7 = zigZag.new TreeNode(11);
//		TreeNode l6 = zigZag.new TreeNode(34);
//		TreeNode l4 = zigZag.new TreeNode(40,l6,null);
//		TreeNode l5 = zigZag.new TreeNode(25,l7,null);
//		TreeNode l2 = zigZag.new TreeNode(1);
//		TreeNode l3 = zigZag.new TreeNode(33,l5,l4);
//		TreeNode l1 = zigZag.new TreeNode(2, l2, l3);
		TreeNode l5 = zigZag.new TreeNode(5);
		TreeNode l4 = zigZag.new TreeNode(4);
		TreeNode l2 = zigZag.new TreeNode(2,l4,null);
		TreeNode l3 = zigZag.new TreeNode(3,null,l5);
		TreeNode l1 = zigZag.new TreeNode(1, l2, l3);
		
		
		List<List<Integer>> masterList = zigZag.zigzagLevelOrder(l1);
		for (int i = 0; i < masterList.size(); i++) {
			System.out.println(masterList.get(i));
		}

	}

	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

		if (root == null) {
		      return new ArrayList<List<Integer>>();
		    }
		
		Deque<TreeNode> nextLevelQueue = new LinkedBlockingDeque<ZigZag.TreeNode>();
		nextLevelQueue.add(root);
		
		return generateBreadthList(nextLevelQueue, true, new ArrayList<List<Integer>>());
	}

	public List<List<Integer>> generateBreadthList(Deque<TreeNode> nodeQueue, boolean isEvenLevel,
			List<List<Integer>> masterList) {

		Deque<TreeNode> nextLevelQueue = new LinkedBlockingDeque<ZigZag.TreeNode>();
		TreeNode node;
		LinkedList<Integer> levelList = new LinkedList<>();
		if (nodeQueue.isEmpty()) {
			return masterList;
		}
		while (!nodeQueue.isEmpty()) {

			node =  nodeQueue.poll();
			
			if (null != node.left) {
				nextLevelQueue.add(node.left);
			}
			if (null != node.right) {
				nextLevelQueue.add(node.right);
				
			}
			if(isEvenLevel)
				levelList.add(node.val);
            else
            	levelList.addFirst(node.val);
		}
		masterList.add(levelList);
		masterList = generateBreadthList(nextLevelQueue, !isEvenLevel, masterList);

		return masterList;
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
