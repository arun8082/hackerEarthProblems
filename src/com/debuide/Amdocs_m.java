package com.debuide;

import java.util.ArrayList;
import java.util.Arrays;

public class Amdocs_m {

	public static void main(String[] args) {
		int a[] = {1,2,3,4,5};
		int max = Arrays.stream(a).max().getAsInt();
		System.out.println(max);
		ArrayList<Integer> list = new ArrayList<>(2);
		list.add(1);
		list.add(1);
		list.add(1);
		System.out.println(list.size());
	}
}
