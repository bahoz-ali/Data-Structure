package Queue;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class ReverseQueue {

	public static void reverse(Queue<Integer> queue) {

		Stack<Integer> stack = new Stack<>();
		while (!queue.isEmpty())
			stack.push(queue.remove());

		while (!stack.isEmpty())
			queue.add(stack.pop());
	}

	public static void main(String[] args) {
		Queue<Integer> q = new ArrayDeque<Integer>();
		q.add(10);
		q.add(20);
		q.add(30);
		q.add(40);
		q.add(50);
		q.add(60);
		q.add(70);
		q.add(80);
		q.add(90);
		q.add(100);

		System.out.println("Before: " + q);
		reverse(q);
		System.out.println("After: " + q);

	}
}
