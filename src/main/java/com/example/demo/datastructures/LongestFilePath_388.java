/**
 * @author Karthik Mannepalli 
 * Problem Statement : 
 * Level : 
 */
package com.example.demo.datastructures;

/**
 * @author Karthik Mannepalli 
 * @Problem-Statement : https://leetcode.com/problems/longest-absolute-file-path/
 * @Level : Medium 
 *
 */
public class LongestFilePath_388 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LongestFilePath_388 l = new LongestFilePath_388();
		l.lengthLongestPath("hello");

	}
	
	 /**
	 * @param input
	 * @return
	 */
	public int lengthLongestPath(String input) {
	        input = "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext";
	        String newInput = input.replace("\n\t", "|").replace("\t", "-");
	        System.out.println(newInput);
	        
	        return 5;
	    }

}
