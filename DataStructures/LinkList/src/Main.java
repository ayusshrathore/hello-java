import java.util.Arrays;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws Exception {
        /**
         * |--------------------------------------------------
         * Linked List with generic types
         * LinkedList<String> list = new LinkedList<>();
         * LinkedList<Integer> list2 = new LinkedList<>();
         * |--------------------------------------------------
         */

        /**
         * Derived from java.util.LinkedList
         */
        LinkedList<Integer> list = new LinkedList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.addFirst(5);
        list.removeLast();
        list.remove(2);
        System.out.println(list);
        System.out.println(list.contains(10));
        System.out.println(list.indexOf(10));
        System.out.println(list.size());

        var array = list.toArray();
        System.out.println(Arrays.toString(array));

        /**
         * Customized LinkedList
         */

        LinkList list2 = new LinkList();
        list2.addLast(2);
        list2.addLast(3);
        list2.addLast(4);
        list2.addLast(4);
        list2.addLast(5);
        list2.print();
        list2.reverse();
        list2.print();
        list2.reverseLinkedList();
        list2.print();
        var kThElement = list2.getKthElementFromLast(1);
        System.out.println(kThElement);
        var knode = list2.getKthFromLast(-1);
        System.out.println(knode);
        list2.fetchMiddle();

        var list3 = list2.createWithLoop();
        System.out.println(list3.containsLoop());

    }
}
