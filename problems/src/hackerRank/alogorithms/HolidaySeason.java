package hackerRank.alogorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class HolidaySeason {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = "34";// br.readLine();
		int N = Integer.parseInt(line.trim());

		String string ="hylobclddzflmzitrxwwsqhozvgexhxjmm";// br.readLine().trim();
		int result = noOfVarients(N, string);
		System.out.println(result);
	}
	
	List<String> list = new ArrayList<String>();
	public void allCombination(int n , String S) {
		StringBuilder sb = new StringBuilder();
		for (int i=0;i<n;i++) {
			sb.append(S.charAt(i));
		}		
	}
	
	

	private static int noOfVarients(int n, String string) {
		int count = 0;
		int k = 1;

		for (int i = 0; i < string.length()/2; i++) {
			if ((i + 4) <= string.length()) {
				String substr = string.substring(i, i + 4);
				System.out.println((k++) + "--" + substr);
				if (substr.charAt(0) == substr.charAt(2) && substr.charAt(1) == substr.charAt(3)) {
					count++;
				}
			}
		}
		return count;
	}
}
