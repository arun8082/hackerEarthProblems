package hackerRank.alogorithms;

import java.util.Map;
import java.util.TreeMap;

class MyComparator {

	public boolean compare(int o1, int o2) {
		return o1==o2;
	}    
	public boolean compare(String o1, String o2) {
		return o1.equals(o2);
	} 
	public boolean compare(int[] o1, int[] o2) {
		boolean s=true;
		if(o1.length != o2.length) {
			s=false;
		}
		for(int i=0;i<o1.length;i++) {
			if(o1[i]!=o2[i]) {
				s= false;
			}
		}
		return s;
	} 
}

public class Balanced {

	static boolean isBalanced(String s) {
		int n = -1;
		while (s.length() != n) {
			n = s.length();
			s = s.replace("()", "");
			s = s.replace("[]", "");
			s = s.replace("{}", "");
		}
		if (s.length() == 0)
			return true;
		else 
			return false;
	}

	public static void main(String[] args) {
		System.err.println(07);
		Map<Integer,String> m = new TreeMap<Integer, String>();
		
	}
	
	
}
