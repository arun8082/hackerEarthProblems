package com.debuide;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class LongestuniqueSubString {

	{
		//1 1 2 3 5 8 13
		int a=1;
		int b =1;
		int last =b;
		for(int i=0; i<10;i++) {
			last =a+b;
			System.out.print(last+" ");
			a = b;
			b = last;
		}
		System.out.println(Arrays.toString(merge(new int[] {1,2,7}, new int[] {0,4,8})));
	}
	
	public LongestuniqueSubString() {
		List<CharSequence> list = new ArrayList<CharSequence>();
		list.add("a");
		System.out.println("constructor");
	}
	
	public static void main(String[] args) {
		LongestuniqueSubString a = new LongestuniqueSubString();
//		System.out.println(LongestUniqueSubString("GEEKSFORGEEKS")+":"+LongestUniqueSubString("GEEKSFORGEEKS").length());
//		System.out.println(lengthOfLongestSubstringHashmap("GEEKSFORGEEKS"));
	}

	private static String LongestUniqueSubString(String str) {
		int i;
		int n = str.length();
		int st = 0;
		int currlen = 0;
		int maxlen = 0;
		int start = 0;
		HashMap<Character, Integer> pos = new HashMap<Character, Integer>();
		pos.put(str.charAt(0), 0);
		for (i = 1; i < n; i++) {
			char currentChar = str.charAt(i);
			if (!pos.containsKey(currentChar)) {
				pos.put(currentChar, i);
			} else {
				if (pos.get(currentChar) >= st) {
					currlen = i - st;
					if (maxlen < currlen) {
						maxlen = currlen;
						start = st;
					}
					st = pos.get(currentChar) + 1;
				}
				pos.replace(currentChar, i);
			}
			
		}
		if (maxlen < i - st) {
			maxlen = i - st;
			start = st;
		}
		return str.substring(start, start + maxlen);
	}

	private static String reverse(String str) {
		char[] st = str.toCharArray();
		int n = str.length();
		for (int i = 0; i < n / 2; i++) {
			char tmp = st[i];
			st[i] = st[n - i - 1];
			st[n - i - 1] = tmp;
		}
		return new String(st);
	}

	static int lengthOfLongestSubstring(String str) {
		int i=0;
		int j=0;
		int max =0;
		int n = str.length();
		
		Set<Character> set = new HashSet<>();
		while(i<n && j<n) {
			Character currentChar = str.charAt(j);
			if(!set.contains(currentChar)) {
				set.add(currentChar);
				j++;
				max = Math.max(max, j-i);
			}else {
				set.remove(currentChar);
				i++;
			}
		}
//		System.out.println(i+":"+j+":"+str.substring(i-1,j));
		return max;
	}
	
	static int lengthOfLongestSubstringHashmap(String str) {
		int left=0,right=0;
		int max =0;
		int n = str.length();
		Map<Character,Integer> map = new HashMap<>();
		
		while(right<n) {
			Character curChar = str.charAt(right);
			if(map.containsKey(curChar)) {
				left = Math.max(map.get(curChar)+1, left);
			}
			map.put(curChar, right);
			max = Math.max(max, right-left+1);
			right++;
		}
		return max;
	}
	
	static int[] merge(int[]arr1, int[] arr2) {
		int re[] = new int[arr1.length+arr2.length];
		int k =0;
		for(int i=0;i<arr1.length;i++) {
			re[k++]=arr1[i];
		}
		for(int i=0;i<arr2.length;i++) {
			re[k++] = arr2[i];
		}
		Arrays.sort(re);
	return re;	
	}
	
}
