package leetcode.problems;

import java.util.List;
import java.util.Stack;

public class P020_ValidParentheses {
	public static boolean isValid(String s) {
		Stack<String> stack = new Stack<>();
		String[] st = s.split("");
		for (String in : st) {
			String p = (!stack.isEmpty()) ? stack.peek() : "";
			if (in.equals("(") || in.equals("{") || in.equals("[")) {
				stack.add(in);
			} else if ((p.equals("(") && in.equals(")")) || (p.equals("{") && in.equals("}"))
					|| (p.equals("[") && in.equals("]"))) {
				stack.pop();
			} else {
				stack.add(in);
			}
		}
		return stack.isEmpty();
	}

	public static boolean isValid2(String s) {
		Stack<Character> stack = new Stack<>();
		for (char in : s.toCharArray()) {
			char p = (!stack.isEmpty()) ? stack.peek() : '\0';
			if (in == '(' || in == '{' || in == '[') {
				stack.add(in);
			} else if ((p == '(' && in == ')') || (p == '{' && in == '}') || (p == '[' && in == ']')) {
				stack.pop();
			} else {
				stack.add(in);
			}
		}
		return stack.isEmpty();
	}

	public static void main(String[] args) {
		System.out.println(isValid2("()"));
		System.out.println(isValid2("()[]{}"));
		System.out.println(isValid2("(]"));
	}

}
