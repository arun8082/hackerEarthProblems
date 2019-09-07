package hackerRank.arrays;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class ArrayLeftRotation {

	private static final Scanner scanner = new Scanner(System.in);

	private static int[] leftRotate(int count, int[] arr) {
		for (int j = 0; j < count; j++) {
			int temp=arr[0];
			for (int i = 0; i < arr.length-1; i++) {
				arr[i]=arr[i+1];
			}
			arr[arr.length-1]=temp;
		}
		return arr;
	}

	public static void main(String[] args) {
		String[] nd = "5 4".split(" ");//scanner.nextLine().split(" ");

		int n = Integer.parseInt(nd[0]);

		int d = Integer.parseInt(nd[1]);

		int[] a = new int[n];

		String[] aItems = "1 2 3 4 5".split(" ");// scanner.nextLine().split(" ");
		//scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < n; i++) {
			int aItem = Integer.parseInt(aItems[i]);
			a[i] = aItem;
		}
		
		for(int e:leftRotate(d,a)) {
			System.out.print(e+ " ");
		}
		
		scanner.close();
	}

}
