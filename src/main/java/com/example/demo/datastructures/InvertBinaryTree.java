package com.example.demo.datastructures;

public class InvertBinaryTree {

	public static void main(String[] args) {
		InvertBinaryTree goodNodes = new InvertBinaryTree();

		TreeNode n3 = goodNodes.new TreeNode(3);
		TreeNode n1 = goodNodes.new TreeNode(1);
		
		TreeNode n6 = goodNodes.new TreeNode(6);
		TreeNode n9 = goodNodes.new TreeNode(9);
		TreeNode n2 = goodNodes.new TreeNode(2,n1,n3);
		TreeNode n7 = goodNodes.new TreeNode(7,n6,n9);
		TreeNode n4 = goodNodes.new TreeNode(4, n2, n7);
		
		TreeNode n5 = invertTree(n4);
		
		System.out.println(n5);
		

	}

	public static TreeNode invertTree(TreeNode root) {

		// if the root node is null, then return null
		if(root == null) {
			return null;
		}
		// recursively do a DFS on the right node
		TreeNode rightNode = invertTree(root.right);
		TreeNode leftNode = invertTree(root.left);
		root.left = rightNode;
		root.right = leftNode;
		
		return root;
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