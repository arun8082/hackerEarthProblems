package hackerRank.alogorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class AuthResult {
	static final long M = (long) (Math.pow(10, 9)+7);
	static final double P = 131;
	static long hash;
	static List<Long> hashList = new ArrayList<Long>();
	
	static long getHash(String s) {
		char[] arr = s.toCharArray();
		long sum = 0;
		int n = arr.length;
		for (int i = 0; i < n; i++) {
			int ascii = (int) arr[i];
			sum += ascii * Math.pow(P, n - i - 1);
		}
		return Math.floorMod(sum, M);
	}
	
	static void getAllHash(String s) {	
		hashList.add(getHash(s));
		for(char c = 1;c<128;c++) {
			String s1 = s+c;
			hashList.add(getHash(s1));			
		}
	}
	
	static int authorize(int x) {
		return Collections.frequency(hashList, new Long(x))==1?1:0;
	}

	public static List<Integer> authEvents(List<List<String>> events) {
		int n = events.size();
		List<Integer> r = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			if (events.get(i).get(0).equalsIgnoreCase("setPassword")) {
				hashList = new ArrayList<Long>();
				getAllHash(events.get(i).get(1));
			} else {
				String t = events.get(i).get(1);
				int s = authorize(Integer.parseInt(t));
				r.add(s);
			}
		}
		return r;
	}

	public static void main(String[] args) {

//		String[][] arr = new String[][] { { "setPassword", "000A" }, { "authorize", "108738450" },
//				{ "authorize", "108738449" }, { "authorize", "244736787" } };
		String[][] arr = new String[][] { { "setPassword", "cAr1" }, { "authorize", "223691457" },
				{ "authorize", "303580761" }, { "authorize", "100" },{ "setPassword", "d" },{ "authorize", "100" } };
		List<List<String>> events = Arrays.stream(arr).map(Arrays::asList).collect(Collectors.toList());
		System.out.println("h1:" + getHash("cAr1a"));
		System.out.println(authEvents(events));
	}
}
