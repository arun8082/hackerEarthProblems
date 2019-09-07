package hackerRank.arrays;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class ArrayManipulation {

    // Complete the arrayManipulation function below.
    static long arrayManipulation(int n, int[][] queries) {
    	int []arr=new int[n];
    	for(int[] row:queries) {
    		int a=row[0];
    		int b=row[1];
    		int k=row[2];
    		//System.out.print("a:"+a+" b:"+b);
    		for(int i=a;i<=b;i++) {
    			arr[i-1]=arr[i-1]+k;
    		}
    		//System.out.println(" "+Arrays.toString(arr));
    	}
    	
    	
    	int max=arr[0];
    	for(int i=0;i<arr.length;i++) {
    		if(max<arr[i]) {
    			max=arr[i];
    		}
    	}
    	//System.out.println("max:"+max);
    	return max;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        //String[] nm = scanner.nextLine().split(" ");

        int n = 5;//Integer.parseInt(nm[0]);

        int m = 3;//Integer.parseInt(nm[1]);

        int[][] queries = new int[m][3];

        /*for (int i = 0; i < m; i++) {
            String[] queriesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        	
            for (int j = 0; j < 3; j++) {
                int queriesItem = Integer.parseInt(queriesRowItems[j]);
                queries[i][j] = queriesItem;
            }            
        }*/
        queries[0]=new int[] {1,2,100};
    	queries[1]=new int[] {2,5,100};
    	queries[2]=new int[] {3,4,100};

        long result = arrayManipulation(n, queries);

        //bufferedWriter.write(String.valueOf(result));
        //bufferedWriter.newLine();

        //bufferedWriter.close();

        scanner.close();
    }
}
