package leetcode.problems;

public class P058_LengthofLastWord {
	public static int lengthOfLastWord(String s) {
		String[] sp = s.trim().split(" ");
		return sp[sp.length - 1].length();
	}
	public static int lengthOfLastWord2(String s) {
		s=s.trim();
		int count=0; 
		for(int i=s.length()-1;i>=0;i--) {
			if(s.charAt(i)==' ') {
				break;
			}
			count++;
		}
		return count;
	}

	public static void main(String[] args) {
		System.out.println(lengthOfLastWord2("a"));
//		System.out.println(lengthOfLastWord2("   fly me   to   the moon  "));

	}

}
