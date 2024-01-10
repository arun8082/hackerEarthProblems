package test;

public class SumOfBitDifferencesAmongAllPairs {

	public static void main(String[] args) {
		int arr[] = { 1, 2 ,3,7}; 
		int n=23;
		//System.out.println((n&(1<<4)) +" "+Integer.toBinaryString((1<<4))+" "+Integer.bitCount((1<<4)));
		int res=sumOfBitDifferences(arr);
		System.out.println("Res: "+res);
	}
	
	static int sumOfBitDifferences(int arr[]) {
		int res=0;
		for (int i = 0; i < 32; i++) {
			int count=0;
			//count not set bits
			for(int j=0; j<arr.length;j++) {
				if((arr[j] & (1 << i)) == 0) {
					count++;
				}
				//System.out.println(arr[j]+" i: "+i+" not set: "+count);
			}
			res += (count * (arr.length - count) * 2);
			//System.out.println("Res: "+res+" count: "+count+" (arr.length - count):"+(arr.length - count));
		}
		return res;
	}
}
