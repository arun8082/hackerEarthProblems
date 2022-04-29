package leetcode.problems;

import java.util.regex.Pattern;

public class P010_RegularExpressionMatching {
	public static boolean isMatch(String s, String p) {
		Pattern c= Pattern.compile(p);
		System.out.println(c.matcher(s).matches());
		return Pattern.matches(p, s);
	}

	public static void main(String[] args) {
		System.out.println(isMatch("aa", "a"));
		System.out.println(isMatch("aa", "a*"));
		System.out.println(isMatch("ab", ".*"));
	}

}
