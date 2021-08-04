package HashTables;

import java.util.HashMap;
import java.util.Map;

public class MostFrequent {

	public static void mostFrequent(String text) {
		Map<Character, Integer> hash = new HashMap<>();

		char[] ch = text.toCharArray();

		for (char key : ch) {
			if (!hash.containsKey(key))
				hash.put(key, 1);
			else
				hash.put(key, hash.get(key) + 1);
		}

		int max = hash.get(ch[0]);
		char maxChar = ch[0];

		for (char key : ch) {
			if (hash.get(key) >= max) {
				max = hash.get(key);
				maxChar = key;
			}
		}

		// System.out.println(hash);
		System.out.println("char: " + maxChar + ", repeated: " + max + " times\n");

	}

	public static void main(String[] args) {
		mostFrequent("pneumonoultramicroscopicsilicovolcanoconiosis");
		mostFrequent("1223334");
	}

}
