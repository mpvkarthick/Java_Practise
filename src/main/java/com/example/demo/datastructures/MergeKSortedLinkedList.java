package com.example.demo.datastructures;

public class MergeKSortedLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode node3 = new ListNode(5);
		ListNode node2 = new ListNode(4,node3);
		ListNode node1 = new ListNode(1,node2);
		
		ListNode node6 = new ListNode(4);
		ListNode node5 = new ListNode(3,node6);
		ListNode node4 = new ListNode(1,node5);
		
		ListNode node8 = new ListNode(8);
		ListNode node7 = new ListNode(2,node8);
		
		ListNode node9 = mergeKLists(new ListNode[] {node1,node4,node7});
		System.out.println(node9);

	}

	public static ListNode mergeKLists(ListNode[] lists) {

		ListNode node3 = null;
		if(lists.length == 1) {
			return lists[0];
		}
		if(lists.length == 0) {
			return null;
		}
		node3 = mergeNodes(lists[0], lists[1]);
		
		for (int i = 2; i < lists.length; i++) {
			node3 = mergeNodes(node3, lists[i]);
		}

		return node3;
	}

	public static ListNode mergeNodes(ListNode node1, ListNode node2) {

		if (null == node1) {
			return node2;
		}
		if (null == node2) {
			return node1;
		}
		ListNode node = new ListNode(0);
		ListNode nodeLatest =node;
		while(null != node1 && null != node2) {
			
			if (node1.val <= node2.val) {
				node.next = node1;
				node=node.next;
				node1 =node1.next;

			} else {
				node.next = node2;
				node=node.next;
				node2 =node2.next;
			}
		}
		if (null == node1) {
			node.next= node2;
		}
		if (null == node2) {
			node.next= node1;
		}
//		if (node1.val <= node2.val) {
//			node = new ListNode(node1.val);
//			// node.next = node2;
//			node.next = mergeNodes(node1.next, node2);
//
//		} else {
//			node = new ListNode(node2.val);
//			node.next = mergeNodes(node1, node2.next);
//		}

		return node.next;
	}

}
