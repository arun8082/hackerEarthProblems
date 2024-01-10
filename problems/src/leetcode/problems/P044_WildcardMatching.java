package leetcode.problems;

import java.util.regex.Pattern;

public class P044_WildcardMatching {
	public static boolean isMatch(String s, String p) {
		if (p.startsWith("*") || p.startsWith("?")) {
			p = "." + p;
		}
		Pattern pa = Pattern.compile(p);
		return Pattern.matches(p,s);

	}

	public static void main(String[] args) {
		System.out.println(isMatch("aa", "a"));
		System.out.println(isMatch("aa", "*"));
		System.out.println(isMatch("cb", "?a"));
		System.out.println(isMatch("aab", "c*a*b"));

	}

}
