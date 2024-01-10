package leetcode.problems;

public class P011_ContainerWithMostWater {
	public static int maxArea(int[] height) {
		int max = 0;
		int n = height.length;
		int i = 0, j = n - 1;
		while (i < j) {
			max = Math.max(max,(j - i) * Math.min(height[i], height[j]));
			System.out.println(i+":"+j+":"+max);
			if (height[i] < height[j]) {
				i++;
			} else {
				j--;
			}
		}
		return max;
	}

	public static void main(String[] args) {
		System.out.println(maxArea(new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7 }));

	}

}
