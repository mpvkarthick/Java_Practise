package com.example.demo.datastructures;

import java.util.LinkedList;

public class RemoveKDigits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		System.out.println(removeKdigits("1432219", 3));
//		System.out.println(removeKdigits("10200", 1));
//		System.out.println(removeKdigits("10", 2));
//		System.out.println(removeKdigits("10", 1));
//		System.out.println(removeKdigits("100", 1));
//		System.out.println(removeKdigits("1111111", 3));
		System.out.println(removeKdigits("1234567890", 9));
	}

	public static String removeKdigits(String num, int k) {

		if(k == 0) {
			return num;
		}
		char[] numArray = num.toCharArray();
		int index1 = 0, index2 = 0;
		char numArrayC = '0';
		char[] newNumArray = new char[num.length() - k];
		while (index1 < num.length() && index2 < newNumArray.length) {

			if (index1 == 0) {
				numArrayC = numArray[index1];
				index1++;
				continue;
			}
			if (numArray[index1] < numArrayC && k > 0) {
				numArrayC = numArray[index1];
                k--;
			} else {
				 newNumArray[index2] = numArrayC;
                 numArrayC = numArray[index1];
                 index2++;
			}
			index1++;
			if(k == 0) {
				for(int i=index1-1;i<num.length();i++) {
					newNumArray[index2] = numArray[i];
					index2++;
				}
			}
			
		}

		if (String.valueOf(newNumArray).equalsIgnoreCase("")) {
			return "0";
		}
		//return String.valueOf(newNumArray);
		return Integer.valueOf(String.valueOf(newNumArray)).toString();
	}
}
