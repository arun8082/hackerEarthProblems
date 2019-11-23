package Test;

import java.util.ArrayList;
import java.util.List;

public class SumOfAbsoluteDifferencesOfAllPairs {

	public static void main(String[] args) {
		int arr[]= {1, 8, 9, 15, 16};
		int res=sumOfAbsoluteDifferencesOfAllPairs(arr);
		System.out.println("Res: "+res);
	}

	private static int sumOfAbsoluteDifferencesOfAllPairs(int[] arr) {
		int sum=0;
		/*for (int i = 0; i < arr.length; i++) {
			int x=arr[i];
			for (int j = i+1; j < arr.length; j++) {
				//System.out.println(x+","+arr[j]);
				sum +=(x-arr[j])>0?(x-arr[j]):-(x-arr[j]);				
			}
		}*/
		
		//add i times -subtract (i-1) times
		for(int i=0; i<arr.length;i++) {
			sum += arr[i]*i-arr[i]*(arr.length-1-i);
		}
		return sum;
	}
	
}
