package Queue;

import java.util.Stack;

public class StackQueue {
	Stack<Integer> stack1 = new Stack<>();
	Stack<Integer> stack2 = new Stack<>();
	
	public 	void enQueue(int item) {
		stack1.push(item);
	}
	public int deQueue() {
		if (isEmpty()) System.out.println("Queue is Empty.!");
		
		moveStack1ToStack2();
		return stack2.pop();
	}
	
	public int peek() {
		moveStack1ToStack2();
		return stack2.peek();
	}
	
	public boolean isEmpty() {
		return stack1.isEmpty() && stack2.isEmpty();
	}
	
	public void print() {
		System.out.println(stack2);
	}
	private void moveStack1ToStack2() {
		if(stack2.empty()) {
			while(!stack1.isEmpty()) 
				stack2.push( stack1.pop() );
		}
	}
	
}
