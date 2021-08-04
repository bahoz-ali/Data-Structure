package LinkedList_building;

public class Main {

	public static void main(String[] args) {
		LinkedList list = new LinkedList();

		list.addFirst(1);
		list.addLast(2);
		list.addLast(3);
		list.addLast(4);
		list.addLast(5);
		list.addLast(1);
		list.addLast(2);
		list.addLast(3);
		list.addLast(4);
		list.addLast(5);
		list.addLast(1);
		list.addLast(6);
		list.addLast(6);
		list.print();
		list.removeDuplicate();
		list.print();
		System.out.println("----dublicate removed---");
		System.out.println("item: " + list.getKthFromTheEnd(1));
		System.out.println("size: " + list.size());
		System.out.println("index of 3 : " + list.indexOf(3));
		list.print();
		// list.rearrange();
		list.MoveEvenNodesInReverseOrder();

		list.print();
		// list.moveNode();
		// list.removeFirst();
		// list.reverse();

	}

}
