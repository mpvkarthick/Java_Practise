package com.example.demo.model;

public class QueueNode {

	public int val;
	public QueueNode next;

	public QueueNode() {
	}

	public QueueNode(int _val) {
		val = _val;
	}

	public QueueNode(int _val, QueueNode _next) {
		val = _val;
		next = _next;
	}
}
