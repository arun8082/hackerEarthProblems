package geeksDataStructure;

import java.util.Arrays;

public class ArrayRotation {
	static void rotate1(int ar[], int d, int n) {
		int[] tmp = new int[d];
		for (int i = 0; i < d; i++) {
			tmp[i] = ar[i];
		}
		for (int i = 0; i < ar.length - d; i++) {
			ar[i] = ar[i + d];
		}
		for (int i = 0; i < tmp.length; i++) {
			ar[ar.length - tmp.length + i] = tmp[i];
		}
	}

	static void rotate2(int ar[], int d, int n) {
		for (int j = 0; j < d; j++) {
			int tmp = ar[0];
			for (int i = 0; i < n - 1; i++) {
				ar[i] = ar[i + 1];
			}
			ar[ar.length - 1] = tmp;
		}

	}

	public static void main(String[] args) {
		int[] ar = new int[] { 1, 2, 3, 4, 5, 6, 7 };
		System.out.println(Arrays.toString(ar));
		rotate2(ar, 2, 7);
		System.out.println(Arrays.toString(ar));
	}

}
