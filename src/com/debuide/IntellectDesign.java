package com.debuide;

import java.util.Arrays;

/*
 
3-sum:

Given an array nums of n integers and an integer target, find three integers 
in nums such that the sum is closest to target. Return the sum of the three 
integers. You may assume that each input would have exactly one solution.

Input:         nums = [-1,2,1,-4],  target = 1
Output:      2  		-> (-1 + 2 + 1 = 2).
 
 */

public class IntellectDesign {

	public static void main(String[] args) {

		int[] ar = new int[] { -1, 2, 1, -4 };
		int target = 2;

		Arrays.sort(ar);

		int i = 0, j = ar.length - 1;
		int min = 0;
		while (j > i) {
			int s = calculateSum(ar, i, j);
			if (s < target) {
				i++;
			} else if (s > target) {
				j--;
			}

		}

		System.out.println(i + ":" + j);
	}

	static int calculateSum(int[] ar, int start, int end) {
		return ar[start] + ar[end];
	}

}
