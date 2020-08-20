
package com.example.demo.datastructures;

import com.example.demo.model.TreeNode;

/**
 * @author Karthik Mannepalli
 * @ProblemStatement :
 *                   https://leetcode.com/problems/maximum-depth-of-binary-tree/
 * @Level : Easy
 */
public class LC_MaxDepth_104 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TreeNode node15 = new TreeNode(15);
		TreeNode node7 = new TreeNode(7);
		TreeNode node20 = new TreeNode(20, node15, node7);
		TreeNode node9 = new TreeNode(9);
		TreeNode root = new TreeNode(3, node9, node20);
		System.out.println(maxDepth(root));
		System.out.println(minDepth(root));

	}

	public static int maxDepth(TreeNode root) {

		if (root == null) {
			return 0;
		}
		int left = maxDepth(root.left) + 1;
		int right = maxDepth(root.right) + 1;
		return Math.max(left, right);

	}

	public static int minDepth(TreeNode root) {

		if (root == null) {
			return 0;
		}
		int left = minDepth(root.left) + 1;
		int right = minDepth(root.right) + 1;
		if (left == 1) {
			return right;
		} else if (right == 1) {
			return left;
		}
		return Math.min(left, right);

	}

}
