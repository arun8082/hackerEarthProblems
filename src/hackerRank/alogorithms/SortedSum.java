package hackerRank.alogorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortedSum {

	static long getSum(List<Integer> s) {
		long sum =0;
		s.sort(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1.compareTo(o2);
			}
		});
		
		for(int i=0;i<s.size();i++) {
			sum += (i+1)*s.get(i);
		}
		return sum;
	}
	
	public static int sortedSum(List<Integer> a) {
		long sum =0;
		for(int i=0;i<a.size();i++) {
			List<Integer> s =a.subList(0, i+1);
			 sum += getSum(s);
		}
		return (int)Math.floorMod(sum, (long)(Math.pow(10, 9)+7));
	}

	public static void main(String[] args) {
		int n =3;
//		int []a  = {4,3,2,1};
		int []a  = {9,5,8};
		List<Integer> list = Arrays.stream(a).boxed().collect(Collectors.toList());
		System.out.println(sortedSum(list));
	}

}
