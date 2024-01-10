package leetcode.problems;

public class P033_SearchinRotatedSortedArray {
	public static int search(int[] nums, int target) {
		if(nums.length==1) {
			return nums[0]==target?0:-1;
		}
		int res=-1;
		int pivot =-1;
		for(int i=0;i<nums.length-1;i++) {
			if(nums[i]>nums[i+1]) {
				pivot=i;
			}
		}
//		System.err.println("p:"+pivot);
		if(pivot==-1) {
			int i=0;
			while(i<nums.length&&target >=nums[i]) {
				if(target==nums[i])
					res=i;
				i++;
			}			
		}else {
			if(nums[pivot]<target || nums[0]<=target ) {
				for(int i=0;i<=pivot;i++) {
					if(nums[i]==target)
						res=i;
				}
			}else {
				for(int i=pivot;i<nums.length;i++) {
					if(nums[i]==target)
						res=i;
				}
			}
		}
		return res;
	}

	public static void main(String[] args) {
		System.out.println(search(new int[] {4,5,6,7,0,1,2}, 0));
		System.out.println(search(new int[] {4,5,6,7,0,1,2}, 3));
		System.out.println(search(new int[] {1}, 0));
		System.out.println(search(new int[] {1,3}, 3));
		System.out.println(search(new int[] {3,5,1}, 3));

	}

}
