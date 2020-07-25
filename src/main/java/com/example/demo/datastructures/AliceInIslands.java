package com.example.demo.datastructures;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class AliceInIslands {

	static BufferedReader br;

	public static void main(String[] args) {
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			BufferedOutputStream bos = new BufferedOutputStream(System.out);
			String eol = System.getProperty("line.separator");
			byte [] eolb = eol.getBytes();	
			String str = br.readLine();
			int t = Integer.parseInt(str);
			for (int i = 0; i < t; i++) {
				str = br.readLine();
				int n = Integer.parseInt(str);
				int[] ar = new int[n];
				readArray(ar);
				String result = String.valueOf(returnIslandNumber(ar));
				bos.write(result.getBytes());
				bos.write(eolb);
				//System.out.println(returnIslandNumber(ar));
			}
			bos.flush();
		} catch (IOException e) {

		} finally {
			try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}


	}

	public static int returnIslandNumber(int[] islandCount) {

		Set<Integer> visitedIndexSet = new HashSet<>();
		String longestJourney = "";
		String currentJourney = "";
		int islandNumber = 0;
		for (int i = 0; i < islandCount.length; i++) {
			visitedIndexSet = new HashSet<Integer>();
			currentJourney = recursiveIslandSearch(i, islandCount, visitedIndexSet);
			if (currentJourney.length() > longestJourney.length()) {
				longestJourney = currentJourney;
				islandNumber = i;
			}
		}

		return islandNumber;
	}

	public static String recursiveIslandSearch(int islandIndex, int[] islands, Set<Integer> visitedIndexSet) {

		visitedIndexSet.add(islandIndex);
		String islandString = String.valueOf(islandIndex);
		int destinyIsland = islands[islandIndex];
		if (visitedIndexSet.contains(destinyIsland)) {

			return islandString;
		}
		visitedIndexSet.add(destinyIsland);
		islandString = islandString + "|" + recursiveIslandSearch(destinyIsland, islands, visitedIndexSet);
		return islandString;
	}

	public static void readArray(int[] ar) throws IOException {
		int j = 0;
		int s = 0;
		int k = 0;
		String str = br.readLine();
		int length = str.length();
		while (j < length) {
			while (j < length) {
				if (str.charAt(j) == ' ') {
					break;
				} else {
					j++;
				}
			}
			ar[k] = Integer.parseInt(str.substring(s, j));
			k++;
			j++;
			s = j;
		}
	}
}
