package HashTables;

import java.util.HashSet;
import java.util.Set;

public class firstReapeted {

	public static void main(String[] args) {
		char firstOne = firstRepeatedChar("black car");
		System.out.println("first: " + firstOne);
	}

	public static char firstRepeatedChar(String str) {
		Set<Character> set = new HashSet<>();

		char[] chars = str.toCharArray();
		for (char ch : chars) {
			if (set.contains(ch))
				return ch;

			set.add(ch); // we don't neet to use else;
		}

		return Character.MIN_VALUE;
	}

}
