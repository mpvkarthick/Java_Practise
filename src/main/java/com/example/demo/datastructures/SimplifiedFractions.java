package com.example.demo.datastructures;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SimplifiedFractions {

	public static void main(String[] args) {
		
		List<String> fractionsList = simplifiedFractions(2);
		for(String s:fractionsList) {
			System.out.println(s);
		}
	}
	
	 public static List<String> simplifiedFractions(int n) {
	        
		 List<String> fractionsList =  new ArrayList<String>();
		 Set<Double> fractions = new HashSet<Double>();
		 for(int i=1;i<=n;i++) {
			 for(int j=i+1;j<=n;j++) {
//				 System.out.println(Double.valueOf(i)/Double.valueOf(j));
				 if(!fractions.contains(Double.valueOf(i)/Double.valueOf(j))) {
					fractionsList.add(String.valueOf(i)+"/"+String.valueOf(j)); 
					fractions.add(Double.valueOf(i)/Double.valueOf(j));
				 }
			 }
		 }
		 
		 return fractionsList;
	    }
}
