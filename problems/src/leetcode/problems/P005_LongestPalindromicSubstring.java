package leetcode.problems;

public class P005_LongestPalindromicSubstring {
	public static String longestPalindrome(String s) {
		int max = -1;
		String res = "";
		for (int i = 0; i < s.length(); i++) {
			for (int j = i + 1; j <= s.length(); j++) {
				String current = s.substring(i, j);
				System.out.println(current);
				if (isPalindrome2(current) && max < current.length()) {
					max = current.length();
					res = current;
				}
			}
		}
		System.out.println(res + "  " + max);
		return res;
	}

	public static String longestPalindrome2(String str) {
		int n = str.length();
		if (n < 2)
			return str;

		int maxLength = 1, start = 0;
		int low, high;
		for (int i = 0; i < n; i++) {
			low = i - 1;
			high = i + 1;
			while (high < n && str.charAt(high) == str.charAt(i)) // increment 'high'
				high++;

			while (low >= 0 && str.charAt(low) == str.charAt(i)) // decrement 'low'
				low--;

			while (low >= 0 && high < n && str.charAt(low) == str.charAt(high)) {
				low--;
				high++;
			}

			int length = high - low - 1;
			if (maxLength < length) {
				maxLength = length;
				start = low + 1;
			}
		}
		System.out.print("Longest palindrome substring is: ");
		System.out.println(str.substring(start, start + maxLength));
		return str.substring(start, start + maxLength);

	}

	private static boolean isPalindrome2(String test) {
		String revStr = new StringBuilder(test).reverse().toString();
		return test.equals(revStr);
	}

	private static boolean isPalindrome(String test) {
		char[] chars = test.toCharArray();
		int n = chars.length;
		for (int i = 0; i <= n / 2; i++) {
			if (chars[i] != chars[n - 1 - i]) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(longestPalindrome2("babad"));
		System.out.println(longestPalindrome2("cbbd"));
		System.out.println(longestPalindrome2("ac"));

	}

}
