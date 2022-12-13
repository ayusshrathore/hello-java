import java.util.Stack;

// Queue using 2 Stacks enqueue O(1) dequeue O(n) as complexity incerases linearly as size increases
public class QueueWithTwoStacks {
    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();
    private int size;
    private int count;

    public QueueWithTwoStacks(int size) {
        this.size = size;
    }

    // Q [2, 3, 4, 5, 6, 7]
    // S1 [6, 7] enqueue
    // S2 [5, 4, 3, 2] dequeue

    public void enqueue(int value) {
        if (value <= 0)
            throw new IllegalArgumentException();

        if (isFull())
            throw new IllegalStateException("Queue is full!");

        stack1.push(value);
        count++;
    }

    public int dequeue() {
        if (isEmpty())
            throw new IllegalStateException("Stack is empty!");

        moveStack1ToStack2();

        return stack2.pop();
    }

    public boolean isFull() {
        return count > size;
    }

    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    public int peek() {
        if (isEmpty())
            throw new IllegalStateException("Stack is empty!");

        moveStack1ToStack2();

        return stack2.peek();
    }

    private void moveStack1ToStack2() {
        if (stack2.isEmpty())
            while (!stack1.isEmpty())
                stack2.push(stack1.pop());

    }

    @Override
    public String toString() {
        return stack1.toString();
    }
}
