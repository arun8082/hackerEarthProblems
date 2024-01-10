package leetcode.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class P006_ZigzagConversion {
	static class WithIndex {
		Character c;
		Integer index;

		public WithIndex(char charAt, int i) {
			c = charAt;
			index = i;
		}

		@Override
		public String toString() {
			return c + "";
		}

	}

	public static String convert(String s, int numRows) {
		int n = s.length();
		Map<Integer, StringBuilder> map = new HashMap<>();
		for (int i = 1; i <= numRows; i++) {
			map.put(i, new StringBuilder());
		}
		int count = 1;
		boolean isIncrement = true;
		if (numRows == 1) {
			for (char ch : s.toCharArray()) {
				map.get(numRows).append(ch);
			}
		} else {
			for (int i = 0; i < n; i++) {
				if(!map.containsKey(count)) {
					map.put(i, new StringBuilder());
				}
				if (isIncrement) {
					map.get(count++).append(s.charAt(i));
					if (count > numRows) {
						count--;
						isIncrement = false;
					}
				} else {
					map.get(--count).append(s.charAt(i));
					if (count == 1) {
						count++;
						isIncrement = true;
					}
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= numRows; i++) {
			sb.append(map.get(i));
		}

		return sb.toString();
	}
	
	public static String convert2(String s, int numRows) {
		int n = s.length();
		Map<Integer, StringBuilder> map = new HashMap<>();
		for (int i = 1; i <= numRows; i++) {
			map.put(i, new StringBuilder());
		}
		int count = 1;
		boolean isIncrement = true;
		List<WithIndex> list = new ArrayList<>();
		if (numRows == 1) {
			for (char ch : s.toCharArray()) {
				list.add(new WithIndex(ch, numRows));
			}
		} else {
			for (int i = 0; i < n; i++) {
				if (isIncrement) {
					list.add(new WithIndex(s.charAt(i), count++));
					if (count > numRows) {
						count--;
						isIncrement = false;
					}
				} else {
					list.add(new WithIndex(s.charAt(i), --count));
					if (count == 1) {
						count++;
						isIncrement = true;
					}
				}
			}
		}
		System.out.println(map);

		Map<Integer, List<WithIndex>> map1 = list.stream().collect(Collectors.groupingBy(i -> i.index)); //
//		System.out.println(map1);
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= numRows; i++) {
			sb.append(map1.getOrDefault(i, new ArrayList<WithIndex>()).stream().map(j -> j.c + "")
					.collect(Collectors.joining("")));
		}

		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println(convert("PAYPALISHIRING", 3));
		System.out.println(convert("PAYPALISHIRING", 4));
		System.out.println(convert("A", 2));
		System.out.println(convert("AB", 1));

	}

}
