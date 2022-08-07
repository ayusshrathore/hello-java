public class Tree {
  public class AVLNode {
    private int value;
    private int height;
    private AVLNode leftChild;
    private AVLNode rightChild;

    private AVLNode(int value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return "Node=" + value;
    }
  }

  private AVLNode root;

  public void insert(int value) {
    root = insert(root, value);
  }

  private AVLNode insert(AVLNode root, int value) {
    if (root == null)
      return root = new AVLNode(value);

    if (root.value < value)
      root.rightChild = insert(root.rightChild, value);
    else
      root.leftChild = insert(root.leftChild, value);

    setHeight(root);

    return root = detectRotations(root);
  }

  private AVLNode detectRotations(AVLNode root) {

    if (isLeftHeavy(root)) {
      if (balanceFactor(root.leftChild) < 0)
        // attach newRoot to the left of the root
        root.leftChild = leftRotation(root.leftChild);
      return rightRotation(root);
    } else if (isRightHeavy(root)) {
      if (balanceFactor(root.rightChild) > 0)
        // attach newRoot to the right of the root
        root.rightChild = rightRotation(root.rightChild);
      return leftRotation(root);
    }

    return root;
  }

  private AVLNode leftRotation(AVLNode node) {
    var newRoot = node.rightChild;

    node.rightChild = newRoot.leftChild;
    newRoot.leftChild = node;

    setHeight(node);
    setHeight(newRoot);

    return newRoot;
  }

  private AVLNode rightRotation(AVLNode node) {
    var newRoot = node.leftChild;

    node.leftChild = newRoot.rightChild;
    newRoot.rightChild = node;

    setHeight(node);
    setHeight(newRoot);

    return newRoot;
  }

  private void setHeight(AVLNode node) {
    node.height = Math.max(height(root.leftChild), height(root.rightChild)) + 1;
  }

  private boolean isLeftHeavy(AVLNode node) {
    return balanceFactor(node) > 1;
  }

  private boolean isRightHeavy(AVLNode node) {
    return balanceFactor(node) < -1;
  }

  private int balanceFactor(AVLNode node) {
    return height(node.leftChild) - height(node.rightChild);
  }

  private int height(AVLNode node) {
    return node == null ? -1 : node.height;
  }
}
