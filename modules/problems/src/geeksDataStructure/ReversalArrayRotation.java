package geeksDataStructure;

import java.util.Arrays;

public class ReversalArrayRotation {
	
	static void rotate(int []ar,int d,int n) {
		if (d==0) 
			return;
		d=d%n;
		reverseArray(ar,0, d);
		reverseArray(ar,d, n);
		reverseArray(ar, 0,n);
	}
	static void reverseArray(int []ar,int start,int end) {		
		for(int i=start;i<end/2+1;i++) {
			int tmp=ar[i];
			ar[i]=ar[--end];
			ar[end]=tmp;
		}
	}
	public static void main(String[] args) {
		int []ar = new int[] {1,2,3,4,5,6,7};
		rotate(ar,12,7);
		System.out.println(Arrays.toString(ar));
	}
}
