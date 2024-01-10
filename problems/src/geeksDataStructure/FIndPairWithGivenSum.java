package geeksDataStructure;

public class FIndPairWithGivenSum {

	public static void main(String[] args) {
		int []ar =new int[]  {11, 15, 26, 38, 9, 10};
		int x = 369;
		System.out.println(pairInSortedRotated(ar,x));
	}

	static int findPivot(int []ar,int start,int end) {
		if (start>end)
			return -1;
		int pivot =-1;
		for (int i=start;i<end;i++)
			if (ar[i+1]<ar[i]) {
				pivot =i;
				break;
			}
		return pivot;
	}
	
	static boolean pairInSortedRotated(int[] ar, int sum) {
		int n = ar.length;
		int pivot = findPivot(ar, 0, n);
		int l=(pivot+1)%n,r=pivot;
		boolean status = false;
		while(l!=r) {
			if(ar[l]+ar[r]==sum) {
				status = true;
				break;
			}
			if (ar[l]+ar[r]<sum) {
				l = (l+1)%n;
			}else
				r = (n+r-1)%n;
		}
		return status;
	}
}
