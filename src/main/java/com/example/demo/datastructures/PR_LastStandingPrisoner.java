/**
 * @author Karthik Mannepalli
 * Problem Statement : 
 * Level : 
 */
package com.example.demo.datastructures;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

import com.example.demo.model.Node;
import com.example.demo.model.QueueNode;
import com.example.demo.model.TreeNode;

/**
 * @author cpsdadmin
 *
 */
public class PR_LastStandingPrisoner {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(findLastPrisoner(new int[] { 1, 2, 3, 4, 5 }, 2));
		

	}

	public static int findLastPrisoner(int [] prisoners, int k) {
		
		if(prisoners==null || prisoners.length == 0){
			return 0;
		}
		if(k==1) {
			return prisoners[prisoners.length-1];
		}
		
		// assign 0th element as head Node
		// create a circular linked list starting head
		// assign the linked list last elements next to head
		
		// now start iterating from head, and keep assigning next of
		// each node skipping k nodes (if you are crossing head, 
		// update the head to next node) until you end up with 
		// only head and tail. 
		QueueNode head =  new QueueNode(prisoners[0]);
		QueueNode curr = head;
		for(int i=1;i<prisoners.length;i++) {
			
			QueueNode node = new QueueNode(prisoners[i]);
			curr.next = node;
			curr = node;
		}
		
		curr.next = head;
		
		// iterate through the list removing the nodes until we reach 
		// head and tail
		curr = head;
		while(head.next.next != head) {
			int count = 1;
			while(count<k-1) {
				curr = curr.next;
				count++;
			}
			if(curr.next == head) {
				head = curr.next.next;
			}
			curr.next = curr.next.next;
			curr = curr.next;
		}
		
		//System.out.println(head);
		
		
		return head.val;
	}

}
