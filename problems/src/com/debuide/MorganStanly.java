package com.debuide;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

class thredTest implements Runnable {

	@Override
	public void run() {
		System.out.println("running");
	}

}

public class MorganStanly implements Comparable<Integer> {

	public static void main(String[] args) {
		int[] a = new int[] { 1, 3, 3, 5, 7 };
		int[] d = new int[] { 2, 2, 1, 2, 1 };

//		int[] a = new int[] { 1, 3, 5 };
//		int[] d = new int[] { 2, 2, 2 };

		List<Integer> ar = Arrays.stream(a).boxed().toList();
		List<Integer> dr = Arrays.stream(d).boxed().toList();
		System.out.println(maxEvents(ar, dr));
	}

	static int maxEvents(List<Integer> arrival, List<Integer> duration) {
		int res = 0;
		int num = 0;
		for (int i = 0; i < arrival.size(); i++) {
			if (res <= arrival.get(i)) {
				res += duration.get(i);
				num++;
//				System.out.println(arrival.get(i) + "::" + duration.get(i));
			}
		}

		return num;
	}

	public static void main1(String[] args) {
		Thread t = new Thread(new thredTest());
		t.run();
		t.start();

		Animal a1 = new Animal("c");
		Animal a2 = new Animal("d");
		System.out.println(a1 + " " + a2);
		swap(a1, a2);
		System.out.println(a1 + " " + a2);

		Object[] a = new Object[] { new String("a"), new Integer(10), new Boolean(false) };
		Arrays.sort(a);
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i].toString());
		}

	}

	static void swap(Animal a1, Animal a2) {
		Animal t = new Animal("");
		t = a1;
		a1 = a2;
		a2 = t;
	}

	@Override
	public int compareTo(Integer o) {
		// TODO Auto-generated method stub
		return 0;
	}

}

class Animal {
	String name;

	public Animal(String a) {
		name = a;
	}

	@Override
	public String toString() {

		return name;
	}
}
