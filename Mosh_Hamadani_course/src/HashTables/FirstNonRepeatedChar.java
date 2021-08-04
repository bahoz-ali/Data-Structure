package HashTables;

import java.util.HashMap;
import java.util.Map;

public class FirstChar {
	public static void main(String[] args) {
		System.out.print("first: ");
		System.out.println(firstNonRepeatedChar("a green apple"));

	}

	public static char firstNonRepeatedChar(String str) {
		Map<Character, Integer> map = new HashMap<>();

		char[] chars = str.toCharArray();
		for (char ch : chars) {
			int count = map.containsKey(ch) ? map.get(ch) : 0;
			map.put(ch, count + 1);
		}

		for (char ch : chars)
			if (map.get(ch) == 1)
				return ch;

		return Character.MIN_VALUE;
	}

}
