package leetcode.problems;

import java.util.Arrays;

public class P026_RemoveDuplicatesfromSortedArray {
	public static int removeDuplicates(int[] nums) {
		int i = 0;
		int j = i + 1;
		int count = 0;
		for (; i < nums.length; i = j) {
			j = i + 1;
			while (j < nums.length && nums[i] == nums[j]) {
				nums[j++] = Integer.MAX_VALUE;
			}
			count++;
		}
		Arrays.sort(nums);
		System.out.println(Arrays.toString(nums));
		return count;
	}

	public static int removeDuplicates1(int[] nums) {
		int count = 1;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] != nums[i - 1]) {
				nums[count++] = nums[i];
			}
		}
		System.out.println(Arrays.toString(nums));
		return count;
	}

	public static void main(String[] args) {
		System.out.println(removeDuplicates1(new int[] { 1, 1, 2 }));
		System.out.println(removeDuplicates1(new int[] { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 }));
	}

}
