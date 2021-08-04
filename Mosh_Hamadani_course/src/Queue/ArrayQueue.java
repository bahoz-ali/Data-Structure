package Queue;

import java.util.Arrays;

public class ArrayQueue {	
	private int items [];
	private int front = 0;
	private int rear = 0;
	private int count = 0;
	public ArrayQueue(int capacity) {
		items = new int[capacity];
	}
	
	
	public void enQueue(int item) {
		if(items.length == count) throw new IllegalStateException();
		
		items[rear] = item;
		rear = (rear + 1) % items.length;
		count++;
	}
	public int deQueue() {
		if(count == 0) throw new IllegalStateException();
		
		int item = items[front];
		items[front] = 0;
		front = (front + 1) % items.length;
		count--;
		return item;
	}
	
	public int peek() {
		return items[front];
	}
	public boolean isEmpty() {
		return count == 0 ;
	}
	public boolean isFull() {
		return count == items.length;
	}
	
	
	@Override
	public String toString() {
		//int [] content = Arrays.copyOfRange(items, front, rear);
		return Arrays.toString(items);
	}
	
	
	
	
	
}
