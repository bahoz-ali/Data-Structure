package HashTables;

import java.util.HashMap;
import java.util.Map;

public class MaxDistance {

	public static void main(String[] args) {
		int list[] = { 1, 1, 2, 2, 2, 1 };
		int list2[] = { 1, 2, 3, 4, 5, 6 };
		int maxDistance = maxDistanceOfSameElement(list);
		System.out.println("distance = " + maxDistance);

	}

	public static int maxDistanceOfSameElement(int list[]) {
		if (list.length == 0)
			return -1;

		int maxDistance = 0;
		Map<Integer, Integer> hash = new HashMap<Integer, Integer>();

		for (int i = 0; i < list.length; i++) {

			if (!hash.containsKey(list[i]))
				hash.put(list[i], i);
			else {
				int prevIndex = hash.get(list[i]);
				int distance = i - prevIndex;

				maxDistance = Math.max(maxDistance, distance);
			}
		}

		return maxDistance;
	}

}
