package hackerRank.alogorithms;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class empty {

	private static List<String> combinationsWithRepetations(char[] arr, List<Character> tempArray, int r) {
		if (tempArray.size() == r) {
			list.add(tempArray.stream().map(String::valueOf).collect(Collectors.joining()));
		} else {
			for (int i = 0; i < arr.length; i++) {
				tempArray.add(arr[i]);
				combinationsWithRepetations(arr, tempArray, r);
				tempArray.remove(tempArray.size() - 1);
			}
		}
		return list;
	}
	static List<String> list = new ArrayList<String>();
	private static List<String> combinationsWithOutRepetations(char[] arr, List<Character> tempArray, int r) {
		if (tempArray.size() == r) {
			String tmpStr = tempArray.stream().map(String::valueOf).collect(Collectors.joining());
			list.add(tmpStr);
		} else {
			for (int i = 0; i < arr.length; i++) {				
				if (Collections.frequency(tempArray, arr[i]) == 0) {
					tempArray.add(arr[i]);
					combinationsWithOutRepetations(arr, tempArray, r);
					tempArray.remove(tempArray.size() - 1);
				}
			}
		}

		return list;
	}


}
