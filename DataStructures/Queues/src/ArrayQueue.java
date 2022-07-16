import java.util.Arrays;

public class ArrayQueue {
    private int[] queue;
    private int front;
    private int rear;
    private int count;

    public ArrayQueue(int size) {
        this.queue = new int[size];
    }

    public void enqueue(int value) {
        if (value <= 0)
            throw new IllegalArgumentException();
        if (isFull())
            throw new IllegalStateException("Queue is full");
        queue[rear++] = value;
    }

    // enqueue for circular queue
    public void circularEnqueue(int value) {
        if (value <= 0)
            throw new IllegalArgumentException();
        if (isCircularFull())
            throw new IllegalStateException("Queue is full");
        queue[rear] = value;
        rear = (rear + 1) % queue.length;
        count++;
    }

    public int dequeue() {
        if (front > rear) {
            front = 0;
            rear = 0;
        }
        if (isEmpty())
            throw new IllegalStateException("Queue is emtpy");

        var item = queue[front];
        queue[front++] = 0;
        return item;
    }

    // dequeue for circular queue
    public int circularDequeue() {
        if (isCircularEmpty())
            throw new IllegalStateException("Queue is emtpy");

        var item = queue[front];
        queue[front] = 0;
        front = (front + 1) % queue.length;
        count--;
        return item;
    }

    public int peek() {
        if (isEmpty())
            return -1;
        return queue[rear - 1];
    }

    public boolean isEmpty() {
        return (front == 0 && rear == 0);
    }

    // isFull for circular queue
    public boolean isCircularEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return (rear == queue.length - 1);
    }

    // isFull for circular queue
    public boolean isCircularFull() {
        return count == queue.length;
    }

    @Override
    public String toString() {
        return Arrays.toString(queue);
    }
}

/**
 * |--------------------------------------------------
 * | Note: For circular queues understand the pattern
 * | 5 -> 0 (pos)
 * | 6 -> 1
 * | 7 -> 2
 * | 8 -> 3
 * | 9 -> 4
 * |10 -> 0
 * | (rear or front / size of the array)
 * | increment the front/rear and divide it with the
 * | length of the array
 * |--------------------------------------------------
 */