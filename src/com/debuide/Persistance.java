package com.debuide;

import java.util.Arrays;

public class Persistance {
	static int moveAppels(int n, int input2[]) {
		int res = 0;
		int s = Arrays.stream(input2).sum();
		int e = s / n;
		for (int i = 0; i < n; i++) {
			if (input2[i] < e) {
//				res +=e-input2[i];
			} else if (input2[i] > e) {
				res += input2[i] - e;
			}
		}

		return res;
	}

	static int minjumps(int n, int[] input2) {
		int m = 0;
		n = input2.length;
		int mov = 0;
		int i = 0;
		while (i < n) {
			mov = input2[i];
			if (mov == 0 && i != input2.length) {
//				m =-1;
				break;
			} else {
				System.out.println(i + "--M::" + mov);
				i += mov;
				m++;
			}
		}

		return m;
	}

	public static void main(String[] args) {
		int[] a = { 1, 3, 6, 1, 0, 9, 8, 7, 6 };
//		a = new int[] { 2, 1, 1 };
		System.out.println(minjumps(0, a));

		int b[] = new int[] { 2849, 1620, 705, 1, 30 };
//		System.out.println(moveAppels(b.length, b));
	}

}
