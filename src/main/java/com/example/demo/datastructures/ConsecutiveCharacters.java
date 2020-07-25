package com.example.demo.datastructures;

import java.util.HashSet;
import java.util.Set;

public class ConsecutiveCharacters {

	public static void main(String[] args) {
		System.out.println(answer("a b b bb"));
	}

	
	static int answer (String s) {
		if(s.length() ==0) {
			return 0;
		}
		if(s.length() ==1) {
			return 1;
		}
	        int n = s.length();
	        Set<Character> set = new HashSet<>();
	        int ans = 0, l = 1, r = 1;
	        set.add(s.charAt(0));
	        while (r<n && l<n) {
	        	
	        	if(set.contains(s.charAt(l))) {
	        		r++;
	        		ans = Math.max(ans, r);
	        	} else {
	        		set = new HashSet<>();
	        		set.add(s.charAt(l));
	        		r=1;
	        		ans = Math.max(ans, r);
	        	}
	        	l++;
	        }
	        return ans;
	}
}
