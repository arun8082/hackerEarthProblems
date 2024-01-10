package leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class P004_MedianofTwoSortedArrays {
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		List<Integer> list = new ArrayList(Arrays.stream(nums1).boxed().toList());
		list.addAll(Arrays.stream(nums2).boxed().toList());
		Collections.sort(list);
		int n= list.size();
		double median = n%2==0?(list.get(n/2)+list.get(n/2-1))/2.0:list.get((n+1)/2-1);
		return median;
	}
	
	public static double findMedianSortedArrays2(int[] nums1, int[] nums2) {
		int[] nums3= new int[nums1.length+nums2.length];
		System.arraycopy(nums1, 0, nums3, 0, nums1.length);
		System.arraycopy(nums2, 0, nums3, nums1.length, nums2.length);
		Arrays.sort(nums3);
		int n= nums3.length;
		double median = n%2==0?(nums3[n/2]+nums3[n/2-1])/2.0:nums3[(n+1)/2-1];
		return median;
	}
	

	public static void main(String[] args) {
		int[] nums1= new int[] {1,3};
		int[] nums2= new int[] {2,4};
		
		System.out.println(findMedianSortedArrays2(nums1,nums2));

	}

}
