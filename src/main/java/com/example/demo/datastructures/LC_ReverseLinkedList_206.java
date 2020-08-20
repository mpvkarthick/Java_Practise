
package com.example.demo.datastructures;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Karthik Mannepalli
 * @ProblemStatement : https://leetcode.com/problems/reverse-linked-list/
 * @Level : Easy
 */
public class LC_ReverseLinkedList_206 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ListNode node5 = new ListNode(5);
		ListNode node4 = new ListNode(4, node5);
		ListNode node3 = new ListNode(3, node4);
		ListNode node2 = new ListNode(2, node3);
		ListNode head = new ListNode(1, node2);
		head = reverseListRecursive(head);

		System.out.println(head);
	}

	public static ListNode reverseListNotintiuttive(ListNode head) {

		if (null == head) {
			return null;
		}
		List<ListNode> nodes = new ArrayList<ListNode>();
		nodes.add(head);

		while (null != head && null != head.next) {
			nodes.add(head.next);
			head = head.next;
		}

		Collections.reverse(nodes);
		for (int index = 0; index < nodes.size() - 1; index++) {

			nodes.get(index).next = nodes.get(index + 1);
		}
		nodes.get(nodes.size() - 1).next = null;
		return nodes.get(0);
	}

	public static ListNode reverseListRecursive(ListNode head) {

		if (null == head || null == head.next) {
			return head;
		}

		ListNode curr = reverseListRecursive(head.next);
		head.next.next = head;
		head.next = null;

		return curr;
	}

}
