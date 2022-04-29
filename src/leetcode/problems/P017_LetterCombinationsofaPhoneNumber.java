package leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class P017_LetterCombinationsofaPhoneNumber {
	public static List<String> letterCombinations(String digits) {
		String[][] nums = { { "\0" }, { "a", "b", "c" }, { "d", "e", "f" }, { "g", "h", "i" }, { "j", "k", "l" },
				{ "m", "n", "o" }, { "p", "q", "r", "s" }, { "t", "u", "v" }, { "w", "x", "y", "z" } };
		String[] st= digits.split("");
		List<String[]> list = new ArrayList<String[]>();
		List<String> res= new ArrayList<String>();
		if(digits ==null || digits.equals("")) return res;
		
		for(int i=0;i<st.length;i++) {
			list.add(nums[Integer.parseInt(st[i])-1]);
		}
		int n=list.size();
		if(n==1) {
			res.addAll(Arrays.stream(list.get(0)).collect(Collectors.toList()));
			return res;
		}		
		while (n>=2) {
			String[] c1=list.get(0);
			String[] c2=list.get(1);
			for(String c3:c1) {
				for (String c4:c2) {					
					res.add(c3+""+c4);
				}
			}
			list.remove(0);
			list.add(0,res.stream().map(i->i).toArray(String[]::new));
			list.remove(1);
			n--;
		}
		res=res.stream().filter(i->i.length()==digits.length()).collect(Collectors.toList());
		return res;

	}

	public static void main(String[] args) {
		System.out.println(letterCombinations(""));
		System.out.println(letterCombinations("2"));
		System.out.println(letterCombinations("23"));
		System.out.println(letterCombinations("234").size()+""+letterCombinations("234"));

	}

}
