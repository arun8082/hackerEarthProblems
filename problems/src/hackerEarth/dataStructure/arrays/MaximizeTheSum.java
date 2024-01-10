package hackerEarth.dataStructure.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import org.apache.commons.lang3.time.StopWatch;

public class MaximizeTheSum {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StopWatch sw = new StopWatch();
		sw.start();
		int T = 2;//sc.nextInt();
		int N = 4;//sc.nextItn();
		int K = 4;//sc.nextInt();
		List<Long> list = new ArrayList<>();
//		for(int i=0;i<N;i++) {
//			//list.add(sc.nextLong());
//		}
		
//		list = Arrays.asList(new Long[] {3l ,-1l ,2l ,5l});
//		list = Arrays.asList(new Long[] {2l ,1l ,2l ,5l});
		list = Arrays.asList(new Long[] {5l, 5l, 10l, 8l, -1l, 16l, -3l ,14l ,-10l ,-10l});
		System.out.println(maximumSum2(list,N,K));
		sw.stop();
		System.out.println("TIme:"+sw.getNanoTime());
		sc.close();
	}

	private static long maximumSum(List<Long> list, int n, int k) {
		long sum = 0;
		Collections.sort(list,Collections.reverseOrder());
		
		if(k==1) {
			sum = list.get(0);
		}else {
			Long[] set = new TreeSet<>(list).descendingSet().toArray(new Long[1]);
			for(int i=0;i<k;i++) {
				Long current = set[i];
				int freq = Collections.frequency(list, current);
				if(freq==1) {
					sum +=current;
				}else {
					sum +=current*freq;
				}
			}
		}
		return sum;
	}

	
	private static long maximumSum2(List<Long> list, int n, int k) {
		Long sum =0l;
		Set<Long> set = new TreeSet<>(list);
		List<Long> res = new ArrayList<>();
		for(Long i : set) {
			res.add(i);
		}
		Collections.sort(res,Collections.reverseOrder());
		for(int i=0;i<k;i++) {
			sum +=res.get(i);
		}
		return sum;
	}
}
