package leetcode.problems;

import java.util.Arrays;
import java.util.stream.Collectors;

public class P557_ReverseWordsInAStringIII {
	public static void main(String[] args) {
		System.out.println(reverseWords("Let's take LeetCode contest"));
	}

	public static String reverseWords(String s) {
		return Arrays.stream(s.split(" ")).map(i->new StringBuilder(i).reverse().toString()).collect(Collectors.joining(" "));
	}

}
