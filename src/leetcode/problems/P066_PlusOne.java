package leetcode.problems;

import java.util.Arrays;
import java.util.stream.Collectors;

public class P066_PlusOne {
	public static int[] plusOne(int[] digits) {
		int n = digits.length;
		if (digits[n - 1] < 9) {
			digits[n - 1] = digits[n - 1] + 1;
		} else {
			int rem = 0;
			int d = 0;
			int i = n - 1;
			do {
				if (i == n - 1) {
					int s = digits[i] + 1;
					rem = s % 10;
					d = s / 10;
					digits[i] = rem;
				}
				else if (d != 0) {
					int s = digits[i] + d;
					rem = s % 10;
					d = s / 10;
					digits[i] = rem;
				} else {
					digits[i] = digits[i];
				}
				i--;
			} while (i >= 0 && d != 0);
			if(d!=0) {
				int []res = new int[n+1];
				System.arraycopy(digits, 0, res, 1, n);
				res[0]=d;
				digits=res;
			}
		}

		System.out.println(Arrays.toString(digits));
		return digits;
	}

	public static int[] plusOne2(int[] digits) {
		String s = Arrays.stream(digits).boxed().map(i -> i.toString()).collect(Collectors.joining(""));
		Long l = Long.parseLong(s) + 1;
		int[] d = Arrays.stream(l.toString().split("")).mapToInt(i -> Integer.parseInt(i)).toArray();
//		System.out.println(Arrays.toString(d));
		return d;
	}

	public static void main(String[] args) {
		System.out.println(plusOne(new int[] { 1, 2, 3 }));
		System.out.println(plusOne(new int[] { 9 }));
		System.out.println(plusOne(new int[] { 1, 9, 9 }));
		System.out.println(plusOne(new int[] { 7, 8, 1, 9, 9 }));
	}

}
