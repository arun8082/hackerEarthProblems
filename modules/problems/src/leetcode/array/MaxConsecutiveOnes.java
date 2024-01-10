package leetcode.array;

import java.util.ArrayList;
import java.util.List;

public class MaxConsecutiveOnes {

	public static void main(String[] args) {
		int[] nums = { 1, 1, 0, 1, 1, 1,0,1,1,1,1,1,0,0,0 };
		System.out.println(findMaxConsecutiveOnes(nums));
	}

	public static int findMaxConsecutiveOnes(int[] nums) {
		int count = 0;
		int i=0;
		int max_count =0;
		while(i<nums.length) {
			if(nums[i]==0) {
				if(max_count<count) {
					max_count=count;
				}
				count=0;
			}else {
				count++;
			}
			i++;
		}
		if(max_count<count) {
			max_count=count;
		}
		return max_count;
	}
}
