package Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LuckyDays {

	public static void main(String[] args) {
//		int prices[] = new int[] {2,3,5,10,9};
		int prices[] = new int[] {7,3,4,8};
		System.out.println(luckyDays(prices.length,prices));
	}
	static int luckyDays(int N, int[] prices) {
		List<Integer> pricesList = Arrays.stream(prices).boxed().collect(Collectors.toList());
		int count =0;
		int n= prices.length;
		for (int i=0;i<n;i++) {
			List<Integer> sublist= pricesList.subList(i+1, n);
			if(sublist.size()==0) {
				break;
			}
			int max = Collections.max(sublist);
			if(max < prices[i]) {
				count++;
			}
		}
		return count+1;
	}
}
