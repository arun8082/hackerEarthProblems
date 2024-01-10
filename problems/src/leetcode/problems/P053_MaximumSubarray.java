package leetcode.problems;

import java.util.Arrays;

public class P053_MaximumSubarray {
	public static int maxSubArray(int[] nums) {
		int res = Integer.MIN_VALUE;
		int n = nums.length;
		if (n == 1)
			return nums[0];
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				int[] s = Arrays.copyOfRange(nums, i, j + 1);
//				System.out.println(Arrays.toString(s));
				int sum = Arrays.stream(s).sum();
				res = Math.max(res, sum);
			}
		}

		return res;
	}

	public static int maxSubArray2(int[] nums) {
		int max_Sum = Integer.MIN_VALUE;
		int sum = 0;
		for (int x : nums) {
			sum += x; // Calculating the Prefix Sum
			max_Sum=Math.max(max_Sum, sum);
			if (sum < 0)
				sum = 0;
		}
		return max_Sum;
	}

	public static void main(String[] args) {
		System.out.println(maxSubArray(new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 }));
		System.out.println(maxSubArray(new int[] { 1 }));
	}

}
