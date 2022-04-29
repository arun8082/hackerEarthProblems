package leetcode.problems;

public class P007_ReverseInteger {

	public static int reverse2(int x) {
		long sum = 0;
		boolean st = false;
		if (x < 0) {
			x = x * -1;
			st = true;
		}
		while (x > 0) {
			int t = x % 10;
			sum = (10 * sum) + t;
			if (sum < Integer.MIN_VALUE || sum > Integer.MAX_VALUE) {
				return 0;
			}
			x = x / 10;
		}
		return (int) ((st) ? -1 * sum : sum);

	}

	public static int reverse(int x) {
		StringBuilder sb = new StringBuilder(x + "");
		Long l=null;
		if (x < 0) {
			sb.deleteCharAt(0);
			sb.reverse();
			l= Long.parseLong("-" + sb.toString());
		} else {
			sb.reverse();
			l=Long.parseLong(sb.toString());
		}
		return (l<Integer.MIN_VALUE || l>Integer.MAX_VALUE)?0:l.intValue();
	}

	public static void main(String[] args) {
		System.out.println(reverse2(-123));
//		2,147,483,647
		System.out.println(reverse2(1534236469));
	}

}
