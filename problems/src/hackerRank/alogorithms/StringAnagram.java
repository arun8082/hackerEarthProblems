package hackerRank.alogorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StringAnagram {
	
	static int sum =0;
	
	public static List<Integer> stringAnagram(List<String> dictionary, List<String> query)    {
	        List<Integer> list = new ArrayList<>();	        
	        for(String q:query) {
	        	if(dictionary.contains(q)) {
	        		sum +=1;
	        	}else {
	        		dictionary.stream().forEach(d->{
	        			if(d.length()== q.length()) {
	        				List<Character> dlist = d.chars().mapToObj(c->(char)c).collect(Collectors.toList());	        				
	        				Map<Character,Long> dmap = dlist.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
	        				
	        				List<Character> qlist = q.chars().mapToObj(c->(char)c).collect(Collectors.toList());	        				
	        				Map<Character,Long> qmap = qlist.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
	        				boolean s =true;
	        				
	        				for(Map.Entry<Character, Long> entry : dmap.entrySet()) {
	        					if(qmap.containsKey(entry.getKey()) &&( qmap.get(entry.getKey())==entry.getValue())) {
	        						s=false;
	        						break;
	        					}
	        				}
	        				if(s) {
	        					sum +=1;
	        				}
	        			}
	        		});
	        	}
	        	list.add(sum);
	        	sum =0;
	        }	        
	        return list;
	 }
	 
	 public static void main(String[] args) {
		
	}

}
