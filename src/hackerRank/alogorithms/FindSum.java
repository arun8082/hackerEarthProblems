package hackerRank.alogorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class FindSum {
	
	public static List<Long> findSum(List<Integer> numbers, List<List<Integer>> queries) {
	    List<Long> list = new ArrayList<Long>();
//	    for (List<Integer> q : queries) {
	    queries.stream().forEach(q->{
//	    	Long sum = 0l;
	    	List<Integer> sublist = numbers.subList(q.get(0)-1, q.get(1));
	    	int freq =Collections.frequency(sublist, new Integer(0));
	    	Long sum = sublist.stream().mapToLong(i->i).sum();
	    	sum = sum +(freq*q.get(2));
	    	for(Integer i : sublist) {
	    		if(i==0) {
	    			sum +=q.get(2); 
	    		}else {
	    			sum +=i;
	    		}
	    	}
	    	list.add(sum);
	    });
	    
	    /*queries.stream().forEach(q->{
	    		List<Integer> sublist = numbers.subList(q.get(0), q.get(1));
	    		sublist.stream().forEach(i->{
	    			Long sum = 0l;
	    			if(i==0) {
	    				sum +=q.get(2);
	    			}else {
	    				sum +=i;
	    			}
	    		});
	    	});
	    	*/	    	    
	    
		return list;
    }
	public static void main(String[] args) {
		
	}
}
