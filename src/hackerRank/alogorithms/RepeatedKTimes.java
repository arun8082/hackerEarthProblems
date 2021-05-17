package hackerRank.alogorithms;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class RepeatedKTimes {

	public static void main(String[] args) {
		int[] A = { 2, 2, 1, 3, 1, 3, 3, 3, 5 };
		int N = A.length;
		int K = 1;
		int result = findSmallestRepeatedKTImes(N, A, K);
		System.out.println(result);
	}

	private static int findSmallestRepeatedKTImes(int n, int[] a, int k) {
		List<Integer> list = Arrays.stream(a).boxed().collect(Collectors.toList());
		Set<Integer> set = new HashSet<Integer>(list);
		Map<Integer, Long> freqMap = list.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		freqMap.entrySet().forEach(e -> System.out.println(e.getKey() + "==>" + e.getValue()));
		int result =0;
		for (Integer uniqueValue : set) {
			if (freqMap.get(uniqueValue) == k) {
				result= uniqueValue;
				break;
			}
		}
		return result;
	}
}
