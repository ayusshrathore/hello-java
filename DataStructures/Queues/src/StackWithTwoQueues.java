import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class StackWithTwoQueues {
    /**
     * |-----------------------------------------------------------------------
     * | 3- Build a stack using two queues. Implement the following operations
     * and calculate their runtime complexities.
     * - push
     * - pop
     * - peek
     * - size
     * - isEmpty
     * |-----------------------------------------------------------------------
     */

    // Q1: [5]
    // Q2: [1, 2, 3, 4]
    private Queue<Integer> queue1 = new ArrayDeque<>();
    private Queue<Integer> queue2 = new ArrayDeque<>();
    private int size;
    private int top;
    private int count;

    public StackWithTwoQueues(int size) {
        this.size = size;
    }

    public void push(int value) {
        if (isFull())
            throw new StackOverflowError();

        queue1.add(value);
        top = value;
        count++;
    }

    public int pop() {
        if (isEmpty())
            throw new IllegalStateException();

        // Q1: [5]
        // Q2: [1, 2, 3, 4]
        var ele = 0;
        for (int i = 0; i < count; i++) {
            ele = queue1.remove();
            if (i != count - 1)
                queue2.add(ele);
        }

        while (!queue2.isEmpty())
            queue1.add(queue2.remove());

        count--;
        return ele;
    }

    // alternative
    public int popAlter() {
        if (isEmpty())
            throw new IllegalStateException();

        while (queue1.size() > 1) {
            top = queue1.remove();
            queue2.add(top);
        }

        swapQueues();

        count--;
        return queue2.remove();
    }

    private void swapQueues() {
        var temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }

    public int size() {
        return count;
    }

    public int peek() {
        return top;
    }

    public boolean isEmpty() {
        return queue1.isEmpty();
    }

    public boolean isFull() {
        return count > size - 1;
    }

    @Override
    public String toString() {
        return queue1.toString();
    }
}
