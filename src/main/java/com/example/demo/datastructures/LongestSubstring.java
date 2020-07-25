package com.example.demo.datastructures;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstring {
	public static void main(String[] args) {
		System.out.println(answer("dvdfe"));
	}

	
	static int answer (String s) {
	        int n = s.length();
	        Set<Character> set = new HashSet<>();
	        int ans = 0, l = 0, r = 0;
	        while (l<n && r<n) {
	        	
	        	if(!set.contains(s.charAt(r))) {
	        		set.add(s.charAt(r));
	        		r++;
	        		ans = Math.max(ans, r-l);
	        	} else {
	        		set.remove(s.charAt(l));
	        		l++;
	        	}
	        }
	        return ans;
	}
}
