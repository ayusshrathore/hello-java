import java.util.Arrays;

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
