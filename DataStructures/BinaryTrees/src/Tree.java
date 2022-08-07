import java.util.ArrayList;
import java.util.Arrays;

public class Tree {
	public class Node {
		private int value;
		private Node leftChild;
		private Node rightChild;

		private Node(int value) {
			this.value = value;
		}

		@Override
		public String toString() {
			return "Node=" + value;
		}
	}

	private Node root;

	public void insert(int value) {
		var node = new Node(value);

		if (root == null) {
			root = node;
			return;
		}
		var current = root;

		while (true) {
			if (current.value > value) {
				if (current.leftChild == null) {
					current.leftChild = node;
					break;
				}
				current = current.leftChild;
			} else {
				if (current.rightChild == null) {
					current.rightChild = node;
					break;
				}
				current = current.rightChild;
			}
		}
	}

	public boolean find(int value) {
		var current = root;
		while (current != null) {
			if (current.value > value)
				current = current.leftChild;
			else if (current.value < value)
				current = current.rightChild;
			else
				return true;
		}
		return false;
	}

	public void swapRoot() {
		var temp = root.leftChild;
		root.leftChild = root.rightChild;
		root.rightChild = temp;
	}

	public void breadthFirst() {

	}

	public void traversePreOrder() {
		traversePreOrder(root);
	}

	private void traversePreOrder(Node root) {
		if (root == null)
			return;

		System.out.print(root.value + " ");

		traversePreOrder(root.leftChild);
		traversePreOrder(root.rightChild);
	}

	public void traverseInOrder() {
		traverseInOrder(root);
	}

	private void traverseInOrder(Node root) {
		if (root == null)
			return;

		traverseInOrder(root.leftChild);
		System.out.print(root.value + " ");
		traverseInOrder(root.rightChild);
	}

	public void traversePostOrder() {
		traversePostOrder(root);
	}

	private void traversePostOrder(Node root) {

		if (root == null)
			return;

		traversePostOrder(root.leftChild);
		traversePostOrder(root.rightChild);
		System.out.print(root.value + " ");

	}

	private boolean isLeafNode(Node node) {
		return node.leftChild == null && node.rightChild == null;
	}

	public int height() {
		return height(root);
	}

	private int height(Node root) {
		if (root == null)
			return -1;

		if (isLeafNode(root))
			return 0;

		return 1 + Math.max(height(root.leftChild), height(root.rightChild));
	}

	public int min() {
		return min(root);
	}

	// O(n)
	private int min(Node root) {
		if (isLeafNode(root)) {
			return root.value;
		}

		var left = min(root.leftChild);
		var right = min(root.rightChild);

		return Math.min(Math.min(left, right), root.value);
	}

	public int minBS() {
		return minBS(root);
	}

	// O(log n)
	private int minBS(Node root) {
		if (root == null)
			throw new IllegalStateException();

		var current = root;
		var last = root;
		while (current != null) {
			last = current;
			current = current.leftChild;
		}
		return last.value;
	}

	public boolean equals(Tree other) {
		if (other == null)
			return false;
		return equals(root, other.root);
	}

	private boolean equals(Node first, Node second) {
		if (first == null && second == null)
			return true;

		if (first != null && second != null)
			return first.value == second.value && equals(first.leftChild, second.leftChild)
					&& equals(first.rightChild, second.rightChild);

		return false;
	}

	public boolean isBinarySearchTree() {
		return isBinarySearchTree(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
	}

	private boolean isBinarySearchTree(Node root, int max, int min) {
		if (root == null)
			return true;

		if (root.value < min || root.value > max)
			return false;

		return isBinarySearchTree(root.leftChild, root.value - 1, min)
				&& isBinarySearchTree(root.rightChild, max, root.value + 1);
	}

	public ArrayList<Integer> getNodesAtKDistance(int k) {
		ArrayList<Integer> array = new ArrayList<>();
		nodesAtKDistance(array, root, k);

		return array;
	};

	private void nodesAtKDistance(ArrayList<Integer> array, Node root, int distance) {

		if (root == null)
			return;

		if (distance == 0) {
			array.add(root.value);
			return;
		}

		nodesAtKDistance(array, root.leftChild, distance - 1);
		nodesAtKDistance(array, root.rightChild, distance - 1);
	}

	public void levelOrderTraversal() {
		for (var i = 0; i <= height(); i++)
			for (var value : getNodesAtKDistance(i))
				System.out.print(value + " ");
	}
}
