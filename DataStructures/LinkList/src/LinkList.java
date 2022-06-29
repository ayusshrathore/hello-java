import java.util.NoSuchElementException;

public class LinkList {
    // Node class is something which our LinkList class will have internally. it's
    // an implementation detail.
    private class Node {
        private int data;
        private Node next;

        // Constructor for Node class. As a node without any data is not possible,
        // this constructor will keep the node class in the valid state.
        public Node(int data) {
            this.data = data;
        }
    }

    private Node first;
    private Node last;
    private int size;

    // addfirst
    public void addFirst(int data) {
        var node = new Node(data);
        node.next = first;
        first = node;
        if (isEmpty())
            first = last = node;
        size++;

    }

    // addlast
    public void addLast(int data) {
        var node = new Node(data);
        if (isEmpty())
            first = last = node;
        else {
            last.next = node;
            last = node;
        }
        size++;
    }

    private boolean isEmpty() {
        return first == null;
    }

    // removefirst
    public void removeFirst() {
        var second = first.next;

        if (isEmpty())
            throw new NoSuchElementException();

        if (first == last)
            first = last = null;

        else {
            first.next = null;
            first = second;
        }
        size--;
    }

    // removelast
    public void removeLast() {
        if (isEmpty())
            throw new NoSuchElementException();

        if (first == last)
            first = last = null;

        else {
            var previous = getPreviousNode(last);
            last = previous;
            last.next = null;
        }
        size--;
    }

    private Node getPreviousNode(Node node) {
        var current = first;
        while (current != null) {
            if (current.next == node)
                return current;
            current = current.next;
        }
        return null;
    }

    // contains
    public boolean contains(int data) {
        if (indexOf(data) != -1)
            return true;
        return false;
    }

    // indexof
    public int indexOf(int data) {
        var current = first;
        int index = 0;
        while (current != null) {
            if (current.data == data)
                return index;
            current = current.next;
            index++;

        }
        return -1;
    }

    public int size() {
        return size;
    }

    public int[] toArray() {
        var current = first;
        var index = 0;
        int[] array = new int[size];

        while (current != null) {
            array[index++] = current.data;
            current = current.next;
        }
        return array;
    }

    public void reverse() {
        // [10 -> 20 -> 30 -> 40 -> 50]
        // [10 <- 1 <- 40 <- 50]
        if (isEmpty())
            return;

        var current = first.next;
        var previous = first;
        while (current != null) {
            var next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        last = first;
        last.next = null; // since first is still pointing to left most variable, we need to set the last
                          // node's next to null.
        first = previous;
    }

    // alternative way to reverse a linked list.
    public void reverseLinkedList() {
        // [10 -> 20 -> 30 -> 40 -> 50]
        // [10 <- 20 <- 30 <- 40 <- 50]
        if (isEmpty())
            return;

        var current = first;
        Node previous = null;
        while (current != null) {
            var next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        last = first;
        first = previous;
    }

    public int getKthElementFromLast(int k) {
        var current = first;
        var index = size; // if size of the list is known, we can use this variable to get the kth
                          // element.
        if (k <= 0)
            throw new IllegalArgumentException();
        while (current != null) {
            if (index == k)
                return current.data;

            index--;
            current = current.next;
        }
        return -1;
    }

    // alternative way to get kth element from last. with known list size
    public int getKthFromLast(int k) {
        // [1 -> 2 -> 3 -> 4 -> 5]
        // * *
        if (isEmpty())
            throw new IllegalStateException();
        var previous = first;
        var diff = k - 1;
        var current = previous;
        while (diff > 0) {
            if (current.next == null)
                throw new IllegalArgumentException(); // if we reach the end of the list, kth element is out of bounds.
            current = current.next;
            diff--;
        }
        while (current != null) {
            if (current.next == null)
                return previous.data;

            previous = previous.next;
            current = current.next;
        }
        return -1;
    }

    public void print() {
        var current = first;
        System.out.println();
        System.out.print("[");
        while (current != null) {
            if (current.next == null)
                System.out.print(current.data);
            if (current.next != null)
                System.out.print(current.data + ", ");
            current = current.next;
        }
        System.out.print("]");
    }
}
