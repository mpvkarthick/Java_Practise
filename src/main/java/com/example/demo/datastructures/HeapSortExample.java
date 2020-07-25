package com.example.demo.datastructures;

import java.util.HashMap;
import java.util.Map;

import com.example.demo.model.TreeNode;

public class HeapSortExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] heap = { 10, 4, 5, 2, 8, 4, 6, 1, 3, 2, 7, 9 };

		TreeNode rootNode = createBinaryHeap(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11,12,13,14,15 });
		//System.out.println(rootNode);
		System.out.println(Math.log(16));
		sortAndUpdatetoMinHeap(heap);

	}
	public static void sortAndUpdatetoMinHeap(int[] heap) {
		
		int rootNodesStartIndex = (heap.length - 1)/2;
		
	}

	public static TreeNode createBinaryHeap(int heap[]) {
		int nodeIndex = 0;
		Map<Integer, TreeNode> nodeMap = new HashMap<>();
		TreeNode node;
		TreeNode leftnode;
		TreeNode rightNode;
		while (nodeIndex < heap.length) {
			// create current node
			if (!nodeMap.containsKey(nodeIndex)) {
				node = new TreeNode(heap[nodeIndex]);
				nodeMap.put(nodeIndex, node);
			} else {
				node = nodeMap.get(nodeIndex);
			}

			// create left node
			int leftNodeIndex = (2 * nodeIndex) + 1;
			if (leftNodeIndex < heap.length) {
				if (!nodeMap.containsKey(leftNodeIndex)) {
					leftnode = new TreeNode(heap[leftNodeIndex]);
					nodeMap.put(leftNodeIndex, leftnode);
				} else {
					leftnode = nodeMap.get(leftNodeIndex);
				}
				node.left = leftnode;
			}

			// create right node
			int rightNodeIndex = (2 * nodeIndex) + 2;
			if (rightNodeIndex < heap.length) {
				if (!nodeMap.containsKey(rightNodeIndex)) {
					rightNode = new TreeNode(heap[rightNodeIndex]);
					nodeMap.put(rightNodeIndex, rightNode);
				} else {
					rightNode = nodeMap.get(rightNodeIndex);
				}
				node.right = rightNode;

			}
			nodeIndex++;
		}

		return nodeMap.get(0);
	}

	

}
