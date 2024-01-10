package com.debuide;
//Java implementation of the above approach

import java.util.*;

class Test {

	static void AlternateRearrange(int arr[], int n) {
		List<Integer> even = new ArrayList<>();
		List<Integer> odd = new ArrayList<>();
		Arrays.sort(arr);
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] % 2 == 0) {
				even.add(arr[i]);
			} else {
				odd.add(arr[i]);
			}
		}
		int i = 0, j = 0,k=0;
		boolean flag =false;
		List<Integer> res = new ArrayList<Integer>();
		if (arr[0]%2==0) {
			flag = true;
		}
		while(k<n) {
			if(flag ==true) {
				res.add(even.get(i));
				k++;
				i++;
				flag = !flag;
			}else {
				res.add(odd.get(j));
				k++;
				j++;
				flag = !flag;
			}
		}
		System.out.println(res);

	}

	// Driver code
	public static void main(String[] args) {
		int arr[] = { 47, 49, 36, 98, 90 };
		int n = arr.length;

		AlternateRearrange(arr, n);
	}
}

//This code is contributed by aishwarya.27
