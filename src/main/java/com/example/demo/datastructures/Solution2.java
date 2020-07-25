package com.example.demo.datastructures;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<String> reorderLines(int logFileSize, List<String> logLines) {
		String numberIndex = "0123456789";
		// traverse through the array
		// add the digital in a set to maintain order
		// add let1 to another set
		// sort the letter set
		// add all the logs back to logs array
		List<String> digitSet = new ArrayList<>();
		List<String> letSet = new ArrayList<>();
		for (int i = 0; i < logFileSize; i++) {
			if (numberIndex.indexOf((logLines.get(i).split(" "))[1].charAt(0)) != -1) {
				digitSet.add(logLines.get(i));
			} else
				letSet.add(logLines.get(i));
		}

		Collections.sort(letSet, (o1, o2) -> {

			String s1 = o1.substring(o1.indexOf(" ") + 1, o1.length());
			String s2 = o2.substring(o2.indexOf(" ") + 1, o2.length());
			if (s1.compareTo(s2) == 0) {
				return (o1.split(" "))[0].compareTo((o2.split(" "))[0]);
			}
			return (s1.compareTo(s2));
		});
		letSet.addAll(digitSet);
		// logs = letSet.toArray(new String[letSet.size()]);
		return letSet;

	}
}
