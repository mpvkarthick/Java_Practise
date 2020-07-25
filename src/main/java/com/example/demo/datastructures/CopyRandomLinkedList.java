package com.example.demo.datastructures;

import java.util.HashMap;
import java.util.Map;

public class CopyRandomLinkedList {

	public static void main(String[] args) {

		CopyRandomLinkedList helloWorld = new CopyRandomLinkedList();

		Node n4 =  helloWorld.new Node(1);
		Node n3 = helloWorld.new Node(10);
		Node n2 = helloWorld.new Node(11);
		Node n1 = helloWorld.new Node(13);
		Node n0 = helloWorld.new Node(7);
		
		n0.random = null;
		n0.next = n1;
		
		n1.random = n0;
		n1.next = n2;
		
		n2.random=n4;
		n2.next = n3;
		
		n3.random = n2;
		n3.next = n4;
		
		n4.random = n0;
		n4.next = null;
		
		helloWorld.copyRandomList(null);

	}

	public Node copyRandomList(Node headNode) {

		 if(null == headNode) {
			 return null;
		 }
		Node newHeadNode = createNextNode(headNode, new HashMap<Node, Node>(),new HashMap<Node, Node>());
		while(null != newHeadNode) {
			System.out.println(newHeadNode.val);
			System.out.println("Next "+ (null == newHeadNode.next? null:newHeadNode.next.val));
			System.out.println("Random "+ (null == newHeadNode.random ? null :newHeadNode.random.val));
			newHeadNode = newHeadNode.next;
		}
		return newHeadNode;
	}
	
	public Node createNextNode(Node headNode, Map<Node, Node> oldvsNewMap, Map<Node, Node> oldRandomCombMap) {
		
		
		Node newNode = new Node(headNode.val);
		//newNode.val = headNode.val;
		oldvsNewMap.put(headNode, newNode);
		oldRandomCombMap.put(headNode,headNode.random);
		if (headNode.next == null) {
			newNode.random = oldvsNewMap.get(oldRandomCombMap.get(headNode));
			return newNode;
		}
		newNode.next=createNextNode(headNode.next, oldvsNewMap,oldRandomCombMap);
		
		newNode.random = oldvsNewMap.get(oldRandomCombMap.get(headNode));
		
		return newNode;
	}

	public class Node {
		int val;
		Node next;
		Node random;

		Node() {
		}

		Node(int val) {
			this.val = val;
			this.next = null;
			this.random = null;
		}

		Node(int val, Node next) {
			this.val = val;
			this.next = next;
		}
	}

}
