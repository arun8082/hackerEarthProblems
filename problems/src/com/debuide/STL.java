package com.debuide;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/*
 String s = "abaaAAAABbBZZyyyZy"
a = 7
B = 4
y = 4
Z = 3
 */

public class STL {

//	public static void main(String[] args) {
//
//		division(3, 0);
//	}

	static int division(int x, int y) {
		int res;
		try {
			res = x / y;
			return res;
		} catch (Exception e) {
			return -1;
		} finally {
			return -2;
		}
//		return -3;
	}

	public static void main(String[] args) {
		String s = "aBaaAAAAbbBZZyyyZy";
		Map<Character, Integer> map = new HashMap<>();
		
		char []chars = s.toCharArray();
		for(int i=0; i<chars.length;i++) {
			char currentChar = chars[i];
			Character l = Character.toLowerCase(currentChar);
			Character u = Character.toUpperCase(currentChar);
			
			if(map.containsKey(l) || map.containsKey(u)) {
				if(map.get(l)!=null){
					map.put(l, map.get(l)+1);
				}else {
					map.put(u, map.get(u)+1);
				}
			}else {
				map.put(currentChar,1 );
			}			
		}	
		System.out.println(map);
	}
}
