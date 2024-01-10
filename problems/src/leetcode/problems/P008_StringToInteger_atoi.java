package leetcode.problems;

import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

//https://redquark.org/leetcode/0008-string-to-integer-atoi/
public class P008_StringToInteger_atoi {
	static int myAtoi(String s) {
		Pattern pattern = Pattern.compile("[-0-9.0-9]+"); 
		Matcher match= pattern.matcher(s);
		if(Pattern.compile("^[.a-zA-Z|{+-}|{-+}]").matcher(s.trim()).find()) {
			return 0;
		}
		List<String> list=match.results().map(MatchResult::group).collect(Collectors.toList());
		if(list.size()==0) {
			return 0;
		}
		Double r =Double.parseDouble(list.get(0));
		
		return r<Integer.MIN_VALUE?Integer.MIN_VALUE:r>Integer.MAX_VALUE?Integer.MAX_VALUE:r.intValue();
	}

	public static void main(String[] args) {
		System.out.println(myAtoi("-4193 with words"));
		System.out.println(myAtoi(" with words"));
		System.out.println(myAtoi("words and 987"));
		System.out.println(myAtoi("-91283472332"));
		System.out.println(myAtoi(".1"));
		System.out.println(myAtoi("3.14159"));
		System.out.println(myAtoi("+-12"));
		System.out.println(myAtoi("   -42"));

	}

}
