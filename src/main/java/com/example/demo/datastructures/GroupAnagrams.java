package com.example.demo.datastructures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class GroupAnagrams {

	public static void main(String[] args) {

		// Creating array and Storing the array
		// returned by toCharArray()
		List<List<String>> items = groupAnagrams(new String[] {"eat", "tea", "tan", "ate", "nat", "bat"});
		for(List<String> item:items) {
			System.out.println(String.valueOf(item));
		}

	}

	public static List<List<String>> groupAnagrams(String[] strs) {

		Map<String, List<String>> grpAnagram = new HashMap<>();

		char[] ch;
		List<String> valueList;
		String key;
		for (String s : strs) {
			ch = s.toCharArray();
			Arrays.sort(ch);
			key = String.valueOf(ch);
			if (grpAnagram.containsKey(String.valueOf(key))) {
				valueList = grpAnagram.get(key);
				valueList.add(s);
			} else {
				valueList = new ArrayList<String>();
				valueList.add(s);
				grpAnagram.put(key, valueList);
			}
		}

		return new ArrayList<>(grpAnagram.values());
	}

}
