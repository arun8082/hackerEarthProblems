package leetcode.problems;

import java.util.Arrays;

public class P027_RemoveElement {
	public static int removeElement(int[] nums, int val) {
		if (nums == null || (nums != null && nums.length == 0))
			return 0;
		int count = (int) Arrays.stream(nums).boxed().filter(i -> i != val).count();
		if (nums.length == 1 && nums[0] != val)
			return 1;
		int j = nums.length - 1;
		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i] == val && j > i) {
				int t = nums[i];
				while (nums[j] == val && j > i) {
					j--;
				}
				nums[i] = nums[j];
				nums[j] = t;
			}
		}
		System.out.println(Arrays.toString(nums));
		return count;

	}

	public static void main(String[] args) {
		System.out.println(removeElement(new int[] { 3, 2, 2, 3 }, 3));
		System.out.println(removeElement(new int[] { 0, 1, 2, 2, 3, 0, 4, 2 }, 2));
		System.out.println(removeElement(new int[] { 2 }, 3));
		System.out.println(removeElement(new int[] { 3, 3 }, 5));

	}

}
