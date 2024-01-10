package test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MapVsFlatMap {

	public static void main(String[] args) {
		int[][] a2 = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		int[][][] a3 = { { { 1 }, { 2 }, { 3 } }, { { 4 }, { 5 }, { 6 } }, { { 7 }, { 8 }, { 9 } } };
		int[][][][] a4 = { { { { 1 }, { 2 } }, { { 3 }, { 4 } }, { { 5 }, { 6 } } },
				{ { { 7 }, { 8 } }, { { 9 }, { 10 } }, { { 11 }, { 12 } } },
				{ { { 13 }, { 14 } }, { { 15 }, { 16 } }, { { 17 }, { 18 } } } };
		List<Integer> list = Stream.of(a2).flatMapToInt(IntStream::of).boxed().collect(Collectors.toList());
		List<Integer> list3 = Stream.of(a3).flatMap(Arrays::stream).flatMapToInt(IntStream::of).boxed()
				.collect(Collectors.toList());
		List<Integer> list4 = Stream.of(a4).flatMap(Arrays::stream).flatMap(Arrays::stream).flatMapToInt(IntStream::of)
				.boxed().collect(Collectors.toList());
		System.out.println(list);
		System.out.println(list3);
		System.out.println(list4);

	}

}
