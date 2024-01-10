package leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class P022_GenerateParentheses {
	static Stack<String> stack = new Stack<String>();
	
	public static List<String> generateParenthesis(int n) {
		List<String> res = new ArrayList<String>();
		makeCombinations(0, 0, n,res);
		return res;
	}

	public static void makeCombinations(int countO, int countC, int length,List<String> res) {
		if (countO == length && countC == length) {
			String s = Arrays.stream(stack.toArray()).map(i -> i + "").collect(Collectors.joining(""));
			res.add(s);
			return;
		}
		if (countO < length) {
			stack.add("(");
			makeCombinations(countO + 1, countC, length,res);
			stack.pop();
		}
		if (countC < countO) {
			stack.add(")");
			makeCombinations(countO, countC + 1, length,res);
			stack.pop();
		}
	}

	public static void main(String[] args) {
		System.out.println(generateParenthesis(2));
		System.out.println(generateParenthesis(3));
	}

}
