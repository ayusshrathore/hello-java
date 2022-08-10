import java.util.*;

public class LinkedListProblems {
    public static class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    Node first;
    Node last;
    int size;

    void addLast(int value) {
        var node = new Node(value);

        if (isEmpty())
            first = last = node;
        else {
            last.next = node;
            last = node;
        }
        size++;
    }

    /**
     * Reverse a Linked List
     */
    Node reverse() {
        Node next = null;
        Node prev = null;
        var current = first;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        first = prev;
        return first;
    }

    /**
     * Reverse a Linked List using its head
     */

    static Node reverseFromHead(Node head) {
        Node next = null;
        Node prev = null;
        var current = head;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
        return head;
    }

    /**
     * Reverse a Linked List in groups of k
     */

    void reverseInGroups(int k) {
        var current = first;
        var result = new LinkedListProblems();
        while (current != null) {
            var temp = new LinkedListProblems();
            for (int i = 0; i < k; i++) {
                if (current == null)
                    break;
                temp.addLast(current.value);
                current = current.next;
            }
            temp.reverse();
            var tempCurrent = temp.getFirst();
            while (tempCurrent != null) {
                result.addLast(tempCurrent.value);
                tempCurrent = tempCurrent.next;
            }
        }
        result.printList();
    }

    /**
     * Detect a loop in linked list
     */

    boolean hasLoop(Node first) {
        Node current = first;
        HashSet<Node> set = new HashSet<Node>();
        while (current != null) {
            if (set.contains(current))
                return true;
            else
                set.add(current);
            current = current.next;
        }
        return false;
    }

    /**
     * Print first node of loop
     */

    int firstLoopNode(Node first) {
        Node current = first;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int pos = 0;
        while (current != null) {
            if (map.containsKey(current.value))
                break;
            else {
                map.put(current.value, pos++);
                current = current.next;
            }
        }
        for (var entry : map.entrySet()) {
            return entry.getValue();
        }
        return 0;
    }

    /**
     * Remove duplicates from linked list
     */

    void removeDuplicates() {
        Node current = first;
        Node prev = null;
        Set<Integer> set = new HashSet<Integer>();
        while (current != null) {
            if (set.contains(current.value)) {
                prev.next = current.next;
                current = current.next;
            } else {
                set.add(current.value);
                prev = current;
                current = current.next;
            }
        }
    }

    /**
     * Add 1 to a number represented as linked list
     */

    Node addOne(Node first) {
        Node current = first;
        current.value += 1;
        while (current.next != null && current.value > 9) {
            current.value = 0;
            current.next.value += 1;
            current = current.next;
        }
        return current;
    }

    /**
     * Add two numbers represented by linked lists
     */

    static Node addTwoLists(Node first, Node second) {
        Node current1 = first;
        Node current2 = second;
        Node node = new Node(0);
        Node current = node;
        Node head = node;
        int carry = 0;

        while (current1.next != null && current2.next != null) {
            int sum = current1.value + current2.value + carry;
            if (sum > 9) {
                node.next = node;
                node.value = 0;
                carry = 1;
            } else {
                node.next = node;
                node.value = sum;
                carry = 0;
            }
            current1 = current1.next;
            current2 = current2.next;
        }

        if (current1.next == null) {
            node.value = current2.value;
        } else {
            node.value = current1.value;
        }

        while (current != null) {
            System.out.print(current + " ");
            current = current.next;
        }

        System.out.println();
        return head;
    }

    void printList() {
        System.out.println("Linked List: ");
        var current = first;
        while (current != null) {
            System.out.print(current.value + " ");
            current = current.next;
        }
        System.out.println();
    }

    void printListFromHead(Node head) {
        System.out.println("Linked List: ");
        Node current = head;
        while (current != null) {
            System.out.print(current.value + " ");
            current = current.next;
        }
        System.out.println();
    }

    Node getFirst() {
        return first;
    }

    boolean isEmpty() {
        return first == null;
    }
}
