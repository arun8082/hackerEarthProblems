package com.debuide;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Icong {
	public static void main(String[] args) {
		int N=4;
		int x=5;
		int k =2;
		int []p= {1,2,3,4,6,1};
//		System.out.println(getCost(x,k,p,N));
		byte b=5;
		System.out.println(b<<33);
//		System.out.println(getCount("abcd","bd"));
		System.out.println('a'+" "+10);
		Queue<Integer> q = new LinkedList<>();
		System.out.println("h"+false);
		
	}
	

	private static int getCount(String s1, String s2) {
		Map<Character, Long> m1 = s1.chars().mapToObj(i -> (char) i)
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		Map<Character, Long> m2 = s2.chars().mapToObj(i -> (char) i)
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

		List<Map.Entry<Character, Long>> a3 = m1.entrySet().stream().distinct().filter(m2.entrySet()::contains)
				.collect(Collectors.toList());
		int total = 0;
		for (Map.Entry<Character, Long> p : a3) {
			total += p.getValue();
		}

		return total;
	}

	static int getCost(int x, int k, int[] prices, int N) {
		// k max remembeer
		// x each price
		int total = 0;
		Set<Integer> list = Arrays.stream(prices).boxed().collect(Collectors.toSet());
		int s = list.size();
		int r = s - k;
		total = r * x;
		return total;
	}
}
