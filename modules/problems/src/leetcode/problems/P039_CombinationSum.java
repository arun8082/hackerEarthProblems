package leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class P039_CombinationSum {

	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> l = new ArrayList<Integer>();
		combination(candidates, 0, target, l, res);
		return res;
	}

	static void combination(int[] candidates, int start, int target, List<Integer> l, List<List<Integer>> res) {
		if (start > candidates.length || 0 > target)
			return;
		if (0 == target) {
			res.add(new ArrayList<>(l));
			return;
		}
		for (int i = start; i < candidates.length; i++) {
			l.add(candidates[i]);
			combination(candidates, i, target-candidates[i], l, res);
			l.remove(l.size()-1);
		}
	}

	public static void main(String[] args) {
		System.out.println(combinationSum(new int[] { 2, 3, 5 }, 8));
		System.out.println(combinationSum(new int[] {  }, 8));
		System.out.println(combinationSum(new int[] { 2, 3, 6, 7 }, 7));

	}

}
