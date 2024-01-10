package leetcode.problems;

public class P012_IntegertoRoman {
	public static String intToRoman(int num) {
		String[] M = { "", "M", "MM", "MMM" };
		String[] C = { "", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM" };
		String[] X = { "", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC" };
		String[] I = { "", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX" };

		if (num < 10) {
			return I[num % 10];
		} else if (num < 100) {
			return X[(num % 100) / 10] + I[num % 10];
		} else if (num < 1000) {
			return C[(num % 1000) / 100] + X[(num % 100) / 10] + I[num % 10];
		} else {
			return M[num / 1000] + C[(num % 1000) / 100] + X[(num % 100) / 10] + I[num % 10];
		}
	}

	public static void main(String[] args) {
		System.out.println(intToRoman(3));

	}

}
