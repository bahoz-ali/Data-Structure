package Queue;

public class Main {
	public static void main(String args[]) {
		ArrayQueue queue = new ArrayQueue(5);

		queue.enQueue(10);
		queue.enQueue(20);
		queue.enQueue(30);
		queue.enQueue(40);
		queue.enQueue(50);
		System.out.println(queue.toString());

		System.out.println("\nIs Empty: " + queue.isEmpty());
		System.out.println("Is Full :" + queue.isFull());
		System.out.println("peek: " + queue.peek());

		// ______________________________________________
		System.out.println("\n");

		StackQueue sQueue = new StackQueue();
		sQueue.enQueue(4);
		sQueue.enQueue(5);
		sQueue.enQueue(6);
		sQueue.enQueue(7);

		System.out.println("deQueue: " + sQueue.deQueue());
		System.out.println("peek: " + sQueue.peek());
		sQueue.print();
		// ------------------------------------------------------

		System.out.println("\n");
		priorityQueue p = new priorityQueue();

		p.add(10);
		p.add(2);
		p.add(8);
		p.add(7);
		p.add(5);

		p.print();

	}
}
