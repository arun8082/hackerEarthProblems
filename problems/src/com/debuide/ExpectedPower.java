package com.debuide;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ExpectedPower {

	static Map<Character, Integer> charsPosition = new HashMap();
	
	public static void main(String[] args) {
		String s = "abc";
		int k =2;
		int c =0;
		for(int i='a'; i<='z';i++) {
			charsPosition.put((char)i, c++);
		}
		System.out.println(calculatePower(s, k));

	}
	
	private static int calculatePower(String s, int k) {
		List<String> list = new ArrayList();
		for(int i=0;i<s.length();i++) {
			for(int j=i;j<=s.length();j++) {
				if(j-i==k) {
					list.add(s.substring(i,j));
				}else if(j-1==1) {
					StringBuilder t= new StringBuilder();
					for(int l=0;l<k;l++) {
						t.append(s.charAt(i));
					}
					list.add(t.toString());
				}
			}
		}
		System.out.println(list);
		int sum =0;
		String str = "abcdef";
		int a=str.chars().map(i->{
			return charsPosition.get((char)i);
		}).sum();
		System.out.println(a);
		return 0;
	}

}
