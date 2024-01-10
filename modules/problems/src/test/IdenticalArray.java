package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class IdenticalArray {

	public static void main(String[] args) {
		int N = 3, M = 2, K = 5;
		int[] A = new int[] { 1, 5, 3 };
		int[] B = new int[] { 1, 5 };
		int[] C = new int[] { 1, 3, 4, 5, 2 };
		String out_ = solve(N, M, K, A, B, C);
		/*int N = 3, M = 2, K = 5;
		int[] A = new int[] { 1, 2, 3 };
		int[] B = new int[] { 3, 1 };
		int[] C = new int[] { 1, 2, 3, 4, 5};
		String out_ = solve(N, M, K, A, B, C);*/
		/*int N = 3, M = 2, K = 5;
		int[] A = new int[] { 1, 5, 3 };
		int[] B = new int[] {  5,3 };
		int[] C = new int[] { 1, 3, 4, 5, 2 };
		String out_ = solve(N, M, K, A, B, C);*/
		System.out.println(out_);

	}
	static String solve(int N, int M, int K, int[] A, int[] B, int[] C) {	
		List<Integer> alist = Arrays.stream(A).boxed().collect(Collectors.toList());
		List<Integer> blist = Arrays.stream(B).boxed().collect(Collectors.toList());
		List<Integer> clist = Arrays.stream(C).boxed().collect(Collectors.toList());
		int start=Collections.lastIndexOfSubList(alist, blist);
		if(start==-1) {
			return "No";
		}
		int end =start+blist.size()-1;
		Map<Integer,Integer> map = new HashMap<Integer, Integer>();
		for(int i=0;i<N;i++) {
			if (i<start || i>end) {
				map.put(i,alist.get(i));
			}
		}
		boolean status=false;
		for (Map.Entry<Integer, Integer> entry:map.entrySet()) {
			if(clist.contains(entry.getValue())) {
				status=true;
				clist.remove(clist.indexOf(entry.getValue()));
			}else {
				status=false;
			}
		}
		
		System.out.println(status);
		System.err.println(start+" :"+end);
		
		return status==false ? "No":"Yes";
	}	
}
