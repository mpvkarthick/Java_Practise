package com.example.demo.datastructures;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Karthik Mannepalli 
 * @ProblemStatement : https://leetcode.com/problems/long-pressed-name/	
 * @Level : Easy 
 */
public class LC_LongPressedLetter {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isLongPressedName("alex", "alexxr"));
	}

	public static boolean isLongPressedName(String name, String typed) {

		boolean isLongPressed = false;
		Map<Integer, Character[]> charMap = new HashMap<>();
		int charIndex = 1;
		int charCount = 1;
		for (int index = 0; index < name.length(); index++) {
			if (index + 1 < name.length() && name.charAt(index) != name.charAt(index + 1)) {
				charMap.put(charIndex, new Character[] { name.charAt(index), (char) (charCount+'0') });
				charIndex++;
				charCount=1;
			}
			else if(index+1 == name.length()) {
				charMap.put(charIndex, new Character[] { name.charAt(index), (char) (charCount+'0') });
			}
			else {
				charCount++;
			}
			
		}
		int charTypeIndex = 1; 
		
		charCount=1;
		for (int index = 0; index < typed.length(); index++) {
			if ((index+1 == typed.length()) || (index + 1 < typed.length() && typed.charAt(index) != typed.charAt(index + 1))) {
				if (null != charMap.get(charTypeIndex) && charMap.get(charTypeIndex)[0] == typed.charAt(index) && charCount >= Character.getNumericValue(charMap.get(charTypeIndex)[1])) {
					isLongPressed = true;
					charTypeIndex++;
					charCount = 1;
				} else {
					return false;
				}

			} 
			else {
				charCount++;
			}
			
		}

        if(charIndex != charTypeIndex-1) isLongPressed = false;
		return isLongPressed;
	
	
	}
}
