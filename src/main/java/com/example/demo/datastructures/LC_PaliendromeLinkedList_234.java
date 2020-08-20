/**
 * @author Karthik Mannepalli
 * Problem Statement : 
 * Level : 
 */
package com.example.demo.datastructures;

/**
 * @author Karthik Mannepalli
 * @ProblemStatement : https://leetcode.com/problems/palindrome-linked-list/
 * @Level : Easy
 */
public class LC_PaliendromeLinkedList_234 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ListNode node5 = new ListNode(1);
		ListNode node4 = new ListNode(3, node5);
		ListNode node3 = new ListNode(2, node4);
		ListNode node2 = new ListNode(4, node3);
		ListNode node1 = new ListNode(3, node2);
		ListNode node0 = new ListNode(2, node1);
		ListNode head = new ListNode(1, node0);
		System.out.println(isPalindrome(head));
		
		

	}

	public static boolean isPalindrome(ListNode head) {

		if(null == head || null == head.next) {
			return true;
		}
		ListNode ptr1 = head, ptr2 = head;
		while(null != ptr1 && null != ptr2 && null != ptr1.next && null != ptr2.next) {
			
			ptr1 = ptr1.next;
			ptr2 = ptr2.next.next;
		}
		ptr1 = null == ptr2?ptr1:ptr1.next;
		ptr2=head;
		ptr1 = reverseListRecursive(ptr1);
		while(null != ptr1) {
			if(ptr1.val != ptr2.val) {
				return false;
			}
			ptr1 = ptr1.next;
			ptr2 = ptr2.next;
		}
		return true;
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
