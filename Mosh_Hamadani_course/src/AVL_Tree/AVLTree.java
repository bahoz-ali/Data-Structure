package AVL_Tree;

public class AVLTree {

	private class AVLNode {
		private int value;
		private int height;
		private AVLNode left;
		private AVLNode right;

		public AVLNode(int value) {
			this.value = value;
		}
	}

	private AVLNode root;

	public void insert(int value) {
		root = insert(root, value);
	}

	private AVLNode insert(AVLNode root, int value) {

		if (root == null)
			return new AVLNode(value);

		if (value < root.value && root.left == null)
			root.left = insert(root.left, value);
		else
			root.left = insert(root.right, value);

		root.height = Math.max(hight(root.left), hight(root.right)) + 1;

		int balanceFacter = balanceFactor(root);

		if (isLeftHeavy(root))
			System.out.println("hi");
		else if (isRightHeavy(root))
			System.out.println("hello");

		return root;
	}

	private boolean isLeftHeavy(AVLNode node) {
		return balanceFactor(node) > 1;
	}

	private boolean isRightHeavy(AVLNode node) {
		return balanceFactor(node) < -1;
	}

	private int balanceFactor(AVLNode node) {
		return (node == null) ? 0 : hight(node.left) - hight(root.right);
	}

	private int hight(AVLNode node) {
		return (node == null) ? -1 : node.height;
	}

}
