package com.example.demo.datastructures;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class Solution1 {

	public static void main(String[] args) {
		List<String> comp = new ArrayList<String>();
		comp.add("newshop");
		comp.add("shopnow");
		comp.add("afshion");
		comp.add("fashionbeats");
		comp.add("mymarket");
		comp.add("tcellular");
		
		List<String> reviews = new ArrayList<String>();
		reviews.add("mymarket beats fashionbeats,");
		reviews.add("fashionbeats providing");
		reviews.add("proud to be providing fashionbeats");
		reviews.add("mymarket beats fashionbeats,");
		reviews.add("proud to be providing Newshop ");
		System.out.println(topNCompetitors(Integer.MAX_VALUE, 1, comp, 6, reviews));

	}
	
	// METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    public static ArrayList<String> topNCompetitors(int numCompetitors, 
	                                         int topNCompetitors, 
                                             List<String> competitors, 
											 int numReviews, 
											 List<String> reviews)
    {
    	 List<String> res = new ArrayList<>();
     	if(numCompetitors <0 || topNCompetitors <0) {
     		return new ArrayList<>(res);
     	}
     	
         HashMap<String,Integer> map = new HashMap<>() ;
         
         for( String words : reviews){

             Set<String> added = new HashSet<String>() ;

             for(String str :words.replaceAll("[^a-zA-Z0-9] ", "").split("\\s+")){

                 str = str.toLowerCase() ;
                 if(competitors.contains(str) && !added.contains(str) && !str.equalsIgnoreCase("Amazon")){

                     map.put(str,map.getOrDefault(str,0)+1) ;
                     added.add(str);
                 }
             }
          }

         int competitorCount = map.entrySet().size()<=topNCompetitors?map.entrySet().size():topNCompetitors;
          
          Queue<Map.Entry<String, Integer>> maxHeap = new PriorityQueue<>((a, b)->a.getValue() == b.getValue() ? a.getKey().compareTo(b.getKey()) : b.getValue() - a.getValue());
      	maxHeap.addAll(map.entrySet());
      	while(!maxHeap.isEmpty() && competitorCount-- > 0) {
      		res.add(maxHeap.poll().getKey());
      	}
      	return new ArrayList<>(res);
    }
}
