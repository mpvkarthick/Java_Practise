package com.example.demo.model;

import java.util.HashMap;

public class Node {
	char c;
    HashMap<Character, Node> children = new HashMap<Character, Node>();
    int end;
    public Node(char c){
        this.c = c;
    }
	/**
	 * @return the c
	 */
	public char getC() {
		return c;
	}
	/**
	 * @param c the c to set
	 */
	public void setC(char c) {
		this.c = c;
	}
	/**
	 * @return the children
	 */
	public HashMap<Character, Node> getChildren() {
		return children;
	}
	/**
	 * @param children the children to set
	 */
	public void setChildren(HashMap<Character, Node> children) {
		this.children = children;
	}
	/**
	 * @return the end
	 */
	public int getEnd() {
		return end;
	}
	/**
	 * @param end the end to set
	 */
	public void setEnd(int end) {
		this.end = end;
	}
    
    
}
