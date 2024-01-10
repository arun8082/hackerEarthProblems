package hackerEarth;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Find the number of substrings that have even number of characters of each type(Sequance must be same)
 * eg. N=5;S=abbaa substrings having even no of characters are [abba, bb, bbaa, aa]
 * @author Arunendra Kumar
 */

public class GreatSubstring {
	public static void main(String[] args) throws IOException {
		/*
		 * BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 * PrintWriter wr = new PrintWriter(System.out); int T =
		 * Integer.parseInt(br.readLine().trim()); for (int t_i = 0; t_i < T; t_i++) {
		 * int N = Integer.parseInt(br.readLine().trim()); String S = br.readLine();
		 * 
		 * long out_ = Solve(N, S); System.out.println(out_);
		 * 
		 * }
		 * 
		 * wr.close(); br.close();
		 */
		String S = "abbaa";
//		String S = "abba";
//		String S = "aabccbbcaa";
//		String S = "abbccde";
		int N = S.length();
		long out_ = Solve(N, S);
		System.out.println(out_);
	}

	static long Solve(int N, String S) {
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < N; i++) {
			for (int j = i + 1; j <= N; j++) {
				String substr = S.substring(i, j);
				List<Character> chars = substr.chars().mapToObj(e -> (char) e).collect(Collectors.toList());
				Map<Character,Long> countMap = chars.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
				boolean status=true;
				for(Map.Entry<Character, Long> entry:countMap.entrySet()) {
					if(entry.getValue()%2!=0) {
						status=false;
						break;
					}
				}
				if (status==true)
					list.add(substr);
			}
		}
		System.out.println(list);
		return list.size();
	}
}