package Queue;

import java.util.Arrays;

public class priorityQueue {
	private int items[] = new int[5];
	int count = 0;

	public void add(int item) {
		if (isFull())
			throw new IllegalStateException();

		int i = shiftItemToInsert(item);
		items[i] = item;
		count++;
	}

	public int remove() {
		if (isEmpty())
			throw new IllegalStateException();
		return items[--count];
	}

	private boolean isFull() {
		return count == items.length;
	}

	public boolean isEmpty() {
		return count == 0;
	}

	private int shiftItemToInsert(int item) {
		int i;
		for (i = count - 1; i >= 0; i--) {
			if (items[i] > item)
				items[i + 1] = items[i];
			else
				break;
		}
		return i + 1;
	}

	public void print() {
		System.out.println(Arrays.toString(items));
	}

}
