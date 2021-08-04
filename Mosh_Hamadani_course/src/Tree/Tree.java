package Tree;

import java.util.ArrayList;

public class Tree {

	private class Node {
		private int value;
		private Node leftChild;
		private Node rightChild;

		public Node(int value) {
			this.value = value;
		}
	}

	private Node root;

	public void insert(int value) {
		Node node = new Node(value);

		if (root == null) {
			root = node;
			return;
		}
		Node parent = root;
		while (true) {
			if (value < parent.value) {
				if (parent.leftChild == null) {
					parent.leftChild = node;
					break;
				}
				parent = parent.leftChild;
			}

			else {
				if (parent.rightChild == null) {
					parent.rightChild = node;
					break;
				}
				parent = parent.rightChild;
			}

		} // while

	}

	public boolean find(int value) {
		Node parent = root;
		while (parent != null) {
			if (value < parent.value)
				parent = parent.leftChild;
			else if (value > parent.value)
				parent = parent.rightChild;
			else
				return true;
		} // while

		return false;
	}

	public void traverseInOrder() {
		System.out.println("---------InOrder------------");
		traverseInOrder(root);
	}

	private void traverseInOrder(Node root) {
		if (root == null)
			return;
		traverseInOrder(root.leftChild);
		System.out.print(root.value + " ");
		traverseInOrder(root.rightChild);

	}

	public void traversePreOrder() {
		System.out.println("---------PreOrder-----------");
		traversePreOrder(root);
	}

	private void traversePreOrder(Node root) {
		if (root == null)
			return;
		System.out.print(root.value + " ");
		traversePreOrder(root.leftChild);
		traversePreOrder(root.rightChild);

	}

	public int hight() {
		System.out.println("----------------------------");
		return hight(root);
	}

	private int hight(Node root) {
		if (root == null)
			return -1;

		if (isLeaf(root)) // it's optional
			return 0;

		int leftHight = hight(root.leftChild);
		int rightHight = hight(root.rightChild);

		return 1 + Math.max(leftHight, rightHight);
	}

	private boolean isLeaf(Node root) {
		return root.leftChild == null && root.rightChild == null;
	}

	public int min() {
		System.out.println("----------------------------");
		return min(root);
	}

	private int min(Node root) {

		if (isLeaf(root))
			return root.value;
		else if (root.leftChild == null)
			return Math.min(root.rightChild.value, root.value);
		else if (root.rightChild == null)
			return Math.min(root.leftChild.value, root.value);

		int left = min(root.leftChild);
		int right = min(root.rightChild);

		int minBetween = Math.min(left, right);
		return Math.min(minBetween, root.value);

	}

	public int minInBinarySearchTree() {
		System.out.println("----------------------------");
		if (root == null)
			throw new IllegalStateException();

		Node current = root;
		Node last = current;
		while (current != null) {
			last = current;
			current = current.leftChild;
		}

		return last.value;
	}

	public boolean equals(Tree tree) {
		System.out.println("----------------------------");
		if (tree == null)
			return false;

		return equals(root, tree.root);
	}

	private boolean equals(Node first, Node second) {
		if (first == null && second == null)
			return true;

		// System.out.println(first.value + " = " + second.value);
		if (first != null & second != null)
			return first.value == second.value && equals(first.leftChild, second.leftChild)
					&& equals(first.rightChild, second.rightChild);

		return false;
	}

	public boolean isBinarySearchTree() {
		System.out.println("----------------------------");
		return isBinarySearchTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private boolean isBinarySearchTree(Node root, int min, int max) {
		if (root == null)
			return true;

		// System.out.println(min + " <= " + root.value + " <= " + max);

		if (root.value < min || root.value > max)
			return false;

		return isBinarySearchTree(root.leftChild, min, root.value - 1)
				&& isBinarySearchTree(root.rightChild, root.value + 1, max);
	}

	public ArrayList<Integer> getNodesAtDistance(int distance) {
		ArrayList<Integer> listOfNodesValue = new ArrayList<>();
		return getNodesAtDistance(root, distance, listOfNodesValue);

	}

	private ArrayList<Integer> getNodesAtDistance(Node root, int distance, ArrayList<Integer> listOfNodesValue) {
		if (root == null)
			return null;

		if (distance == 0) {
			listOfNodesValue.add(root.value);

		}

		getNodesAtDistance(root.leftChild, distance - 1, listOfNodesValue);
		getNodesAtDistance(root.rightChild, distance - 1, listOfNodesValue);

		return listOfNodesValue;
	}

	public void traverseLevelOrder() {
		int hightOfTree = hight(); // it 's for not running this hight() method each time;
		for (int i = 0; i <= hightOfTree; i++) {

			ArrayList<Integer> listOfNodesValue = getNodesAtDistance(i);
			for (int aValue : listOfNodesValue)
				System.out.print(aValue + " ");

		}

	}

	public int size() {
		System.out.println("----------------------------");
		return size(root);
	}

	private int size(Node root) {
		if (root == null)
			return 0;

		return size(root.leftChild) + 1 + size(root.rightChild);

	}

	public int coutLeaves() {
		System.out.println("----------------------------");
		return coutLeaves(root);
	}

	private int coutLeaves(Node root) {
		if (root == null)
			return 0;

		if (isLeaf(root))
			return 1;

		return coutLeaves(root.leftChild) + coutLeaves(root.rightChild);
	}

	public int max() {
		System.out.println("----------------------------");
		return max(root);
	}

	private int max(Node root) {
		if (root == null)
			return -1;

		if (root.rightChild == null)
			return root.value;

		return max(root.rightChild);
	}

	public boolean contains(int value) {
		System.out.println("----------------------------");
		return contains(root, value);
	}

	private boolean contains(Node root, int value) {

		if (root == null)
			return false;

		else if (root.value == value)
			return true;

		else if (value < root.value)
			return contains(root.leftChild, value);

		else
			return contains(root.rightChild, value);

	}

	public boolean areSibling(int valueOne, int valueTwo) {
		System.out.println("----------------------------");
		return areSibling(root, valueOne, valueTwo);
	}

	private boolean areSibling(Node root, int valueOne, int valueTwo) {
		if (root == null)
			return false;

		if (root.leftChild != null && root.rightChild != null) {

			if (root.leftChild.value == valueOne && root.rightChild.value == valueTwo)
				return true;
			else if (root.leftChild.value == valueTwo && root.rightChild.value == valueOne)
				return true;
		}

		return areSibling(root.leftChild, valueOne, valueTwo) || areSibling(root.rightChild, valueOne, valueTwo);
	}

	public boolean areTreesIdentical(Tree second) {

		return areTreesIdentical(root, second.root);
	}

	private boolean areTreesIdentical(Node first, Node second) {

		if (first == null && second == null)
			return true;

		if (first != null && second != null) {
			if ((first.value == second.value) && areTreesIdentical(first.leftChild, second.leftChild)
					&& areTreesIdentical(first.rightChild, second.rightChild)) {
				return true;
			}

		}
		return false;
	}

	public int convertToSumTree() {
		return convertToSumTree(root);
	}

	private int convertToSumTree(Node root) {
		if (root == null)
			return 0;

		return root.value = root.value + convertToSumTree(root.leftChild) + convertToSumTree(root.rightChild);
	}

}
