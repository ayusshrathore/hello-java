import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

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

    /**
     * |---------------------------------------------------------
     * | Considering even number of elements in list
     * | No. of nodes (1st pointer) Middle node (2nd pointer)
     * | 2 1, 2
     * | 4 2, 3
     * | 6 3, 4
     * | 8 4, 5
     * | 10 5, 6
     * |
     * | For odd numbers of elements in list
     * | No. of nodes (1st pointer) Middle node (2nd pointer)
     * | 1 1
     * | 3 2
     * | 5 3
     * | 7 4
     * | 9 5
     * | -> increment 1st pointer 2 & 2nd pointer 1 times in both cases
     * |----------------------------------------------------------------
     */

    public void fetchMiddle() {
        if (isEmpty())
            throw new IllegalStateException();

        var a = first;
        var b = first;
        while (b != null && b.next != null) {
            a = a.next;
            b = b.next.next;
        }
        if (b == null)
            System.out.println(a.data + "," + " " + a.next.data);
        else if (b == last)
            System.out.println(a.data);
    }

    public boolean containsLoop() {
        var slow = first;
        var fast = first;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            System.out.println(slow.data);
            if (fast == slow)
                return true;
        }
        return false;
    }

    public LinkList createWithLoop() {
        var list = new LinkList();

        list.addLast(10);
        list.addLast(20);
        list.addLast(30);

        var node = list.last;

        list.addLast(40);

        list.last.next = node;

        return list;
    }

    public LinkList mergeLinkList(LinkList list1, LinkList list2) {
        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;

        if (list1.first.data > list2.first.data)
            swap(list1, list2);

        Node current1 = list1.first;
        Node current2 = list2.first;
        while (current1 != null && current2 != null) {
            Node previous = null;
            while (current1 != null && current1.data <= current2.data) {
                previous = current1;
                current1 = current1.next;
            }
            previous.next = current2;

            Node temp = current1;
            current1 = current2;
            current2 = temp;
        }
        // 1 2 4
        // 1 3 4

        return list1;
    }

    public void removeKthFromLast(int k) {
        // [1 -> 2 -> 3 -> 4 -> 5]
        if (isEmpty())
            throw new IllegalStateException();
        var previous = first;
        var diff = k - 1;
        var current = previous;
        var pre = first;
        var count = 0;

        while (diff > 0) {
            if (current.next == null)
                throw new IllegalArgumentException();
            current = current.next;
            count += 1;
            diff--;
        }
        while (current != null) {
            if (current.next == null)
                pre.next = previous.next;

            pre = previous;
            previous = previous.next;
            count += 1;
            current = current.next;
        }

        if (count == k)
            first = first.next;

    }

    public LinkList addTwoNumbers(LinkList list1, LinkList list2) {
        var carry = 0;
        var sum = 0;
        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;

        Node current1 = list1.first;
        Node current2 = list2.first;
        Node temp1 = list1.first;
        Node temp2 = list2.first;
        LinkList list = new LinkList();
        while (temp2.next != null || temp1.next != null) {
            if (temp1.next == null || temp2.next == null)
                break;
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        if (temp1.next == null) {
            while (temp2.next != null) {
                Node zeros = new Node(0);
                temp1.next = zeros;
                temp2 = temp2.next;
                temp1 = temp1.next;
            }
            temp1.next = null;
        } else if (temp2.next == null) {
            while (temp1.next != null) {
                Node zeros = new Node(0);
                temp2.next = zeros;
                temp1 = temp1.next;
                temp2 = temp2.next;
            }
            temp2.next = null;
        }

        while (current1 != null && current2 != null) {
            sum = current1.data + current2.data + carry;
            System.out.print(sum + " ");
            if (sum >= 10) {
                carry = sum / 10;
                list.addLast(sum % 10);
            } else {
                list.addLast(sum);
                carry = 0;
            }
            current1 = current1.next;
            current2 = current2.next;
        }
        if (sum >= 10) {
            Node newNode = new Node(carry);
            list.last.next = newNode;
        }
        return list;
    }

    public LinkList alternativeAddTwoNumbers(LinkList l1, LinkList l2) {
        Node current1 = l1.first;
        Node current2 = l2.first;
        int carry = 0;
        LinkList list = new LinkList();
        while (current1 != null || l2 != null || carry != 0) {
            int sum = 0;
            if (current1 != null) {
                sum += current1.data;
                current1 = current1.next;
            }

            if (current2 != null) {
                sum += current2.data;
                current2 = current2.next;
            }

            sum += carry;
            carry = sum / 10;
            list.addLast(sum % 10);

        }
        return list;
    }

    public Node getIntersectionNode(LinkList l1, LinkList l2) {
        if (l1 == null || l2 == null)
            return null;
        var current1 = l1.first;
        var current2 = l2.first;

        while (current1.next != null || current2.next != null) {
            if (current1 == current2)
                return current1;
            current1 = current1.next;
            current2 = current2.next;
        }
        return null;
    }

    public LinkList reverseInKGroups(LinkList l, int k) {
        var node = l.first;
        LinkList result = new LinkList();
        int size = 0;
        while (node != null) {
            node = node.next;
            size++;
        }
        node = l.first;
        int count = 0;
        while (node != null) {
            LinkList temp = new LinkList();
            for (int i = 0; i < k; i++) {
                if (node == null)
                    break;

                if (count < size / k)
                    temp.addFirst(node.data);
                else
                    temp.addLast(node.data);

                node = node.next;
            }
            var first = temp.first;
            while (first != null) {
                result.addLast(first.data);
                first = first.next;
            }
            count++;
        }
        return result;
    }

    public boolean isPalindrome(LinkList l) {
        Node head = l.first;
        Node slow = head;
        Node fast = head;

        // fetch mid
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // reverse right half of the linklist
        slow.next = reverseLinkedList(slow.next);

        // making slow to point at right half since it is currently pointing middle
        slow = slow.next;

        // check for palindrome
        while (slow != null) {
            if (slow.data != head.data)
                return false;
            slow = slow.next;
            head = head.next;
        }
        return true;
    }

    private Node reverseLinkedList(Node head) {
        Node previous = null, next = null;

        while (head != null) {
            next = head.next;
            head.next = previous;
            previous = head;
            head = next;
        }
        return previous;
    }

    public void swap(LinkList list1, LinkList list2) {
        var temp = list1;
        list1 = list2;
        list2 = temp;
    }
}
