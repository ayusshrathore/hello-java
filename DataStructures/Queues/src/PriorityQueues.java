import java.util.Arrays;

/**
 * With implementing Priority Queues with Heap we can increase the insertion
 * rate but removing a item is slowed down
 * as in heap if we remove the root node and replace the last node with the root
 * node we need to bubble it down till it reaches it's correct position, so in
 * worst case it could be = length of the tree which is = O(log n)
 * 
 * Priority Queue with Heap
 * Insertion: O(log n) as if (root < children) max value bubbles up, worst
 * case -> upto entire tree length)*
 * Deletion: O(log n)
 * 
 * Priority Queue with Array
 * Insertion: O(n)
 * Deletion: O(1) as we only reduce the size no actual removal
 */
public class PriorityQueues {
    private int size;
    private int[] Queues;
    private int count;

    public PriorityQueues(int size) {
        this.size = size;
        this.Queues = new int[size];
    }

    // [3, 4, 0, 0, 0] insert(2)
    // [3, 2, 4, 0, 0]

    public void insert(int value) {
        if (isFull())
            throw new IllegalStateException("Priority Queue is full!");

        int pos = shifItemsToInsert(value);
        Queues[pos] = value;
        count++;
    }

    private int shifItemsToInsert(int value) {
        int i;
        for (i = count - 1; i >= 0; i--) {
            if (Queues[i] > value)
                Queues[i + 1] = Queues[i];
            else
                break;
        }
        return i + 1;
    }

    public int remove() {
        if (isEmpty())
            throw new IllegalStateException("Priority Queue is empty!");

        return Queues[--count];
    }

    public boolean isFull() {
        return count > size - 1;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public String toString() {
        return Arrays.toString(Queues);
    }
}
