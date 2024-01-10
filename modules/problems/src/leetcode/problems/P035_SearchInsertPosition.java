package leetcode.problems;

public class P035_SearchInsertPosition {
	public static int searchInsert(int[] nums, int target) {
		int pos=-1;
		for(int i=0;i<nums.length;i++) {
			if(nums[i]==target|| nums[i]>target) {
				pos=i;
				break;
			}
		}
		if(pos==-1) {
			pos=nums.length;
		}
		return pos;
	}

	public static void main(String[] args) {
		System.out.println(searchInsert(new int[] { 1, 3, 5, 6 }, 5));
		System.out.println(searchInsert(new int[] { 1, 3, 5, 6 }, 2));
		System.out.println(searchInsert(new int[] { 1, 3, 5, 6 }, 7));

	}

}
