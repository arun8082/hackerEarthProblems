package leetcode.problems;

import java.util.Stack;

public class P032_LongestValidParentheses {
	public static int longestValidParentheses3(String s) {
		Stack<Integer> stack= new Stack<Integer>();
		stack.add(-1);
		int n = s.length();
		int max = 0;
		for(int i=0;i<n;i++) {
			Character c =s.charAt(i);
			if(c=='(') {
				stack.push(i);
			}else {
				stack.pop();
				if(stack.isEmpty()) {
					stack.add(i);
				}else {
					max = Math.max(max, i-stack.peek());
				}
			}
		}
		return max;
	}
	
	public static int longestValidParentheses2(String s) {
		int res = 0;
		if (s == null || s.length() == 0)
			return res;
		int n = s.length();
		for (int i = 0; i < n; i++) {
			for (int j = n; j > i; j--) {
				if (isValid2(s,i,j)) {
					res = Math.max(res, j-i);
				}
//				System.out.println("-----" + substr + ":" + isValid(substr));
			}
		}
		return res;
	}
	
	static boolean isValid2(String s,int start,int end) {
		boolean status = false;
		Stack<Character> stack = new Stack<Character>();
		for (int i = start; i <end; i++) {
			Character c = s.charAt(i);
			Character peek = stack.isEmpty() ? '\0' : stack.peek();
			if (c == '(') {
				stack.add(c);
			} else if (peek == '(' && c == ')') {
				stack.pop();
			} else {
				stack.add(c);
			}

//			System.out.println(Arrays.toString(stack.toArray()));
		}
		if (stack.isEmpty()) {
			status = true;
		}
		return status;
	}
	
	
	public static int longestValidParentheses(String s) {
		int res = 0;
		if (s == null || s.length() == 0)
			return res;
		int n = s.length();
		for (int i = 0; i < n; i++) {
			for (int j = n; j > i; j--) {
				String substr = s.substring(i,j);
				if (isValid(substr)) {
					res = Math.max(res, substr.length());
				}
//				System.out.println("-----" + substr + ":" + isValid(substr));
			}
		}
		return res;
	}

	static boolean isValid(String s) {
		boolean status = false;
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < s.length(); i++) {
			Character c = s.charAt(i);
			Character peek = stack.isEmpty() ? '\0' : stack.peek();
			if (c == '(') {
				stack.add(c);
			} else if (peek == '(' && c == ')') {
				stack.pop();
			} else {
				stack.add(c);
			}

//			System.out.println(Arrays.toString(stack.toArray()));
		}
		if (stack.isEmpty()) {
			status = true;
		}
		return status;
	}

	public static void main(String[] args) {
		System.out.println(longestValidParentheses3("(()"));
		System.out.println(longestValidParentheses3(")()())"));

	}

}
