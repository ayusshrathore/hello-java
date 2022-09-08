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

        LinkList list4 = new LinkList();
        list4.addFirst(1);
        list4.addFirst(2);
        list4.addFirst(3);
        list4.addFirst(4);
        list4.addFirst(5);
        list4.addFirst(6);
        list4.fetchMiddle();

        /**
         * Merge two sorted Linked List
         */
        LinkList list5 = new LinkList();
        LinkList list6 = new LinkList();
        // list5.addLast(9);
        // list5.addLast(10);
        // list5.addLast(11);
        // list5.addLast(12);
        // list6.addLast(7);
        // list6.addLast(8);
        // list6.addLast(9);
        // list6.addLast(10);
        list5.addLast(1);
        list5.addLast(2);
        list5.addLast(4);
        list6.addLast(1);
        list6.addLast(3);
        list6.addLast(4);
        list5.mergeLinkList(list6, list5).print();

        LinkList list7 = new LinkList();
        list7.addLast(1);
        list7.addLast(2);
        list7.addLast(3);
        list7.addLast(4);
        list7.addLast(5);
        // list7.removeKthFromLast(4);
        System.out.println(list7.getKthFromLast(2));
        list7.removeKthFromLast(5);
        list7.print();

        LinkList list8 = new LinkList();
        LinkList list9 = new LinkList();
        // list8.addLast(9);
        // list8.addLast(9);
        // list8.addLast(9);
        // list8.addLast(9);
        // list8.addLast(9);
        // list8.addLast(9);
        // list8.addLast(9);
        // list9.addLast(9);
        // list9.addLast(9);
        // list9.addLast(9);
        // list9.addLast(9);
        list8.addLast(2);
        list8.addLast(4);
        list8.addLast(3);
        list9.addLast(5);
        list9.addLast(6);
        list9.addLast(4);
        list8.addTwoNumbers(list9, list8);
        System.out.println(Arrays.toString(list8.addTwoNumbers(list9, list8).toArray()));

        LinkList ls = new LinkList();
        ls.addLast(1);
        ls.addLast(2);
        ls.addLast(1);
        ls.addLast(1);
        System.out.println(ls.isPalindrome(ls));

        LinkList lst = new LinkList();
        lst.addLast(1);
        lst.addLast(2);
        lst.addLast(3);
        lst.addLast(4);
        lst.addLast(5);
        lst.reverseInKGroups(lst, 3).print();
        ;
    }
}
