package leetcode.problems;

import java.util.Arrays;

public class P016_3SumClosest {
	public static int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);
		int n = nums.length;
		int res = Integer.MAX_VALUE;
		int ans = 0;
		for (int i = 0; i < n - 2; i++) {
			int j = i+1;
			int k = n - 1;
			String str="";
			while (j < k) {
				int sum = nums[i] + nums[j] + nums[k];
				int closet = Math.abs(target - sum);
				if (closet <= res) {
					res = closet;
					ans = sum;
					str = nums[i] + ":" + nums[j] + ":" + nums[k];
				}
				if (sum <= target) {
					j++;
				} else {
					k--;
				}
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		System.err.println(threeSumClosest(new int[] { -1, 2, 1, -4 }, 1));
		System.err.println(threeSumClosest(new int[] { 0, 0, 0 }, 1));
		System.err.println(threeSumClosest(new int[] { 1, 1, -1 }, 0));
		System.err.println(threeSumClosest(new int[] { 1, 1, 1, 1 }, 0));
		System.err.println(threeSumClosest(new int[] { 1, 1, 1, 0 }, -100));
	}

}
