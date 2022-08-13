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
        // tree3.swapRoot();
        System.out.println(tree3.isBinarySearchTree());
        System.out.println(tree.getNodesAtKDistance(2));

        tree.levelOrderTraversal();

        /**
         * 1- Implement a method to calculate the size of a binary tree.
         */
        System.out.println(tree.size());
        System.out.println(tree2.size());
        System.out.println(tree3.size());

        /**
         * 2- Implement a method to count the number of leaves in a binary tree.
         */
        System.out.println(tree.countLeaves());
        System.out.println(tree2.countLeaves());
        System.out.println(tree3.countLeaves());

        /**
         * 3- Implement a method to return the maximum value in a binary search
         */
        System.out.println(tree.maxBST());
        System.out.println(tree2.max());
        System.out.println(tree3.max());

        /**
         * 4- Implement a method to check for the existence of a value in a binary
         * tree using recursion. Compare this method with the find() method. The
         */
        System.out.println(tree.contains(9));
        System.out.println(tree2.contains(9));
        System.out.println(tree3.contains(9));

        /**
         * 5- Implement a method to check to see if two values are siblings in a
         */
        System.out.println(tree3.areSiblings(12, 2));
        System.out.println(tree3.getDepth(12));

        /**
         * 6- Implement a method to return the ancestors of a value in a
         */
        tree.getAncestors(8);
        System.out.println();
    }
}
