package hackerRank.alogorithms;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class PlusMinus {

    // Complete the plusMinus function below.
    static void plusMinus(int[] arr) {
    	int []result= new int[3];
    	for(int i:arr) {
    		if(i<0) {
    			result[0] +=1;
    		}else if(i>0) {
    			result[1] +=1;
    		}else {
    			result[2] +=1;
    		}
    	}
    	int size=arr.length;
    	System.out.printf("%.6f\n%.6f\n%.6f", (1.0*result[0])/size,(1.0*result[0])/size,(1.0*result[0])/size);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        plusMinus(arr);

        scanner.close();
    }
}
