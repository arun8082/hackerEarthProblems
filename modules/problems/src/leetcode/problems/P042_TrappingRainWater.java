package leetcode.problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P042_TrappingRainWater {

	public static int trap2(int[] height) {
		int max =0;
		int maxLeft=height[0];
		
		int n =height.length;
		int maxRight=height[n-1];
		int i=0;
		int j=n-1;
		
		while(i<j) {
			int m = Math.max(maxLeft, height[i]);
			if(maxLeft<maxRight) {
				i++;
				maxLeft = Math.max(maxLeft, height[i]);
				max+=maxLeft-height[i];
			}else {
				j--;
				maxRight = Math.max(maxRight, height[j]);
				max+=maxRight-height[j];
			}
		}
		return max;
		
	}

	public static int trap(int[] height) {
		int maxleft = 0;
		int maxRight = 0;
		int n = height.length;
		int max = 0;
		List<Integer> left = new ArrayList<Integer>();
		List<Integer> right = new ArrayList<Integer>();

		for (int i = 0; i < n; i++) {
			left.add(maxleft);
			maxleft = Math.max(maxleft, height[i]);

			right.add(maxRight);
			maxRight = Math.max(maxRight, height[n - i - 1]);
		}
		Collections.reverse(right);

		for (int i = 0; i < n; i++) {
			int d = Math.min(right.get(i), left.get(i)) - height[i];
			if (d > 0) {
				max += d;
			}
		}

		return max;

	}

	public static void main(String[] args) {
		System.out.println(trap2(new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 }));
		System.out.println(trap2(new int[] { 4, 2, 0, 3, 2, 5 }));
	}

}
