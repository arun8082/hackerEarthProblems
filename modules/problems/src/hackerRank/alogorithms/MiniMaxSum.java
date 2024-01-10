package hackerRank.alogorithms;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class MiniMaxSum {

    // Complete the miniMaxSum function below.
    static void miniMaxSum(int[] arr) {
    	long min=0;
    	long max=0;
    	long sum=0;
    	for(int i=0; i<arr.length;i++) {
    		sum=0;
    		for(int j=0; j<5;j++) {
    			if(j==i) {
    				continue;
    			}
    			sum +=arr[j];
    			System.out.print(arr[j]+" ");
    		}
    		if(min==0 && max==0) {
    			min=sum;
    			max=sum;
    		}
    		if(min>sum) {
    			min=sum;
    		}
    		if(max<sum) {
    			max=sum;
    		}
    	}
    	System.out.println(min+" "+max);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[] arr = new int[5];

        String[] arrItems = "1 3 5 7 9".split(" ");
        //scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < 5; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        miniMaxSum(arr);

        scanner.close();
    }
}
