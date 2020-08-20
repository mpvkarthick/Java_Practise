
package com.example.demo.datastructures;

/**
 * @author Karthik Mannepalli
 * @ProblemStatement :
 *                   https://www.hackerrank.com/contests/hack-the-interview-iv/challenges/good-binary-string
 * @Level : Medium
 */
public class HR_ValidBinaryString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(minimumMoves("101", 2));
		System.out.println(returnMoves("101", 2));
	}

	/**
	 * This method is timing out for a huge input. Any fix is appreciated
	 * @param s
	 * @param d
	 * @return
	 */
	public static int minimumMoves(String s, int d) {

		// initialize n to 0
		int n = 0;
		if(s.indexOf("1") == -1) {
			return s.length()/d;
		}
		
		for (int i = 0; i + d <= s.length();) {
				if (s.substring(i, i + d).indexOf("1") != -1) {
					i++;
					continue;
				} else {
					i += d;
					n++;
				}
		}
		return n;
	}
	
	public static int returnMoves(String s, int d) {
		 int numOfOnes =0;
	        int numberOfOnesRequired = 0;
	        int checkIndex =0;
	        for(int i =0;i<s.length(); ){
	        	checkIndex++;
	            if(s.charAt(i) == '1'){
	                 numOfOnes++;
	            }
	            if(checkIndex == d){
	                if(numOfOnes == 0){
	                	numberOfOnesRequired++;
	                	numOfOnes = 1;
	                }
	                else {
	                      numOfOnes =0;
	                }
	                checkIndex = 0;
	            }else {
	            	i++;
	            }
	        }
	        return numberOfOnesRequired;

	}

}
