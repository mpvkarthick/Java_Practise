package com.example.demo.datastructures;

public class SymmetricTree {

	public boolean isValidBST(TreeNode root) {

		return isValidBST(root,Integer.MAX_VALUE,Integer.MIN_VALUE);
	}

	public boolean isValidBST(TreeNode root, int upperBound, int lowerBound) {

		if (root.left.val > root.val || root.left.val < lowerBound) {
			return false;
		}

		if (root.right.val < root.val || root.right.val > lowerBound) {
			return false;
		}

		return isValidBST(root.left, root.left.val, Integer.MIN_VALUE)
				&& isValidBST(root.right, Integer.MAX_VALUE, root.right.val);

	}

	public boolean isSymmetric(TreeNode root) {

		if (null == root) {
			return true;
		}
		if (null == root.left || null == root.right) {
			return false;
		}
		String leftNode = getTreeString(root.left, true);
		String rightNode = getTreeString(root.right, false);
		return leftNode.equalsIgnoreCase(rightNode);
	}

	public String getTreeString(TreeNode t, boolean isLeft) {

		if (t == null) {
			return "";
		}
		if (isLeft) {
			return t.val + "|" + "|" + getTreeString(t.left, isLeft) + "|" + getTreeString(t.right, isLeft) + "|";
		} else {
			return t.val + "|" + "|" + getTreeString(t.right, isLeft) + "|" + getTreeString(t.left, isLeft) + "|";
		}

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
