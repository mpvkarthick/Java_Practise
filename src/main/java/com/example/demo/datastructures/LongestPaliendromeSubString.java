package com.example.demo.datastructures;

import java.util.HashSet;
import java.util.Set;

public class LongestPaliendromeSubString {

	public static void main(String[] args) {

		long startTime = System.nanoTime();
		 System.out.println("Longest "+longestPalindrome("abbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbba"));
		System.out.println(longestPalindrome(
				"lcnvoknqgejxbfhijmxglisfzjwbtvhodwummdqeggzfczmetrdnoetmcydwddmtubcqmdjwnpzdqcdhplxtezctvgnpobnnscrmeqkwgiedhzsvskrxwfyklynkplbgefjbyhlgmkkfpwngdkvwmbdskvagkcfsidrdgwgmnqjtdbtltzwxaokrvbxqqqhljszmefsyewwggylpugmdmemvcnlugipqdjnriythsanfdxpvbatsnatmlusspqizgknabhnqayeuzflkuysqyhfxojhfponsndytvjpbzlbfzjhmwoxcbwvhnvnzwmkhjxvuszgtqhctbqsxnasnhrusodeqmzrlcsrafghbqjpyklaaqximcjmpsxpzbyxqvpexytrhwhmrkuybtvqhwxdqhsnbecpfiudaqpzsvfaywvkhargputojdxonvlprzwvrjlmvqmrlftzbytqdusgeupuofhgonqoyffhmartpcbgybshllnjaapaixdbbljvjomdrrgfeqhwffcknmcqbhvulwiwmsxntropqzefwboozphjectnudtvzzlcmeruszqxvjgikcpfclnrayokxsqxpicfkvaerljmxchwcmxhtbwitsexfqowsflgzzeynuzhtzdaixhjtnielbablmckqzcccalpuyahwowqpcskjencokprybrpmpdnswslpunohafvminfolekdleusuaeiatdqsoatputmymqvxjqpikumgmxaxidlrlfmrhpkzmnxjtvdnopcgsiedvtfkltvplfcfflmwyqffktsmpezbxlnjegdlrcubwqvhxdammpkwkycrqtegepyxtohspeasrdtinjhbesilsvffnzznltsspjwuogdyzvanalohmzrywdwqqcukjceothydlgtocukc"));
		long endTime = System.nanoTime();
		System.out.println("Time Elapsed " + (endTime - startTime) / 1000000);

//		String a= "abcd";
//		System.out.println(a.substring(1,a.length()-1));
//		System.out.println(a.charAt(0));
//		System.out.println(a.charAt(a.length()-1));
		// System.out.println("Longest "+longestPalindrome("ab"));
	}

	public static String longestPalindrome(String s) {

		String subString;
		if (s.length() == 1) {
			return s;
		}
		if (s.equals("")) {
			return "";
		}
		String longestPaliendrome = s.substring(0, 1);
		Set<String> pStrings = new HashSet<String>();

		String middleString = "";
		// this loop is to get the length of substring for Paliendrome check
		for (int length = 2; length <= s.length(); length++) {

			// this loop is to
			// 1. iterate over every character, form a 2,3,...n letter word - Let us call it
			// substring
			// 2. check if the substring is a paliendrome
			// 3. if yes, then check if the paliendrome is longer than the string
			// "longestPaliendrome"
			// 4. if Yes, replace the longestPaliendrome with the substring and continue to
			// next step. If no, then continue with loop.
			// 5. then check if the characters at the index substring[0]-1 and
			// substring[length]+1 are same
			// 6. If yes, replace the longestPaliendrome with the substring and continue to
			// next step.
			for (int index = 0; index < s.length() - length + 1; index++) {
				subString = s.substring(index, index + length);
				if (subString.length() > longestPaliendrome.length()) {
					if (subString.length() > 2) {
						middleString = subString.substring(1, subString.length() - 1);
					} else {
						middleString = subString;
					}
					if (subString.charAt(0) == subString.charAt(subString.length() - 1)
							&& (pStrings.contains(middleString) || isPaliendrome(middleString, pStrings))) {

						if (subString.length() > longestPaliendrome.length()) {
							longestPaliendrome = subString;
						}
						pStrings.add(subString);

					}

				}
			}
		}
		return longestPaliendrome;
	}

	public static boolean isPaliendrome(String s, Set<String> pStrings) {

		if ((new StringBuilder(s).reverse()).toString().equals(s)) {
			pStrings.add(s);
			return true;
		}
		return false;
	}
}
