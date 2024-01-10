package hackerRank.arrays;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class ArrayManipulation {

	private static long max;

	// Complete the arrayManipulation function below.
	static long arrayManipulation(int n, int[][] queries) {
		long []arr=new long[n];
        max=arr[0];
        Arrays.stream(queries).forEach(row->{
        	//System.out.println(Arrays.toString(row));
        	int a=row[0]-1;
            int b=row[1]-1;
            int k=row[2];
            if(a>=0 && b>=a && a<n && b<n){
                for(int i=a;i<=b;i++) {
                    arr[i]=arr[i]+k;
                    if(max<arr[i]) {
                        max=arr[i];
                    }
                }
            }
        });
        /*for(int[] row:queries) {
        	int a=row[0]-1;
            int b=row[1]-1;
            int k=row[2];
            //System.out.println("a:"+a+" b:"+b);
            if(a>=0 && b>=a && a<n && b<n){
                for(int i=a;i<=b;i++) {
                    arr[i]=arr[i]+k;
                    if(max<arr[i]) {
                        max=arr[i];
                    }
                }
            }
        }*/
        return max;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		//BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		//String[] nm = scanner.nextLine().split(" ");

		int n = 5;//Integer.parseInt(nm[0]);
		int m = 3;//Integer.parseInt(nm[1]);
		int[][] queries = new int[m][n];
		/*
		for (int i = 0; i < m; i++) {
			String[] queriesRowItems = scanner.nextLine().split(" ");
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			for (int j = 0; j < 3; j++) {
				int queriesItem = Integer.parseInt(queriesRowItems[j]);
				queries[i][j] = queriesItem;
			}
		}
		*/
		queries[0] = new int[] { 1, 2, 100 };
		queries[1] = new int[] { 2, 5, 100 };
		queries[2] = new int[] { 3, 4, 100 };

		long result = arrayManipulation(n, queries);
		System.out.println(result);
		//bufferedWriter.write(String.valueOf(result));
		//bufferedWriter.newLine();
		//bufferedWriter.close();

		scanner.close();
	}
}
