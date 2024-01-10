package leetcode.problems;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class P047_PermutationsII {
	public static List<List<Integer>> permuteUnique(int[] nums) {
		Set<List<Integer>> res = new HashSet<List<Integer>>();
        if(nums==null || nums.length==0 )
			return res.stream().toList();
		permute(nums, 0, res);
		return res.stream().toList();
	}
	
	 static void permute(int[] nums,int start, Set<List<Integer>> res) {
		//base case
		if(start>=nums.length) {
			res.add(Arrays.stream(nums).boxed().toList());
			return;
		}
		for(int i=start;i<nums.length;i++) {
			swap(nums, start, i);
			permute(nums, start+1, res);
			swap(nums, start, i);
		}		
		
	}

	static void swap(int[] arr, int i, int j) {
		int t = arr[i];
		arr[i] = arr[j];
		arr[j] = t;
	}

	public static void main(String[] args) {
		System.out.println(permuteUnique(new int[] { 1, 2, 3 }));
		System.out.println(permuteUnique(new int[] { 1, 1, 2 }));
	}

}
