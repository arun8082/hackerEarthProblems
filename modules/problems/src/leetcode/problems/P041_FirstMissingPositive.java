package leetcode.problems;

import java.lang.reflect.Array;
import java.util.Arrays;

public class P041_FirstMissingPositive {
	public static int firstMissingPositive(int[] nums) {
		int res = -1;
		Arrays.sort(nums);
		int l = Arrays.stream(nums).filter(i -> i == 1).toArray().length;
		nums =Arrays.stream(nums).filter(i->i>0).toArray();
		if (l == 0) {
			res = 1;
			return res;
		}
		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i + 1] - nums[i] != 1 && nums[i + 1] - nums[i]>0) {
				System.out.println(nums[i]+":"+nums[i + 1]);
				res = Math.min(nums[i], nums[i + 1]) + 1;
				if (res != 0)
					break;
			}
		}
		if (res == -1) {
			res = nums[nums.length - 1] + 1;
		}
		return res;
	}

	public static void main(String[] args) {
		System.out.println(firstMissingPositive(new int[] { 1, 2, 0 }));
		System.out.println(firstMissingPositive(new int[] { 3, 4, -1, 1 }));
		System.out.println(firstMissingPositive(new int[] { 7, 8, 9, 11, 12 }));
		System.out.println(firstMissingPositive(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 23, 20 }));
		System.out.println(firstMissingPositive(new int[] { 0,2,2,1,1 }));
		System.out.println(firstMissingPositive(new int[] { -10,-3,-100,-1000,-239,1}));
		

	}

}
