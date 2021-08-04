package LinkedList_building;

import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;

public class LinkedList {
	private class Node {
		private int value;
		private Node next;

		public Node(int value) {
			this.value = value;
		}
	}

	private Node first;
	private Node last;
	private int size;// we want know size of our list by using this one;

	public void addFirst(int item) {
		Node node = new Node(item);
		if (isNull()) {
			first = last = node;
		} else {
			node.next = first;
			first = node;
		}
		size++;
	}

	public void addLast(int item) {
		Node node = new Node(item);
		if (isNull()) {
			first = last = node;
		} else {
			last.next = node;
			last = node;
		}
		size++;

	}

	public int indexOf(int item) {
		int index = 0;
		Node current = first;
		while (current != null) {
			if (current.value == item)
				return index;
			index++;
			current = current.next;
		}

		return -1;
	}

	public boolean contains(int item) {
		return indexOf(item) != -1;
	}

	public void removeFirst() {
		if (isNull()) {
			throw new NoSuchElementException();
		}

		if (first == last) {
			first = last = null;
			size--;
			return;// its usful because It's like "break".
		}

		Node second = first.next;
		first.next = null;
		first = second;

		size--;
	}

	public void removeLast() {
		if (isNull())
			throw new NoSuchElementException();

		if (first == last) {
			first = last = null;
			size--;
			return;
		}

		Node previous = getPrevious(last);
		last = previous;
		last.next = null;
		size--;
	}

	public int[] toArray() {
		int array[] = new int[size];
		Node current = first;
		int index = 0;
		while (current != null) {
			array[index++] = current.value;
			current = current.next;
		}
		return array;
	}

	public void reverse() {
		Node previous = first;
		Node current = first.next;

		while (current != null) {
			Node next = current.next;
			current.next = previous;

			previous = current;
			current = next;
		}

		last = first;
		last.next = null;
		first = previous; // we know that previous now goes last node;

	}

	public int getKthFromTheEnd(int k) {
		if (isNull())
			throw new IllegalStateException();

		Node pointer1 = first;
		Node pointer2 = first;
		for (int i = 0; i < k; i++) {
			pointer2 = pointer2.next;
			if (pointer2 == null)
				throw new IllegalArgumentException();
		}

		while (pointer2 != null) {
			pointer1 = pointer1.next;
			pointer2 = pointer2.next;
		}

		return pointer1.value;
	}

	public void rearrange() {
		Node odd = first;
		Node even = null;
		Node node;
		while (odd != null && odd.next != null) {
			if (odd.next != null) {
				node = odd.next;
				odd.next = odd.next.next;

				node.next = even;
				even = node;
			}
			odd = odd.next;
		} // while

		odd.next = even;

	}

	public void removeDuplicate() {
		Set<Integer> setNode = new HashSet<Integer>();

		Node prevCurrent = first;
		Node currentKey = first;
		while (currentKey != null) {
			if (!setNode.contains(currentKey.value))
				setNode.add(currentKey.value);
			else {
				System.out.println(prevCurrent.value + " " + currentKey.value);
				prevCurrent.next = currentKey.next;
				currentKey = currentKey.next;// we just have to update the current not prev bec we just deleted the
												// current and keep prev
				continue;// it means donot excute below one we don't want update prev and current
			}

			prevCurrent = currentKey;
			currentKey = currentKey.next;
		}

	}

	public void MoveEvenNodesInReverseOrder() {
		Node current = first;
		Node evenList = null;
		boolean isFirstDeleted;

		while (current.next != null) {
			isFirstDeleted = false;

			if (current == first && isEven(first)) {
				evenList = addToEvenList(evenList, current.value);
				removeFirst();

				isFirstDeleted = true;
			}

			else {
				if (isEven(current)) {
					evenList = addToEvenList(evenList, current.value);
					deletMiddleNode(current);
				}
			}
			current = updateCurrent(current, isFirstDeleted);
		} // while

		current.next = evenList; // to connect nodes with evens..

	}

	private void deletMiddleNode(Node current) {
		Node beforeCurrent = getPrevious(current);
		beforeCurrent.next = current.next;
	}

	private Node updateCurrent(Node current, boolean isFirstDeleted) {
		return current = isFirstDeleted ? first : current.next;
	}

	public Node addToEvenList(Node evenList, int evenItem) {
		Node node = new Node(evenItem);
		node.next = evenList;
		evenList = node;

		return evenList;

	}

	private boolean isEven(Node current) {
		return current.value % 2 == 0;
	}

	public int size() {
		return size;
	}

	void print() {
		Node temp = first;
		System.out.print("[ ");
		while (temp != null) {
			System.out.print(temp.value + " ");
			temp = temp.next;
		}
		System.out.println("]");
	}

	private Node getPrevious(Node node) {
		Node current = first;
		while (current != null) {
			if (current.next == node) {
				return current;
			}
			current = current.next;
		} // while
		return null;
	}

	private boolean isNull() {
		return first == null;
	}

}
