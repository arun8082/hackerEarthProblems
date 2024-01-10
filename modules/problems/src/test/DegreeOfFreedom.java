package test;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class DegreeOfFreedom {
	public static void main(String[] args) throws IOException {
		/*BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter wr = new PrintWriter(System.out);
		int T = Integer.parseInt(br.readLine().trim());
		for (int t_i = 0; t_i < T; t_i++) {
			int N = Integer.parseInt(br.readLine().trim());
			String[] arr_A = br.readLine().split(" ");
			int[] A = new int[N];
			for (int i_A = 0; i_A < arr_A.length; i_A++) {
				A[i_A] = Integer.parseInt(arr_A[i_A]);
			}

			long out_ = solve(N, A);
			System.out.println(out_);

		}

		wr.close();
		br.close();*/
		
		int []A ={1,5,2};
		A = new int[]{1,2,1,0,5};
//		A = new int[]{1,4,2,3};
//		A = new int[]{1,2,3,2,1};
		int N = A.length;
		long out_ = solve(N, A);
//		System.out.println(out_);
		
	}

	static long solve(int N, int[] A) {		
		Map<int[], Integer> map = new HashMap<int[], Integer>();
		for (int i = 0; i < A.length; i++) {
			for (int j = i+1; j <= A.length; j++) {
				int []subarray = Arrays.copyOfRange(A, i, j);
				if (subarray.length ==1)
					continue;
				int degree = subarray[0]-subarray[subarray.length-1];
				degree = degree<0?degree*-1:degree;
				map.put(subarray,degree);
			}
		}
		
		map.entrySet().stream().forEach(e->System.out.println(Arrays.toString(e.getKey())+"->"+e.getValue()));
		long result = 0;

		return result;

	}
}
