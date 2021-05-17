package hackerRank.alogorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SpecialShop {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = "1";//br.readLine();
		int T = Integer.parseInt(line.trim());
		while (T-- > 0) {
			line = "10 2 4";//br.readLine();

			String[] strArr = line.trim().split(" ");
			int N = Integer.parseInt(strArr[0]);
			int A = Integer.parseInt(strArr[1]);
			int B = Integer.parseInt(strArr[2]);

			long result = optimalMoney(N, A, B);
			System.out.println(result);
		}
	}

	private static long optimalMoney(long n, long a, long b) {
		long min = Long.MAX_VALUE;		
		long i = n*b/(a+b);
//		for (int i = 0; i <(n+1)/2 ; i++) {
//			int tmp1 = (a * (n - i) * (n - i)) + (b * i * i);
//			int temp2 = (a * i * i) + (b * (n - i) * (n - i));
			long temp1 =calculateValue(n,a,b,i);
			long temp2 = calculateValue(n, a,b, i+1);
			if (min > temp1) {
				min = temp1;
			} 
			if (min > temp2) {
				min = temp2;
			}
//		}
		return min;
	}

	private static long calculateValue(long n, long a, long b, long i) {		
		return (a * i * i) + (b * (n - i) * (n - i));
	}

}
