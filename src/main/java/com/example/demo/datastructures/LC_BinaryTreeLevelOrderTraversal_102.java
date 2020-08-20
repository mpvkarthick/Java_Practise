
package com.example.demo.datastructures;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

import com.example.demo.model.TreeNode;

/**
 * @author Karthik Mannepalli
 * @ProblemStatement :
 *                   https://leetcode.com/problems/binary-tree-level-order-traversal/
 * @Level : Medium
 */
public class LC_BinaryTreeLevelOrderTraversal_102 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TreeNode node15 = new TreeNode(15);
		TreeNode node7 = new TreeNode(7);
		TreeNode node20 = new TreeNode(20, node15, node7);
		TreeNode node9 = new TreeNode(9);
		TreeNode root = new TreeNode(3, node9, node20);
		System.out.println("Without Recursion");
		System.out.println(levelOrder(root));
		System.out.println("With Recursion");
		System.out.println(levelOrderUsingRecursion(root));

	}

	public static List<List<Integer>> levelOrder(TreeNode root) {

		if (null == root) {
			return new ArrayList<List<Integer>>();
		}
		Queue<TreeNode> queue = new LinkedBlockingDeque<TreeNode>();
		queue.add(root);

		List<List<Integer>> levels = new ArrayList<List<Integer>>();
		while (!queue.isEmpty()) {
			int size = queue.size();
			int index = 0;
			List<Integer> level = new ArrayList<Integer>();
			while (index < size) {

				TreeNode node = queue.poll();
				level.add(node.val);
				if (null != node.left)
					queue.add(node.left);
				if (null != node.right)
					queue.add(node.right);
				index++;
			}
			levels.add(level);
		}

		return levels;
	}

	public static List<List<Integer>> levelOrderUsingRecursion(TreeNode root) {

		if (null == root) {
			return new ArrayList<List<Integer>>();
		}
		Queue<TreeNode> queue = new LinkedBlockingDeque<TreeNode>();
		queue.add(root);

		return returnList(new ArrayList<List<Integer>>(), queue);
	}

	public static List<List<Integer>> returnList(List<List<Integer>> levels, Queue<TreeNode> queue) {

		if (queue.isEmpty()) {
			return levels;
		}
		List<Integer> level = new ArrayList<Integer>();

		Queue<TreeNode> temp = new LinkedBlockingDeque<TreeNode>();
		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			level.add(node.val);
			if (null != node.left)
				temp.add(node.left);
			if (null != node.right)
				temp.add(node.right);
		}
		levels.add(level);

		return returnList(levels, temp);

	}

}
