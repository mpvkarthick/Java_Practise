package com.example.demo.datastructures;

public class GoodNodes {

	public static void main(String[] args) {
		GoodNodes goodNodes = new GoodNodes();

		TreeNode n1 = goodNodes.new TreeNode(1);
		TreeNode n2 = goodNodes.new TreeNode(5);
		TreeNode n3 = goodNodes.new TreeNode(4, n1, n2);
		TreeNode n4 = goodNodes.new TreeNode(3);
		TreeNode n5 = goodNodes.new TreeNode(1, n4, null);
		TreeNode node = goodNodes.new TreeNode(3, n5, n3);

//		TreeNode n3 = goodNodes.new TreeNode(2);
//		TreeNode n2 = goodNodes.new TreeNode(4);
//		TreeNode n1 = goodNodes.new TreeNode(3, n2, n3);
//		TreeNode node = goodNodes.new TreeNode(3, n1, null);
//		
//		TreeNode n1 = goodNodes.new TreeNode(4);
//		TreeNode n2 = goodNodes.new TreeNode(10);
//		TreeNode n3 = goodNodes.new TreeNode(8,n1,null);
//		TreeNode n4 = goodNodes.new TreeNode(4,n2,n3);
//		TreeNode node = goodNodes.new TreeNode(2, null, n4);

		System.out.println(goodNodes.goodNodesCount(node));

	}

	public int goodNodesCount(TreeNode root) {

		return goodNodesCountWithRoot(root, root, 1);
	}

	public int goodNodesCountWithRoot(TreeNode node, TreeNode root, int count) {

		if (null == node.left && null == node.right) {
			return count;
		}
		if (null != node.left) {

			if (node.left.val >= node.val && node.left.val >= root.val) {
				count++;
			}
			count = goodNodesCountWithRoot(node.left, root, count);
		}
		if (null != node.right) {
			if (node.right.val >= node.val && node.right.val >= root.val) {
				count++;
			}
			count = goodNodesCountWithRoot(node.right, root, count);
		}
		return count;
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
