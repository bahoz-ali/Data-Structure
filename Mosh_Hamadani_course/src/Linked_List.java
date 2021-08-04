import java.util.LinkedList;

public class Linked_List {
	public static void main(String[] args) {
		LinkedList<Object> list = new LinkedList<>();

		list.addFirst("bahoz");
		list.addFirst("Hunar");
		list.addLast(2);
		list.removeFirst();
		list.removeLast();

		Object[] arr = list.toArray();
		arr[2] = 3;
		System.out.println(list);

	}
}
