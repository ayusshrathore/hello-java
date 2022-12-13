import java.util.ArrayList;

public class LinkedListQueue {
    /**
     * |------------------------------------------------------------------
     * 2- Build a queue using a linked list from scratch. Implement the
     * following operations and calculate their runtime complexities.
     * - enqueue -> O(1)
     * - dequeue -> O(1)
     * - peek -> O(1)
     * - size -> O(1)
     * - isEmpty -> O(1)
     * |------------------------------------------------------------------
     */

    private class Node {
        private Node next;
        private int data;

        public Node(int value) {
            this.data = value;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    // addFirst of LinkedList
    public void enqueue(int value) {
        if (value <= 0)
            throw new IllegalArgumentException();

        Node node = new Node(value);

        if (isEmpty())
            head = tail = node;

        else {
            tail.next = node;
            tail = node;
        }
        size++;
    }

    public int dequeue() {
        if (isEmpty())
            throw new IllegalStateException("Queue is Emtpy!");

        if (head == tail) {
            var ele = head.data;
            head = tail = null;
            size--;
            return ele;
        }
        var ele = head.data;
        var second = head;
        head = head.next;
        second.next = null;
        size--;
        return ele;
    }

    public int peek() {
        if (isEmpty())
            throw new IllegalStateException("Queue is Emtpy!");

        return head.data;
    }

    public int size() {
        if (isEmpty())
            throw new IllegalStateException("Queue is Empty!");

        return size;
    }

    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public String toString() {
        ArrayList<Integer> ArrayList = new ArrayList<>();

        Node current = head;

        while (current != null) {
            ArrayList.add(current.data);
            current = current.next;
        }
        return ArrayList.toString();
    }
}
