package com.example.demo.datastructures;

public class Add2NumbersLinkedList {

	public static void main(String[] args) {
		Add2NumbersLinkedList a = new Add2NumbersLinkedList();

		ListNode n10 = a.new ListNode(9);
		ListNode n9 = a.new ListNode(9);
		ListNode n8 = a.new ListNode(9);
		ListNode n7 = a.new ListNode(9);
		ListNode n6 = a.new ListNode(9);
		ListNode n5 = a.new ListNode(9);
		ListNode n4 = a.new ListNode(9);
		ListNode n3 = a.new ListNode(9);
		ListNode n2 = a.new ListNode(9);
		ListNode n1 = a.new ListNode(1);
		
		ListNode n0 = a.new ListNode(9);

		
		
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n7;
		n7.next = n8;
		n8.next = n9;
		n9.next = n10;

		ListNode n11 = a.addTwoNumbers(n0, n1);
		while (null != n11) {
			System.out.println("Val =="+ n11.val);
			System.out.println("Next " + (null == n11.next ? null : n11.next.val));
			n11 = n11.next;
		}
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

		long sum1 = (null == l1 ? 0 : (fetchLNum(l1, 0)));
		long sum2 = (null == l2 ? 0 : (fetchLNum(l2, 0)));
		long sum = sum1 + sum2;
		if (0 == sum) {
			return new ListNode(0);
		}
		return getFinalNode(sum);
	}

	public ListNode getFinalNode(long sum) {
		
		long val = sum % 10;
		ListNode listNode = new ListNode((int)val);
		if (sum / 10 ==0) {
			return listNode;
		}
		listNode.next = getFinalNode(sum / 10);
		return listNode;
	}

	public long fetchLNum(ListNode l, long m) {

		if (l.next == null) {
			return (long) (l.val * Math.pow(10, m));
		}
		double sum = (l.val * Math.pow(10, m));
		return (long) (fetchLNum(l.next, ++m) + sum);

	}

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}
}
