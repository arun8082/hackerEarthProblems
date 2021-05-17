package Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

class runable implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i < 1000; i++)
			System.out.println(Thread.currentThread().getName() + "->" + i);
	}
}

public class Test implements int1, int2, Runnable {
	@Override
	public void run() {
		for (int i = 0; i < 1000; i++)
			System.out.println(Thread.currentThread().getName() + "->" + i);
	}

	public static void main(String[] args) {

		String originalString = "Amdocs@pune_mh12";
		int n = originalString.length();
		char []revString = new char[n];
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < n; i++) {
			char currentchar = originalString.charAt(i);
			if ((currentchar >= 'a' && currentchar <= 'z')
					|| (currentchar >= 'A' && currentchar <= 'Z')) {
				stack.push(currentchar);
			} else {
				revString[i] = currentchar;
			}
		}
		for (int i = 0; i < n; i++) {
			int a = (int)'\0';
			int b = revString[i];
			if (a==b) {
				revString[i]= stack.pop();
			}
		}
	
		System.out.println(originalString);
		System.out.println(revString);
		

	}
	/*
	 * public static void main(String[] args) { int i=2; int j=7; int d=j-i; String
	 * s=Integer.toBinaryString(j);
	 * System.out.println("Base10: "+Integer.parseInt(s, 2));
	 * System.out.println("d: "+Integer.toBinaryString(d)+" "+(d<<-0)); }
	 */
	/*
	 * public static void main(String[] args) { ArrayList l = new ArrayList();
	 * l.add(1); l.add(12); l.add(2); l.add(3); l.add(4); //l.remove(1); Iterator i
	 * = l.listIterator(); while(i.hasNext()) { // System.err.println(i.next()); //
	 * i.remove(); // l.add(9); } l.add(9); // i.remove(); System.out.println(l); }
	 */

	/*
	 * public static void main(String[] args) {
	 * 
	 * HashMap<A,Integer> map = new HashMap<A, Integer>(1);
	 * System.out.println(map.size()); try (Scanner sc = new Scanner(System.in);){
	 * throw new ExceptionInInitializerError(); } catch (NullPointerException
	 * |ExceptionInInitializerError ne1) {
	 * System.out.println("msg:"+ne1.getMessage()); }
	 * 
	 * map.put(new A(1), 1); map.put(new A(2), 2); map.put(new A(1), 3); map.put(new
	 * A(1), 4); map.put(new A(5), 5); System.out.println(map.size());
	 * System.out.println(map.values()); }
	 */
}

interface int1 {
	default void log() {
		System.out.println("int1");
	}

	static void f() {
		System.out.println("nt1 static");
	}
}

interface int2 {
	default void log2() {
		System.out.println("int2");
	}

	default void log3() {
		System.out.println("int21");
	}

	static void f() {
		System.out.println("nt2 static");
	}
}

class A {
	int c;

	public A(int x) {
		c = x;
	}

	@Override
	public int hashCode() {
		return 1;
	}

	@Override
	public boolean equals(Object obj) {
		A other = (A) obj;
		if (c != other.c)
			return false;
		return true;
	}
}
