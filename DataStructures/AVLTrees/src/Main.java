public class Main {
    public static void main(String[] args) throws Exception {

        Tree tree = new Tree();
        tree.insert(3);
        tree.insert(2);
        tree.insert(6);
        tree.insert(4);
        tree.insert(9);
        tree.insert(1);
        tree.insert(10);
        tree.insert(11);
        /**
         * Check AVL rotations
         */
        tree.insert(10);
        tree.insert(20);
        tree.insert(30);

        /**
         * Check to see if a binary tree is balanced.
         */
        tree.insert(10);
        tree.insert(20);
        tree.insert(30);
        System.out.println(tree.isBalanced());

        /**
         * 2- Check to see if a binary tree is perfect. In a perfect binary tree, every
         * level (except the last level) is full of nodes.
         * Hint: think about the relationship between the height and size of a
         */
        tree.insert(20);
        tree.insert(30);
        tree.insert(10);
    }
}
