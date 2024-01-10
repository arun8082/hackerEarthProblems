package leetcode.problems;

public class P028_ImplementstrStr {
	public static int strStr(String haystack, String needle) {
		if(needle==null || needle=="") return 0;
		return haystack.indexOf(needle);
	}

	public static void main(String[] args) {
		System.out.println(strStr("hello", "ll"));
	}

}
