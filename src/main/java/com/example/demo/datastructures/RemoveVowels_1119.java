package com.example.demo.datastructures;

/**
 * @author Karthik Mannepalli 
 * @Problem-Statement Given a string S, remove the
 *         vowels 'a', 'e', 'i', 'o', and 'u' from it, and return the new
 *         string. 
 *  @Level Easy
 */
public class RemoveVowels_1119 {

	public static void main(String[] args) {
		RemoveVowels_1119 r =  new RemoveVowels_1119();
		System.out.println(r.removeVowels("aeiou"));

	}

	/**
	 * Time Complexity - O(n) - Since CharAt() is always O(1)
	 * Space Complexity - O(n+m) where m is the size of 
	 * String Buffer without vowels
	 * @param S
	 * @return
	 */
	public String removeVowels(String S) {

		String vowel = "aeiou";
		StringBuffer sb =  new StringBuffer();
		Character c;
		for(int i=0;i<S.length();i++) {
			c=S.charAt(i);
			if(vowel.indexOf(c) == -1) {
				sb.append(c);
			}
		}
		
		return sb.toString();
	}

}
