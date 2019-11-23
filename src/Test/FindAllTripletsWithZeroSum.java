package Test;

public class FindAllTripletsWithZeroSum {

	public static void main(String[] args) {
		int arr[] =new int[] {1, -2, 1, 0, 5};
		findAllTripletsWithZeroSum(arr);		
		
	}

	private static void findAllTripletsWithZeroSum(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = i+1; j < arr.length-1; j++) {
				//System.out.println("i: "+arr[i]+" j:"+arr[j]+" j+1: "+arr[j+1]);
				if((arr[i]+arr[j]+arr[j+1])==0) {
					System.out.println(i+" "+arr[j]+" "+arr[j+1]);
				}
			}
		}		
	}	
}
