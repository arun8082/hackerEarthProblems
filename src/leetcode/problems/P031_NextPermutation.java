package leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P031_NextPermutation {
	// Brute force
	public static void nextPermutation2(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		int[] n = Arrays.copyOf(nums, nums.length);
		Arrays.sort(n);
		permutation(n, 0, res);
		int index = res.indexOf(Arrays.stream(nums).boxed().toList());
		System.out.println(res);
		System.out.println(res.get(index + 1));
	}

	static void permutation(int[] nums, int start, List<List<Integer>> res) {
		// base cond.
		if (start >= nums.length) {
			res.add(Arrays.stream(nums).boxed().toList());
			return;
		}
		for (int i = start; i < nums.length; i++) {
			swap(start, i, nums);
			permutation(nums, start + 1, res);
			swap(start, i, nums);
		}
	}

	public static void nextPermutation(int[] nums) {
		int n = nums.length;
		if (n == 1)
			return;
		int indx = -1;
		for (int i = n - 1; i > 0; i--) {
			if (nums[i] > nums[i - 1]) {
				indx = i;
				break;
			}
		}

		if (indx == -1) {
			reverese(0, nums);
		} else {
			int indy = indx;
			for (int i = indx + 1; i < n; i++) {
				if (nums[i] > nums[indx - 1] && nums[i] <= nums[indy]) {
					indy = i;
					break;
				}
			}
			System.out.println(indx+":"+indy+":"+Arrays.toString(nums));
			swap(indx - 1, indy, nums);
			System.out.println(indx+":"+indy+":"+Arrays.toString(nums));
			reverese(indx, nums);
		}
		System.out.println(Arrays.toString(nums));
	}

	static void swap(int i, int j, int[] nums) {
		int t = nums[i];
		nums[i] = nums[j];
		nums[j] = t;
	}

	static void reverese(int start, int[] nums) {
		int j = nums.length - 1;
		while (start <= j) {
			int t = nums[start];
			nums[start] = nums[j];
			nums[j] = t;
			start++;
			j--;
		}
	}

	public static void main(String[] args) {
//		nextPermutation2(new int[] { 1, 3, 5, 4, 2 });
//		nextPermutation(new int[] { 1, 2, 3 });
//		nextPermutation(new int[] { 3, 2, 1 });
//		nextPermutation(new int[] { 1,1,5 });
//		nextPermutation(new int[] { 1});
//		nextPermutation(new int[] { 1, 3, 2 });
		nextPermutation(new int[] { 2,2,7,5,4,3,2,2,1 });//[2,3,1,2,2,2,4,5,7]
	}

}
