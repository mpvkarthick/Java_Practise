
package com.example.demo.datastructures;

import com.example.demo.model.TreeNode;

/**
 * @author Karthik Mannepalli
 * @ProblemStatement : https://leetcode.com/problems/longest-univalue-path/
 * @Level : Easy
 */
public class LC_LongestUniValuePath_687 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		TreeNode rNode1 = new TreeNode(1);
		TreeNode rNode2 = new TreeNode(1);
		TreeNode rNode3 = new TreeNode(5);
		TreeNode node4 = new TreeNode(4, rNode1, rNode2);
		TreeNode node5 = new TreeNode(5, null, rNode3);
		TreeNode root = new TreeNode(5, node4, node5);
		//System.out.println(longestUnivaluePath(root));
		System.out.println(2<<1);

	}

	public static int longestUnivaluePath(TreeNode root) {

		return longestUnivaluePath(root, 0, 0);
	}

	public static int longestUnivaluePath(TreeNode root, int count, int maxCount) {

		if (null == root.left && null == root.right) {

			return count;
		}
		if (null != root.left) {

			if (root.left.val == root.val) {
				count++;
				maxCount = Math.max(count, maxCount);
				maxCount = longestUnivaluePath(root.left, count, maxCount);
			} else {
				maxCount = longestUnivaluePath(root.right, 0, 0);
			}
		}
		if (null != root.right) {

			if (root.right.val == root.val) {
				count++;
				maxCount = Math.max(count, maxCount);
				maxCount = longestUnivaluePath(root.right, count, maxCount);
			} else {
				maxCount = longestUnivaluePath(root.right, 0, 0);
			}
		}
		return maxCount;
	}

}
