package leetcode.problems;

public class P009_PalindromeNumber {

	public static boolean isPalindrome(int x) {
		int rev = 0;
		int y = x;
		if (x<0 || (x!=0 && x%10==0)) return false;
		while (y > 0) {
			int rem = y % 10;
			rev = (rev * 10) + rem;
			y = y / 10;
		}
		return rev == x;
	}
	public static boolean isPalindrome2(int x) {
		String str=x+"";
		int n=str.length();
		for(int i=0;i<n/2;i++) {
			if(str.charAt(i)!=str.charAt(n-1-i)) {
				return false;
			}
		}
		return true;
	}
	public static boolean isPalindrome3(int x) {
		StringBuilder str=new StringBuilder(x+"");
		int n=str.length();		
		return str.reverse().toString().equals(x+"");
	}

	public static void main(String[] args) {
		System.out.println(isPalindrome3(121));
		System.out.println(isPalindrome3(123));
	}

}
