package com.example.demo.datastructures;

public class SubTreeProblem {

	public static void main(String[] args) {

		SubTreeProblem problem = new SubTreeProblem();

//		TreeNode s1 = problem.new TreeNode(2);
//		TreeNode s2 = problem.new TreeNode(3);

//		TreeNode s4 = problem.new TreeNode(1, s1, s2);
		//TreeNode s5 = problem.new TreeNode(5);

		//TreeNode s3 = problem.new TreeNode(3, s4, s5);
		
		
		TreeNode t1 = problem.new TreeNode(12);
		TreeNode t2 = problem.new TreeNode(2);
		
		TreeNode t4 = problem.new TreeNode(4, t1, t2);
		
		System.out.println(problem.isSubtree(t4));
	}

	public boolean isSubtree(TreeNode root) {

		String sString = getTreeString(root.left,true);
		String tString = getTreeString(root.right,false);
		return sString.equals(tString);
	}
	
	public String getTreeString(TreeNode t, boolean isleft) {
		
		if(t ==null) {
			if(isleft) {
				return "leftleafnode";
			} else {
				return "rightleafnode";
			}
			
		}
		return "|"+t.val +getTreeString(t.left,true)+getTreeString(t.right,false);
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
