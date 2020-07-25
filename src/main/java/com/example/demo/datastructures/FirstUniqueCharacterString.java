package com.example.demo.datastructures;

import java.util.HashSet;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.LinkedBlockingDeque;

public class FirstUniqueCharacterString {

	public static void main(String[] args) {
		System.out.println(firstUniqChar("aadadaad"));
	}
	
	 public static int firstUniqChar(String s) {
	        
	        if(null ==s || s.length() == 0){
	            return -1;
	        }
	        Set<Character> removedCharacters = new HashSet<Character>();
	        Queue<Character> cQueue =  new LinkedBlockingDeque<Character>();
			for(int index=0;index<s.length();index++) {
				if(cQueue.contains(s.charAt(index))) {
					removedCharacters.add(s.charAt(index));
					char c= s.charAt(index);
					cQueue.removeIf(d -> d==c);
				} else {
					if(!removedCharacters.contains(s.charAt(index)))
					cQueue.add(s.charAt(index));
				}
			}
	        
			if(cQueue.isEmpty()) {
				return -1;
			}
	        return s.indexOf(cQueue.peek());
	    }
}
