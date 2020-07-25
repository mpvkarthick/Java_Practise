package com.example.demo.datastructures;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BoundaryOfBinaryTree {

	public static void main(String[] args) {
		BoundaryOfBinaryTree goodNodes = new BoundaryOfBinaryTree();

		TreeNode n7 = goodNodes.new TreeNode(7);
		TreeNode n8 = goodNodes.new TreeNode(8);
		TreeNode n4 = goodNodes.new TreeNode(4);
		TreeNode n5 = goodNodes.new TreeNode(5, n7, n8);
		TreeNode n2 = goodNodes.new TreeNode(2, n4, n5);
		TreeNode n9 = goodNodes.new TreeNode(9);
		TreeNode n10 = goodNodes.new TreeNode(10);
		TreeNode n6 = goodNodes.new TreeNode(6, n9, n10);
		TreeNode n3 = goodNodes.new TreeNode(3, n6, null);
		TreeNode n1 = goodNodes.new TreeNode(1, n2, n3);
		System.out.println(boundaryOfBinaryTree(n1).toString());

		n4 = goodNodes.new TreeNode(4);
		n3 = goodNodes.new TreeNode(3);
		n2 = goodNodes.new TreeNode(2, n3, n4);
		n1 = goodNodes.new TreeNode(1, null, n2);
		System.out.println(boundaryOfBinaryTree(n1).toString());

	}
	
	public static boolean isLeafNode(TreeNode root) {
		if(root.left == null && root.right ==null) {
			return true;
		}
		return false;
	}

	public static List<Integer> boundaryOfBinaryTree(TreeNode root) {

		List<Integer> boundaryList = new ArrayList<Integer>();
		
		boundaryList.add(root.val);
		if(isLeafNode(root)) {
			return boundaryList;
		} 
		
		//iterate left nodes
		TreeNode t = root.left;
		while(null != t) {
			if(!isLeafNode(t)) {
				boundaryList.add(t.val);
			}
			if(null != t.left) {
				t= t.left;
			} else {
				t=t.right;
			}
		}
		leafNodes(root, boundaryList);
		List<Integer> rightBoundaryList =  new  ArrayList<Integer>();
		t = root.right;
		while(null != t) {
			if(!isLeafNode(t)) {
				rightBoundaryList.add(t.val);
			}
			if(null != t.right) {
				t= t.right;
			} else  {
				t=t.left;
			}
		}
		Collections.reverse(rightBoundaryList);
		boundaryList.addAll(rightBoundaryList);
		
		return boundaryList;
	}
	
	public static List<Integer> leafNodes(TreeNode root, List<Integer> boundaryList) {

		if (root.left == null && null == root.right) {
			boundaryList.add(root.val);
			return boundaryList;
		}

		if (null != root.left) {
			leafNodes(root.left, boundaryList);
		}
		if (null != root.right) {
			leafNodes(root.right, boundaryList);
		}
		return boundaryList;
	}

	public static List<Integer> leftBoundaryOfBinaryTree(TreeNode root, List<Integer> boundaryList) {

		if (null == root.left && null == root.right) {
			return boundaryList;
		}

		if (null != root.left) {
			if (null == root.left.left && null == root.left.right) {
				return boundaryList;
			}
			boundaryList.add(root.left.val);
			boundaryList = leftBoundaryOfBinaryTree(root.left, boundaryList);
		} else {
			if (null == root.right.left && null == root.right.right) {
				return boundaryList;
			}
			boundaryList.add(root.right.val);
			boundaryList = leftBoundaryOfBinaryTree(root.right, boundaryList);
		}

		return boundaryList;
	}

	public static List<Integer> rightBoundaryOfBinaryTree(TreeNode root, List<Integer> boundaryList) {

		if (null == root.left && null == root.right) {
			return boundaryList;
		}

		if (null != root.right) {
			if (null == root.right.left && null == root.right.right) {
				return boundaryList;
			}
			boundaryList.add(root.right.val);
			boundaryList = leftBoundaryOfBinaryTree(root.right, boundaryList);
		} else {
			if (null == root.left.left && null == root.left.right) {
				return boundaryList;
			}
			boundaryList.add(root.left.val);
			boundaryList = leftBoundaryOfBinaryTree(root.left, boundaryList);
		}
		Collections.reverse(boundaryList);
		return boundaryList;
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
