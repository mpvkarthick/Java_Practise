package com.example.demo.datastructures;


public class LinkedListHelloWorld {

	public static void main(String[] args) {

		LinkedListHelloWorld helloWorld = new LinkedListHelloWorld();
		ListNode l3 =  helloWorld.new ListNode(4,null);
		ListNode l2=  helloWorld.new ListNode(2,l3);
		ListNode l1 = helloWorld.new ListNode(1, l2);
		
		ListNode l6 =  helloWorld.new ListNode(6,null);
		ListNode l5=  helloWorld.new ListNode(5,l6);
		ListNode l4 = helloWorld.new ListNode(3, l5);
		
		helloWorld.mergeTwoLists(l1, l4);
		
		
		
	}

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

		if(null == l1) {
			return l2;
		}
		if(null == l2) {
			return l1;
		}
		
		ListNode listNode = null;
		if(l1.val < l2.val) {
			listNode = l1;
			listNode.next = mergeTwoLists(l1.next,l2);
		} else {
			listNode = l2;
			listNode.next = mergeTwoLists(l1, l2.next);
		}
		
		return listNode;
	}

	public class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

	
}

