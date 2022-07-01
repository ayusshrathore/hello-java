import java.util.Arrays;

public class customStack {
    private int[] stack;
    private int top;
    private int capacity;

    public customStack(int capacity) {
        this.capacity = capacity;
        this.stack = new int[capacity];
        this.top = -1;
    }

    public void push(int item) {
        if (top == capacity - 1)
            throw new StackOverflowError("Stack is full");

        stack[++top] = item;
    }

    public int pop() {
        if (isEmpty())
            throw new IllegalStateException();

        return stack[top--];
    }

    public int peek() {
        if (isEmpty())
            throw new IllegalStateException();

        return stack[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public int size() {
        return top + 1;
    }

    @Override
    public String toString() {
        var content = Arrays.copyOfRange(stack, 0, top + 1);
        return Arrays.toString(content);
    }
}
