package leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P015_3Sum {
	public static List<List<Integer>> threeSum1(int[] nums) {
		List<List<Integer>> triplet = new ArrayList<List<Integer>>();
		Arrays.sort(nums);
		int n = nums.length;
		for (int i = 0; i < n; i++) {
			if (i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}
			int j = i + 1;
			int k = n - 1;
			while (j < k) {
				if (nums[i] + nums[j] + nums[k] < 0) {
					j++;
				} else if (nums[i] + nums[j] + nums[k] > 0) {
					k--;
				} else {
					triplet.add(List.of(nums[i], nums[j], nums[k]));
					j++;
					while (j < k && nums[j] == nums[j - 1]) {
						j++;
					}
				}
			}
		}
		return triplet;
	}

	public static List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> triplet = new ArrayList<List<Integer>>();
		if (nums.length == 0) {
			return triplet;
		}
		Arrays.sort(nums);
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				for (int k = j + 1; k < nums.length; k++) {
					if ((i != j && j != k && i != k) && (nums[i] + nums[j] + nums[k] == 0)) {
						if(!triplet.contains(List.of(nums[i], nums[j], nums[k]))) {							
							triplet.add(List.of(nums[i], nums[j], nums[k]));
						}
					}
				}
			}
		}
		return triplet;
	}

	public boolean twoSum(int x, int y, int expected) {
		return x + y == expected;

	}

	public static void main(String[] args) {
		System.out.println(threeSum(new int[] { -1, 0, 1, 2, -1, -4 }));

	}

}
