package geeksDataStructure;

public class BinarySearch {
	
	static int findPivote(int []ar,int start,int end) {
		int pivot=-1;
		if (start >end)
			return pivot;
		if (start==end)
			return start;
		
		for (int i=start;i<end;i++) {
			if(ar[i+1]<ar[i]) {
				pivot=i;
				break;
			}
		}
		return pivot;
	}	
	
	
	static int findPivoteRecursion(int []ar,int start,int end) {
		if (start >end)
			return -1;
		if (start==end)
			return start;
		
		int mid = (start+end)/2;
		if (mid < end &&ar[mid]>ar[mid+1]) 
			return mid;
		if(ar[start] >= ar[mid])
			return findPivoteRecursion(ar, start, mid-1);
		return findPivoteRecursion(ar, mid+1, end);
	}
	
	static int pivotedBinarySearch(int []ar,int key) {
		int n =ar.length;
		int pivot = findPivote(ar, 0, n);
		if (key==ar[pivot] )
			return key;
		if (ar[0]<=key)
			return binarySearch(ar, 0,pivot-1, key);
		return binarySearch(ar, pivot+1, n-1, key);
	}
	
	static int binarySearch(int []ar,int start,int end,int key) {
		if (start>end)
			return -1;
		int mid = (start+end)/2;
		if (key==ar[mid])
			return key;
		if (key>ar[mid])
			return binarySearch(ar, mid+1, end, key);
		return binarySearch(ar, start,mid-1, key);
	}
	
	public static void main(String[] args) {
		int []ar = new int[]{5, 6, 7, 8, 9, 10, 1, 2, 3};
		System.out.println(pivotedBinarySearch(ar,17));
	}
}
