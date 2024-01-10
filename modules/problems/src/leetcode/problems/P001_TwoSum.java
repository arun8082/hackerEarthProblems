package leetcode.problems;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class P001_TwoSum {
	public static int[] twoSum(int[] nums, int target) {
		for (int i = 0; i < nums.length; i++) {
			for (int j = i; j < nums.length; j++) {
				if (nums[i] + nums[j] == target) {
					return new int[] { i, j };
				}
			}
		}
		return null;
	}

	public static int[] twoSum1(int[] nums, int target) {
		int i = 0;
		int j = nums.length - 1;
		List<Integer> numss = Arrays.stream(nums).boxed().collect(Collectors.toList());
		Arrays.sort(nums);
		while (i < nums.length && j > 0) {
			int sum = nums[i] + nums[j];
			if (sum == target) {
				int a= numss.indexOf(nums[i]);
				numss.set(a, -1);
				int b= numss.indexOf(nums[j]);
				return new int[] {a,b};
			} else if (sum < target) {
				i++;
			} else {
				j--;
			}
		}
		return null;
	}

	public static void main(String[] args) {
//		int[] res = twoSum1(new int[] { 2, 7, 11, 15 }, 9);
//		int[] res = twoSum1(new int[] { 3,2,4 }, 6);
		int[] res = twoSum1(new int[] { 3,3 }, 6);
		System.out.println(Arrays.toString(res));
	}

}
