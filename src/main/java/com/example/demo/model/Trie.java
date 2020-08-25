package com.example.demo.model;

public class Trie {
	/**
	 * @return the root
	 */
	public Node getRoot() {
		return root;
	}

	/**
	 * @param root the root to set
	 */
	public void setRoot(Node root) {
		this.root = root;
	}

	/**
	 * @return the words
	 */
	public String[] getWords() {
		return words;
	}

	/**
	 * @param words the words to set
	 */
	public void setWords(String[] words) {
		this.words = words;
	}

	Node root;
	String[] words;

	public Trie() {
		root = new Node('0');
	}

	public void insert(String word, int index) {
		Node cur = root;
		for (char c : word.toCharArray()) {
			cur.children.putIfAbsent(c, new Node(c));
			cur = cur.children.get(c);
		}
		cur.end = index;
	}

}
