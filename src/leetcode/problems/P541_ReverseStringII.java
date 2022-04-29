package leetcode.problems;

public class P541_ReverseStringII {
	public static void main(String[] args) {
		System.out.println(reverseStr("abcdefg", 2));
	}

	public static String reverseStr(String s, int k) {
		String res = "";
		int n = s.length();
		int i = 0;

		for (; i + (2 * k) < n; i = i + (2 * k)) {
			res += reverse(s.substring(i, i + (2 * k)), k);
		}
		res += reverse(s.substring(i), k);

		return res;
	}

	static String reverse(String s, int k) {
		int n = s.length();
		if (n < k) {
			return new StringBuilder(s).reverse().toString();
		} else if (n >= k && n <= 2 * k) {
			return new StringBuilder(s.substring(0, k)).reverse().toString() + s.substring(k);
		} else {
			return s;
		}

	}
}
