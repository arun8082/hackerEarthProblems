package hackerEarth;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArrayFrequancy {
	public static void main(String[] args) {
		Integer []array= new Integer[]{1,2,3,4,2,6,8,2,1,4,2,2,2};
		System.out.println(Arrays.toString(array));
		int num=100;
		List<Integer> list = Arrays.asList(array);
		System.out.println(Collections.frequency(list, num));
	}
}
