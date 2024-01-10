package leetcode.problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class P034_FindFirstandLastPositionofElementinSortedArray {
	public static int[] searchRange(int[] nums, int target) {
		int[] res = new int[] { -1, -1 };
		int i=0,j=nums.length-1;
		if(nums.length==1&& nums[0]==target) {
			return new int[] {0,0};
		}
		while(i<j) {
			if(nums[i]==target && res[0]==-1) {
				res[0]=i;
			}
			if(nums[j]==target && res[1]==-1) {
				res[1]=j;
			}else if (nums[j]==target && res[1]!=-1 && res[0]!=-1) {
				res[0]=j;
			}
			i++;j--;
		}
		if(res[1]==-1 && res[0]!=-1) {
			res[1]=res[0];
		}else if(res[0]==-1 && res[1]!=-1){
            res[0]=res[1];
        }
		return res;
	}
	public static int[] searchRange2(int[] nums, int target) {
		int[] res = new int[] { -1, -1 };
		for(int i=0;i<nums.length;i++) {
			if(nums[i]==target && res[0]==-1) {
				res[0]=i;
				res[1]=i;
			}else if(nums[i]==target) {
				res[1]=i;
			}
		}
		return res;

	}

	public static int[] searchRange1(int[] nums, int target) {
		Map<Integer, int[]> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			Integer c = nums[i];
			if (map.containsKey(c)) {
				map.get(c)[1] = i;
			} else {
				map.put(c, new int[] { i, i });
			}
		}
		if (map.containsKey(target)) {
			return map.get(target);
		}
		return new int[] { -1, -1 };

	}

	public static void main(String[] args) {
//		System.out.println(Arrays.toString(searchRange(new int[] { 5, 7, 7, 8, 8, 10 }, 8)));
//		System.out.println(Arrays.toString(searchRange(new int[] { 1 }, 1)));
//		System.out.println(Arrays.toString(searchRange(new int[] { 3,3,3 }, 3)));
		System.out.println(Arrays.toString(searchRange(new int[] { 1,2,3 }, 2)));
	}

}
