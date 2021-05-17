package hackerRank.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MaxSubArrayValue {
	public static long maxSubarrayValue(List<Integer> arr) {
		long max = -1;
		for (int i=0; i <arr.size(); i++){
			for (int j=i; j<arr.size(); j++) {
				List<Integer> l = new ArrayList<Integer>();
				for (int k=i; k<=j; k++) {
					l.add(arr.get(k)); 
				}
				int oddsum = 0;
				int evensum = 0;
				for (int k = 0; k < l.size(); k++) {
					if (k % 2 == 0) {
						evensum += l.get(k);
					} else {
						oddsum += l.get(k);
					}
				}
				long r = (evensum - oddsum) * (evensum - oddsum);
				System.out.println(l + "==" + evensum + "==" + oddsum + "==" + r);
				if (max < r) {
					max = r;
				}
			}
		 }
		return max;
	}

	public static void main(String[] args) {
//		int[] arr = { 6, 3, -1, -1, -1, 5, 1 };
		int[] arr = {1,-1,1,-1,1};
		
		List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
		System.out.println(maxSubarrayValue(list));
	}
}
