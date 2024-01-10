package hackerRank.alogorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PolicemenAndThieves {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = "1";//br.readLine();
		int T = Integer.parseInt(line.trim());
		char [][]A= null;
		while(T-->0) {
			line = "3 1";//br.readLine();
			String []splitArray = line.trim().split(" ");
			int N = Integer.parseInt(splitArray[0]);
			int K = Integer.parseInt(splitArray[0]);
			A = new char[N][N];
			for(int i=0;i<N;i++) {
				line = "P T P";//br.readLine();
				splitArray = line.trim().split(" ");
				for (int j = 0; j < splitArray.length; j++) {
					A[i][j]= splitArray[j].charAt(0); 
				}
			}
			
			int i=0,j=0;
			A[i][j+0]='P';
			A[i][j+1]='T';
			A[i][j+2]='P';
			i++;
			A[i][j+0]='T';
			A[i][j+1]='P';
			A[i][j+2]='T';
			i++;
			A[i][j+0]='T';
			A[i][j+1]='T';
			A[i][j+2]='P';
			
			
			System.out.println(Arrays.deepToString(A));
			int res = maximumTheivesCanCatch(A,K);
			System.out.println(res);
		}
	}

	private static int maximumTheivesCanCatch(char[][] a, int k) {
		int count =0;
		for (int i = 0; i < a.length; i++) {
			List<Integer> pol = new ArrayList<Integer>();
			List<Integer> thi = new ArrayList<Integer>();
			for (int j = 0; j < a[i].length; j++) {
				if(a[i][j]=='P') {
					pol.add(j);
				}else if(a[i][j]=='T') {
					thi.add(j);
				}
			}
			int t=0,p=0;
			while (p<pol.size()&&t<thi.size()) {
				if(Math.abs(pol.get(p)-thi.get(t))<=k) {
					count++;
					p++;
					t++;
				}
				else if(pol.get(p)<thi.get(t)) {
					p++;
				}else {
					t++;
				}
			}			
		}		
		return count;
	}

	
}
