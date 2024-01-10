package com.debuide;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class TechMahindra {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>() {{
			add(1);
			add(2);
			add(3);
			add(4);
			add(6);
		}};
		permutation("12");
		System.out.println(TechMahindra.list);
	}

	private static int balanced(List<Integer> list) {
		
		int p=0;
		
		for(int i=0;i<list.size();i++) {
			List<Integer> list1 = list.subList(0,i );
			List<Integer> list2 = list.subList(i+1, list.size());
			int sum1 = list1.stream().mapToInt(k->k).sum();
			int sum2 = list2.stream().mapToInt(k->k).sum();
			if(sum1==sum2) {
				p=i;
				break;
			}
			
		}
		return p;
	}
	
	 public static void permutation(String input){
         permutation("", input);
	 }
	 static List<String> list = new ArrayList<String>();
	 private static void permutation(String perm, String word) {
		if(word.isEmpty()) {
			System.out.println(perm+word);
			list.add(perm+""+word);
		} else {
			for(int i=0; i<word.length();i++) {
				permutation(perm+word.charAt(i), word.substring(0,i)+word.substring(i+1,word.length()));
			}
		}
	 }
	

}
