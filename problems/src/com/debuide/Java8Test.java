package com.debuide;

@FunctionalInterface
interface A{
	
	int sub(int x, int y);
	
	default int add(int x,int y) {
		return x+y;
	}
}

public class Java8Test {

	public static void main(String[] args) {
		//Java8Test o = new Java8Test();
		A o = (x,y)->x-y;
		System.out.println(o.sub(2, 5));
	}

	
}
