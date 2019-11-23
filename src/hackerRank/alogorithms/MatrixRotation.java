package hackerRank.alogorithms;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class MatrixRotation {

    // Complete the matrixRotation function below.
    static void matrixRotation(List<List<Integer>> matrix, int r) {
    	int [][]matrix1=new int[matrix.size()][matrix.get(0).size()];
		for (int i=0;i<matrix.size();i++) {
			for (int j=0;j<matrix.get(i).size();j++) {
				matrix1[i][j]=matrix.get(i).get(j);		
			}
		}
		while(r-- > 0) {
			for (int i=0;i<matrix1.length;i++) {
				for (int j=0;j<matrix1[i].length;j++) {
					matrix1[i][j]=1;
				}
			}
		}
		
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] mnr = "4 4 2".replaceAll("\\s+$", "").split(" ");

        int m = Integer.parseInt(mnr[0]);

        int n = Integer.parseInt(mnr[1]);

        int r = Integer.parseInt(mnr[2]);

        List<List<Integer>> matrix = new ArrayList<>();
/*
        IntStream.range(0, m).forEach(i -> {
            try {
                matrix.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });*/
        
        List<Integer> r1=Arrays.asList(new Integer[] { 1,2,3,4});
        List<Integer> r2=Arrays.asList(new Integer[] { 5,6,7,8});
        List<Integer> r3=Arrays.asList(new Integer[] { 9,10,11,12});
        List<Integer> r4=Arrays.asList(new Integer[] { 13,14,15,16});
        matrix.add(r1);
        matrix.add(r2);
        matrix.add(r3);
        matrix.add(r4);

        matrixRotation(matrix, r);

        bufferedReader.close();
    }
}
