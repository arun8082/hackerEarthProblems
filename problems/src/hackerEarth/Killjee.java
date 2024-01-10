package hackerEarth;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Killjee {

	public static void main(String[] args) {
		int n=5;
		int m=5;
		int []narr=new int[] {1,1,2,3,4};
		int []marr=new int[] {2,3,3,4,5};
		
		List<int[]> list = new ArrayList<int[]>();
		int arr[]=new int[10]; 
		int k=100;
		arr[k++]=narr[0];
		int flag=0;
		int j;
		for(int i=0; i<n;i++) {
			for(j=0; j<m;j++) {
				if(narr[i]+1==marr[j]) {
					arr[k++]=marr[j];
					flag=1;					
				}
			}
			arr[k++]=marr[j-1];
			list.add(arr);
			arr=new int[10];
			flag=0;
			
		}
		for (int i[] : list) {
			System.out.println(Arrays.toString(i));
		}

	}

}
