package hackerRank.arrays;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class SparseArrays {

    // Complete the matchingStrings function below.
    static int[] matchingStrings(String[] strings, String[] queries) {
    	List<String> list1=Arrays.asList(strings);
    	List<String> list2=Arrays.asList(queries);
    	int[] ans=new int[list2.size()];
    	int i=0;
    	for(String str:list2) {
    		ans[i++]=Collections.frequency(list1,str);
    	}
    	return ans;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int stringsCount = 3;//scanner.nextInt();
        //scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] strings = new String[] {"def","de","fgh"};
        /*
        for (int i = 0; i < stringsCount; i++) {
            String stringsItem = scanner.nextLine();
            strings[i] = stringsItem;
        }*/

        int queriesCount = 3;//scanner.nextInt();
        //scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] queries = new String[] {"de","lmn","fgh"};
        /*
        for (int i = 0; i < queriesCount; i++) {
            String queriesItem = scanner.nextLine();
            queries[i] = queriesItem;
        }*/

        int[] res = matchingStrings(strings, queries);

        for (int i = 0; i < res.length; i++) {
            bufferedWriter.write(String.valueOf(res[i]));

            if (i != res.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

