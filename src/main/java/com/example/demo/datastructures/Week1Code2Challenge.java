package com.example.demo.datastructures;

public class Week1Code2Challenge {

	public static void main(String[] args) {

		String J="aA",S = "aAAbbbb";
		System.out.println(numJewelsInStones(J,S));
		
	}

	public static int numJewelsInStones(String J, String S) {

		char[] sArray = S.toCharArray();
		int jewelCount = 0;
		for(int i=0;i<sArray.length;i++) {
			if(J.indexOf(sArray[i]) != -1) {
				++jewelCount;
			}
		}
		
		return jewelCount;
	}
}
