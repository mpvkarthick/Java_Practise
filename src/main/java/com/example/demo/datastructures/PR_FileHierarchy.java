
package com.example.demo.datastructures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * @author Karthik Mannepalli
 * @ProblemStatement : Given a text file with lines in the format: parent 1 child1...childN
 * 					   print out the indented representation of 
 * 					   the parent-child hierarchy in a tree like view.
 * Level : Medium
 */
public class PR_FileHierarchy {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<String> inputs = new ArrayList<String>();
		inputs.add("animal vertebrates invertebrates");
		inputs.add("vertebrates mammals fish reptiles");
		inputs.add("invertebrates spider butterfly");
		inputs.add("mammals whale human");
		inputs.add("Extinct Dino Mammoth");
		printHierarchy(inputs);
	}
	
	public static void printHierarchy(List<String> inputs) {
		
		Map<String, String> pcMap =  new HashMap<String, String>();
		List<String> subfolders = new ArrayList<String>();
		for(String input:inputs) { // o(n)
			String []folders = input.split(" ");
			String key = folders[0];
			StringBuffer sb = new StringBuffer();
			for(int index = 1;index<folders.length;index++) { // o(k)
				if(index == folders.length-1) {
					sb.append(folders[index]);
				} else {
					sb.append(folders[index]).append(",");
				}
				subfolders.add(folders[index]);
			}
			pcMap.put(key, sb.toString());
		}
		//o(n*k)
		List<String> rootFolders =  new ArrayList<String>();
		Set<Map.Entry<String, String>> entryset = pcMap.entrySet();
		for(Entry<String, String> entry:entryset) {
			if(!subfolders.contains(entry.getKey())) {
				rootFolders.add(entry.getKey());
			}
		}
		
		for(String rootFolder:rootFolders) {
			System.out.println(rootFolder);
			printPath(pcMap, rootFolder, 1);
		}
		
	}
	
	public static String printPath(Map<String, String> inputMap, String key, int level) {
		
		
		if(null == inputMap.get(key)) {
			return key;
		}
		String[] subFolders = inputMap.get(key).split(",");
		for(String subFolder:subFolders) {
			for(int i=1;i<=level*2;i++) {
				System.out.print(" ");
			}
			System.out.println(subFolder);
			printPath(inputMap, subFolder, level+1);
		}
		
		return null;
	}

}
