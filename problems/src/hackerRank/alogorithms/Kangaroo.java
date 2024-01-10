package hackerRank.alogorithms;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Kangaroo {

	// Complete the kangaroo function below.
	static String kangaroo(int x1, int v1, int x2, int v2) {
		if((x2>x1 && v2>v1) || (x1>x2 && v1>v2) || (x1==x2 && (v1>v2||v1<v2)) ) {
    		return "NO";
    	}else  {
    		int s1=x1+v1;
    		int s2=x2+v2;
    		for(int i=0; i<=s1;i++) {
    			if(s2==s1) {
    				return "YES";
    			}
    			s2 += v2;
    		}    		
    		return "NO";
    	}
    }

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		/*
		 * BufferedWriter bufferedWriter = new BufferedWriter(new
		 * FileWriter(System.getenv("OUTPUT_PATH")));
		 * 
		 * String[] x1V1X2V2 = scanner.nextLine().split(" ");
		 * 
		 * int x1 = Integer.parseInt(x1V1X2V2[0]);
		 * 
		 * int v1 = Integer.parseInt(x1V1X2V2[1]);
		 * 
		 * int x2 = Integer.parseInt(x1V1X2V2[2]);
		 * 
		 * int v2 = Integer.parseInt(x1V1X2V2[3]);
		 * 
		 * String result = kangaroo(x1, v1, x2, v2);
		 * 
		 * bufferedWriter.write(result); bufferedWriter.newLine();
		 * 
		 * bufferedWriter.close();
		 * 
		 * scanner.close();
		 */
		int x1 = 28;//0;//0;//1;
		int v1 = 8;//2;//3;//2;
		int x2 = 96;//5;//4;//2;
		int v2 = 2;//3;//2;//1;
		String result = kangaroo(x1, v1, x2, v2);
		System.out.println(result);
	}
}
