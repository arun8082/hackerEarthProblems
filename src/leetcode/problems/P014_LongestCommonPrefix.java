package leetcode.problems;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class P014_LongestCommonPrefix {
	static String prefix="";
	
	
	
	public static String longestCommonPrefix1(String[] strs) {
		if(strs.length==1) {
			return strs[0];
		}
		List<String> list = Arrays.stream(strs).sorted(Comparator.comparingInt(String::length))
				.collect(Collectors.toList());
		String prefix = list.get(0);
		int nk=prefix.length();
		boolean status=false;
		for (int j = 1; j <= nk; j++) {
			for (int i = 1; i < list.size(); i++) {
				if (!list.get(i).startsWith(prefix)) {
					status=false;
					break;
				}else {
					status=true;
				}
			}
			if(status == true) {
				break;
			}else {
				prefix = prefix.substring(0, nk - j);
			}
		}
		return prefix;
	}
	
	public static String longestCommonPrefix(String[] strs) {
		if(strs.length==1) {
			return strs[0];
		}
		List<String> list = Arrays.stream(strs).sorted(Comparator.comparingInt(String::length))
				.collect(Collectors.toList());		
		prefix = list.get(0);
		int nk=prefix.length();
		for (int j = 1; j <= nk; j++) {			
			int pSize=list.stream().filter(i->!i.startsWith(prefix)).collect(Collectors.toList()).size();
			System.out.println(prefix + ":" + pSize);
			if(pSize == 0) {
				break;
			}else {
				prefix = prefix.substring(0, nk - j);
			}
		}
		return prefix;
	}
	
	public static String longestCommonPrefix2(String[] strs) {
		if(strs.length==1) {
			return strs[0];
		}
		Arrays.sort(strs,Comparator.comparingInt(String::length));	
		prefix = strs[0];
		int nk=prefix.length();
		for (int j = 1; j <= nk; j++) {			
			int pSize=Arrays.stream(strs).filter(i->!i.startsWith(prefix)).collect(Collectors.toList()).size();
			if(pSize == 0) {
				break;
			}else {
				prefix = prefix.substring(0, nk - j);
			}
		}
		return prefix;
	}

	public static void main(String[] args) {
		System.err.println("==>"+longestCommonPrefix2(new String[] { "flower", "flow", "flight" }));
		System.err.println("==>"+longestCommonPrefix2(new String[] {"dog","racecar","car" }));
		System.err.println("==>"+longestCommonPrefix2(new String[] {"a" }));
	}

}
