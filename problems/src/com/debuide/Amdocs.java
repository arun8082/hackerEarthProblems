package com.debuide;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Ticket implements Comparable<Ticket>{
	Integer id;
	Integer time;
	public Ticket(Integer id,Integer time) {
		this.id=id;
		this.time =time;
	}
	@Override
	public int compareTo(Ticket o) {
		if(this.time!= o.time) {
			return this.time.compareTo(o.time);
		}else {
			return this.id.compareTo(o.id);
		}
	}
	@Override
	public String toString() {
//		return "{"+id+" "+time+"}";
		return id+" ";
	}
	
}
class B{
	public void M() {
		System.out.println("class Method");
	}
}

public class Amdocs {
	
	static void printResult(int arr[][]) {
		List<Ticket> list = new ArrayList<Ticket>();
		for(int []ar:arr) {
			list.add(new Ticket(ar[0],ar[1]));
		}
		Collections.sort(list);		
		System.out.println(list);
	}
	static void printd(int num) {
			int n = (num+"").length();
			char arr[] = (num+"").toCharArray();
	        for(int i = 1; i < n; i++){  
	            char j, first;  
	            first = arr[0];  
	            for(j = 0; j < arr.length-1; j++){  
	                arr[j] = arr[j+1];  
	            }  
	            arr[j] = first;  
	            System.out.print(new String(arr)+" ");
	        }  	       
	    }  
	
	public static void main(String[] args) {
		int[][]arr = {{2,3},{4,1},{6,4},{5,2},{1,3},{7,3},{3,2}};
		printResult(arr);
		
		
		
	}
}
