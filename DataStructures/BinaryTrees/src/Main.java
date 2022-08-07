public class Main {
    public static void main(String[] args) throws Exception {

        Tree tree = new Tree();
        tree.insert(7);
        tree.insert(4);
        tree.insert(9);
        tree.insert(1);
        tree.insert(6);
        tree.insert(8);
        tree.insert(10);
        System.out.println(tree.isBinarySearchTree());

        System.out.println(tree.find(5));
        tree.traversePreOrder();
        System.out.println();
        tree.traverseInOrder();
        System.out.println();
        tree.traversePostOrder();
        System.out.println();
        System.out.println(tree.height());
        System.out.println(tree.min());

        Tree tree2 = new Tree();
        tree2.insert(7);
        tree2.insert(4);
        tree2.insert(9);
        tree2.insert(1);
        tree2.insert(6);
        tree2.insert(8);
        tree2.insert(10);
        System.out.println(tree.equals(tree2));

        Tree tree3 = new Tree();
        tree3.insert(10);
        tree3.insert(12);
        tree3.insert(3);
        tree3.insert(34);
        tree3.insert(2);
        tree3.swapRoot();
        System.out.println(tree3.isBinarySearchTree());

        System.out.println(tree.getNodesAtKDistance(2));

        tree.levelOrderTraversal();

    }
}
