package Tree;

import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		Tree tree = new Tree();

		tree.insert(7);
		tree.insert(4);
		tree.insert(9);
		tree.insert(1);
		tree.insert(6);
		tree.insert(8);
		tree.insert(10);
		System.out.println("sum = " + tree.convertToSumTree());
		System.out.println("isFound 4: " + tree.find(12));
		System.out.println("isCountain 4: " + tree.contains(12));

		tree.traverseInOrder();
		System.out.println("");
		tree.traversePreOrder();
		System.out.println("");
		tree.traverseLevelOrder();
		System.out.println("");

		System.out.println("Min in BT: " + tree.min());
		System.out.println("Min in BST: " + tree.minInBinarySearchTree());
		System.out.println("Max in BST: " + tree.max());

		System.out.println("Is it BTS: " + tree.isBinarySearchTree());

		ArrayList<Integer> list = tree.getNodesAtDistance(2);
		System.out.println("values at distanc 2: " + list);
		System.out.println("Hight of tree: " + tree.hight());
		System.out.println("size of tree: " + tree.size());
		System.out.println("number of leaves: " + tree.coutLeaves());

		System.out.println("are Sibling: " + tree.areSibling(12, 134));

		Tree tree2 = new Tree();

		tree2.insert(7);
		tree2.insert(4);
		tree2.insert(9);
		tree2.insert(1);
		tree2.insert(6);
		tree2.insert(8);
		tree2.insert(10);
		System.out.println("Are trees equal: " + tree.equals(tree2));
		System.out.println("are trees identicals: " + tree.areTreesIdentical(tree2));
	}
}
