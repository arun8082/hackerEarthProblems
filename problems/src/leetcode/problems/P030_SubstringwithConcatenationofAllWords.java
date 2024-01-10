package leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class P030_SubstringwithConcatenationofAllWords {
	public static List<Integer> findSubstring(String s, String[] words) {
		List<Integer> res = new ArrayList<Integer>();
		Map<String, Long> map = Arrays.stream(words)
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println(map);
		int wordsCount = words.length;
		int wordsLength = words[0].length();

		for (int i = 0; i <= s.length() - (wordsCount * wordsLength); i++) {
			Map<String, Long> seen = new HashMap<String, Long>();
			for (int j = 0; j < wordsCount; j++) {
				int nextIndex = i + j * wordsLength;
				String nextWord = s.substring(nextIndex, nextIndex + wordsLength);
				if (!map.containsKey(nextWord))
					break;
				seen.put(nextWord, seen.getOrDefault(nextWord, 0l) + 1);
				if (seen.get(nextWord) > map.getOrDefault(nextWord, 0l))
					break;
				if (j + 1 == wordsCount) {
					res.add(i);
				}
			}
		}

		return res;
	}

	public static void main(String[] args) {
		System.out.println(findSubstring("barfoothefoobarman", new String[] { "foo", "bar" }));
		System.out.println(findSubstring("wordgoodgoodgoodbestword", new String[] { "word", "good", "best", "word" }));
		System.out.println(findSubstring("wordgoodgoodgoodbestword", new String[] { "word", "good", "best", "good" }));
	}

}
