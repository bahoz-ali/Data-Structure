package Stack;

import java.util.Arrays;

public class Stack {
	private int top = 0;

	int items[];

	Stack(int size) {
		items = new int[size];
	}

	public void push(int item) {
		if (top == items.length)
			throw new StackOverflowError();

		items[top++] = item;
	}

	public int pop() {
		if (isEmpty())
			throw new IllegalStateException();

		int peek = items[--top];
		items[top] = 0;
		return peek;
	}

	public int peek() {
		if (top == 0)
			throw new IllegalStateException();

		int peek = top;
		return items[--peek];
	}

	public boolean isEmpty() {
		return top == 0;
	}

	public String toSrring() {
		int content[] = Arrays.copyOfRange(items, 0, top);
		return Arrays.toString(content);
	}

}
