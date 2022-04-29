package leetcode.problems;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class P013_RomantoInteger {
	public static int romanToInt(String s) {
		Map<String, Integer> map = new HashMap<String, Integer>() {
			{
				put("I", 1);
				put("V", 5);
				put("X", 10);
				put("L", 50);
				put("C", 100);
				put("D", 500);
				put("M", 1000);
			}
		};
		int res = map.get(s.charAt(s.length() - 1) + "");
		for (int i = s.length() - 2; i >= 0; i--) {
			if (map.get(s.charAt(i) + "") < map.get(s.charAt(i + 1) + "")) {
				res -= map.get(s.charAt(i) + "");
			} else {
				res += map.get(s.charAt(i) + "");
			}
		}
		return res;
	}

	public static int romanToInt2(String s) {
		int res = getValue(s.charAt(s.length() - 1));
		for (int i = s.length() - 2; i >= 0; i--) {
			int ch = getValue(s.charAt(i));
			if (ch < getValue(s.charAt(i + 1))) {
				res -= ch;
			} else {
				res += ch;
			}
		}
		return res;
	}

	public static int getValue(char s) {
		switch (s) {
		case 'I':
			return 1;
		case 'V':
			return 5;
		case 'X':
			return 10;
		case 'L':
			return 50;
		case 'C':
			return 100;
		case 'D':
			return 500;
		case 'M':
			return 1000;
		}
		return 0;
	}

	public static void main(String[] args) {
		System.out.println(romanToInt("IV"));
		System.out.println(romanToInt("III"));
		System.out.println(romanToInt("LVIII"));
		System.out.println(romanToInt("MCMXCIV"));

	}

}
