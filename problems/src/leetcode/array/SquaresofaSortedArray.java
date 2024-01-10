package leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class SquaresofaSortedArray {

	public static void main(String[] args) {
		int []nums = {-4,-1,0,3,10};
		int []re = sortedSquares(nums);
		System.out.println(re);
	}
	
	public static int[] sortedSquares(int[] nums) {
        List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < nums.length; i++) {
			list.add(nums[i]*nums[i]);
		}
		Collections.sort(list);
		return list.stream().mapToInt(i->i).toArray();        
    }
}
