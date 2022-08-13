import java.util.ArrayList;

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

	public void getAncestors(int value) {
		if (!find(value))
			throw new IllegalStateException("Value doesn't exists!");

		getAncestors(root, value);
	}

	private boolean getAncestors(Node root, int value) {
		if (root == null)
			return false;

		if (root.value == value)
			return true;

		if (getAncestors(root.leftChild, value) || getAncestors(root.rightChild, value)) {
			System.out.print(root.value + " ");
			return true;
		}
		return false;
	}

	// alternative approach to areSiblings
	public boolean haveSameParent(int first, int second) {
		return haveSameParent(root, first, second);
	}

	public boolean haveSameParent(Node root, int first, int second) {
		if (root == null)
			return false;

		var haveSameParent = false;
		if (root.leftChild != null && root.rightChild != null)
			haveSameParent = (root.leftChild.value == first && root.rightChild.value == second) ||
					(root.rightChild.value == first || root.leftChild.value == second);

		return haveSameParent ||
				haveSameParent(root.leftChild, first, second) ||
				haveSameParent(root.rightChild, first, second);
	}

	public boolean areSiblings(int first, int second) {
		if (root == null)
			throw new IllegalStateException("Tree is empty!");

		if (!find(first) && !find(second))
			return false;

		var parent = 0;
		return checkIfSiblings(first, root, parent) == checkIfSiblings(second, root, parent)
				&& getDepth(first) == getDepth(second);
	}

	private int checkIfSiblings(int value, Node root, int parent) {
		if (root.leftChild == null || root.rightChild == null)
			return parent;

		if (root.value == value)
			return parent;

		parent = root.value;
		checkIfSiblings(value, root.leftChild, parent);
		checkIfSiblings(value, root.rightChild, parent);

		return parent;
	}

	public boolean contains(int value) {
		return contains(root, value);
	}

	private boolean contains(Node root, int value) {
		if (root == null)
			return false;

		if (root.value == value)
			return true;

		if (root.value > value)
			return contains(root.leftChild, value);
		else
			return contains(root.rightChild, value);

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

	public int countLeaves() {
		return countLeaves(root);
	}

	private int countLeaves(Node root) {
		if (root == null)
			return 0;

		if (isLeafNode(root))
			return 1;

		return countLeaves(root.leftChild) + countLeaves(root.rightChild);
	}

	public boolean isTreeBalanced() {
		return isTreeBalanced(root);
	}

	private boolean isTreeBalanced(Node root) {
		if (root == null)
			return true;

		return Math.abs(height(root.leftChild) - height(root.rightChild)) <= 1 &&
				isTreeBalanced(root.leftChild) &&
				isTreeBalanced(root.rightChild);
	}

	public boolean isPerfect() {
		return size() == (Math.pow(2, height() + 1) - 1);
	}

	public int getDepth(int value) {
		if (!find(value))
			throw new IllegalStateException("Value doesn't exists!");

		return getDepth(root, value, 0);
	}

	private int getDepth(Node root, int value, int count) {
		var current = root;
		while (current.leftChild != null) {
			if (current.value == value)
				return count;
			current = current.leftChild;
			count++;
		}
		count = 0;
		current = root;
		while (current.rightChild != null) {
			if (current.value == value)
				return count;
			current = current.rightChild;
			count++;
		}
		return count;
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

	public int size() {
		return size(root);
	}

	private int size(Node root) {
		if (root == null)
			return 0;

		if (isLeafNode(root))
			return 1;

		return 1 + size(root.leftChild) + size(root.rightChild);
	}

	public int min() {
		return min(root);
	}

	public int maxBST() {
		var value = 0;
		return maxBST(root, value);
	}

	private int maxBST(Node root, int value) {
		if (root == null)
			throw new IllegalStateException("Tree is empty!");

		if (root.rightChild == null)
			return root.value;

		return maxBST(root.rightChild, value);
	}

	public int max() {
		return max(root);
	}

	private int max(Node root) {
		if (root == null)
			throw new IllegalStateException("Tree is empty!");

		if (countLeaves(root) == 1)
			return root.value;

		if (root.leftChild == null || root.rightChild == null)
			return root.value;

		return Math.max(max(root.leftChild), max(root.rightChild));

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
