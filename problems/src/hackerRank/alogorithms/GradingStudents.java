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

class Result1 {

    /*
     * Complete the 'gradingStudents' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY grades as parameter.
     */

    public static List<Integer> gradingStudents(List<Integer> grades) {
    // Write your code here
    	
    	grades=Arrays.asList(new Integer[] {22,86,30,0,16,51,53,42,48,22,69,12,27,34,24,95,16,32,22,52,56,71,95});
    	List<Integer> list= new ArrayList<Integer>();
    	int newMark;
    	for (Integer mark : grades) {
			if(mark<38) {
				list.add(mark);
				continue;
			}
			System.out.println("m: "+mark);
			if(mark%5!=0) {
				for(int i=1;true; i++) {
					newMark=mark+i;
					if((mark+i)%5==0) {
						break;
					}
				}
				if(newMark-mark<3) {
					list.add(newMark);
				}else if(newMark-mark>=3) {
					list.add(mark);
				}
			}else if(mark%5==0) {
				list.add(mark);
			}
		}    
    	list.forEach(i->{System.out.println(i);});
    	return list;
    }

}

public class GradingStudents {
    public static void main(String[] args) throws IOException {
    	Result1.gradingStudents(Arrays.asList(new Integer[] {1,2}));
    	/*
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int gradesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> grades = IntStream.range(0, gradesCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = Result1.gradingStudents(grades);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
        */
    }
}
