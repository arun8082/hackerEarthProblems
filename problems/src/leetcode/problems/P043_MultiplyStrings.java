package leetcode.problems;

public class P043_MultiplyStrings {
	public static String multiply(String num1, String num2) {
		Long res = 0l;
		if (num1 == "0" || num2 == "0") {
			return "0";
		} else if (num1 == "1")
			return num2;
		else if (num2 == "1")
			return num1;
		else if (num1.length() < num2.length()) {
			String t = num1;
			num1 = num2;
			num2 = t;
		}

		for (int i = num1.length() - 1; i >= 0; i--) {
			int n1 = num1.charAt(i) - '0';
			String m = "";
			int carry = 0;
			for (int j = num2.length() - 1; j >= 0; j--) {
				int n2 = num2.charAt(j) - '0';
				int mul = n1 * n2;
				m = ((carry + mul) % 10) + m;
				carry = (carry + mul) / 10;
				System.out.println(n1 + "," + n2 + ":" + mul + ":" + m + ":" + carry + "::");
			}
			if (carry != 0) {
				m = carry + m;
			}
			// Add 0
			for (int k = 0; k < num1.length() - i - 1; k++) {
				m += "0";
			}

			System.out.println(n1 + "," + m + ":" + carry);
			res += Long.parseLong(m);
		}
		return res.toString();
	}

	public static void main(String[] args) {
//		System.out.println(multiply("2", "3"));
//		System.out.println(multiply("12", "3"));
//		System.out.println(multiply("12000", "3"));
//		System.out.println(multiply("123", "456"));
//		System.out.println(multiply("9", "9"));
//		System.out.println(multiply("123456789", "987654321"));
		System.out.println(multiply("498828660196", "840477629533"));

	}

}
