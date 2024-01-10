package leetcode.problems;

import java.util.Set;
import java.util.stream.Collectors;

public class P003_LongestSubstringWithoutRepeatingCharacters {
	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring2("abcabcbb"));
//		System.out.println(lengthOfLongestSubstring2("ntgnrzumltoefnkpdhbiptzgzdhgqmighqtzpnnchbgmqrduaeesaeybjiiawqgdgbcxorzxuillbrhdxlvx"));
	}

	public static int lengthOfLongestSubstring(String s) {
		String res = "";
		for (int i = 0; i < s.length(); i++) {
			for (int j = i + 1; j <= s.length(); j++) {
				String substr = s.substring(i, j);
//				Map<Character,Long> map=substr.chars().mapToObj(k->(char)k).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
//				List<Map.Entry<Character, Long>> list= map.entrySet().stream().filter(e->e.getValue()!=1).collect(Collectors.toList());
				Set<Character> set = substr.chars().mapToObj(k -> (char) k).collect(Collectors.toSet());
				if (set.size() == substr.length()) {
					if (substr.length() > res.length())
						res = substr;
				}
			}
		}
		return res.length();
	}

	public static int lengthOfLongestSubstring2(String s) {
		String test = "";
		int maxLength = -1;
		String res="";
		for (Character c : s.toCharArray()) {
			String current = c.toString();
			System.out.format("test:%s   current:%s\n", test,current);
			if (test.contains(current)) {
				test = test.substring(test.indexOf(current) + 1);
			}
			test = test + current;
//			maxLength = Math.max(test.length(), maxLength);
			if(test.length()>maxLength) {
				res=test;
				maxLength=test.length();
			}
		}
		System.out.println("oit::"+res);
		return maxLength;
	}

}
