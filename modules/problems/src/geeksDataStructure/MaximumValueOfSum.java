package geeksDataStructure;

import java.util.Arrays;

public class MaximumValueOfSum {
	static int sum(int []ar) {
		int sum=0;
		for (int i = 0; i < ar.length; i++) {
			sum += i*ar[i];
		}
		return sum;
	}
	
	static void rotate(int []ar,int d) {
		int n=ar.length;
		for (int i=0;i<d;i++) {
			int tmp= ar[i];
			for (int j = 0; j < n-1; j++) {
				ar[j]=ar[j+1];
			}
			ar[n-1]=tmp;
		}
	}
	
	static int maxSum(int []ar) {
		int n = ar.length;
		int max = sum(ar);
		for(int i=0;i<n;i++) {
			rotate(ar, 1);			
			int sum =sum(ar);
			if (sum>max){
				max=sum;
			}
		}
		return max; 
	}
	public static void main(String[] args) {
		int ar[]= new int[] {10, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		System.out.println(maxSum(ar));
		System.out.println(Arrays.toString(ar));
	}
}
