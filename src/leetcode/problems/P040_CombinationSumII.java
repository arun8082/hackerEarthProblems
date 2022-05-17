package leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P040_CombinationSumII {
	public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
		Arrays.sort(candidates);
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> l = new ArrayList<>();

		combination(candidates, 0, target, l, res);

		return res;
	}

	static void combination(int[] candidates, int start, int target, List<Integer> l, List<List<Integer>> res) {		
		if (target == 0) {
			res.add(new ArrayList<>(l));
			return;
		} else if (start > candidates.length || target < 0) {
			return;
		}
		
		for (int i = start; i < candidates.length; i++) {
			if(i>start && candidates[i]==candidates[i-1]) continue;
			l.add(candidates[i]);
			combination(Arrays.copyOfRange(candidates, i+1,candidates.length), start, target - candidates[i], l, res);
			l.remove(l.size() - 1);
		}
	}

	public static void main(String[] args) {
		System.out.println(combinationSum2(new int[] { 10, 1, 2, 7, 6, 1, 5 }, 8));
		System.out.println(combinationSum2(new int[] { 2,5,2,1,2 }, 5));
	}

}
