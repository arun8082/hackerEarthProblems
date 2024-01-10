package leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P018_4Sum {
	public static List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		Arrays.sort(nums);
		int n = nums.length;
		for (int i = 0; i < n; i++) {
			if (i > 0 && nums[i] == nums[i - 1])
				continue;
			for (int j = i + 1; j < n; j++) {
				if (i == j && nums[j] == nums[j - 1])
					continue;
				int k = j + 1;
				int l = n - 1;
				while (k < l) {
					int sum = nums[i] + nums[j] + nums[k] + nums[l];
					if (sum < target) {
						k++;
					} else if (sum > target) {
						l--;
					} else {
						if (!res.contains(List.of(nums[i], nums[j], nums[k], nums[l])))
							res.add(List.of(nums[i], nums[j], nums[k], nums[l]));
						k++;
					}
				}
			}
		}

		return res;
	}

	public static void main(String[] args) {
		System.out.println(fourSum(new int[] { 1, 0, -1, 0, -2, 2 }, 0));
		System.out.println(fourSum(new int[] { 2, 2, 2, 2, 2 }, 8));
		System.out.println(fourSum(new int[] { -7, -5, 0, 7, 1, 1, -10, -2, 7, 7, -2, -6, 0, -10, -5, 7, -8, 5 }, 28));
	}

}
