package com.example.demo.datastructures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LadderLength {

	public static void main(String[] args) {

		List<String> dictionary = new ArrayList<String>();
		dictionary.add("hot");
		dictionary.add("dot");
		dictionary.add("dog");
		dictionary.add("lot");
		dictionary.add("log");
		dictionary.add("cog");
		//dictionary.add("dot");
		System.out.println(ladderLength("hit", "cog", dictionary));

	}

	public static int ladderLength(String beginWord, String endWord, List<String> wordList) {

        if(!wordList.contains(endWord)) {
			return 0;
		}
//        if(wordList.contains(beginWord)) {
//			wordList.remove(wordList.indexOf(beginWord));
//		}
		int index = 0;
		int ladderLength = 0;
		char[] bwArray = beginWord.toCharArray();
		for(String word:wordList) {
//            if (word.equalsIgnoreCase(beginWord)) {
//				continue;
//			}
			for(char c:bwArray) {
				if(word.replace(word.charAt(index), c).equalsIgnoreCase(beginWord)) {
					beginWord = word;
					bwArray= beginWord.toCharArray();
					ladderLength++;
					break;
				}
				index++;
				if(beginWord == endWord) {
					break;
				}
			}
			index=0;
		}
		return ladderLength;
	}

}
