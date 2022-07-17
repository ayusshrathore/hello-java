import java.util.Arrays;

public class MinimumStack {
    /**
     * |----------------------------------------------------------------------
     * | 2- Design a stack that supports push, pop and retrieving the minimum
     * | value
     * |----------------------------------------------------------------------
     */

    private int top;
    private int[] stack;
    private int smallest;

    public MinimumStack(int size) {
        if (size <= 0)
            throw new IllegalStateException("Size must be greater than zero!");

        this.stack = new int[size];
        this.top = -1;
    }

    public void push(int item) {
        if (isFull())
            throw new StackOverflowError();

        stack[++top] = item;
        smallest = top == 0 ? item : smallest > item ? item : smallest;

    }

    public int pop() {
        if (isEmpty())
            throw new IllegalStateException("Stack Underflow error");

        var topOfStack = stack[top--];

        if (smallest == topOfStack) {
            smallest = stack[top];
            for (int i = 0; i <= top; i++)
                smallest = smallest > stack[i] ? stack[i] : smallest;
        }

        return topOfStack;
    }

    public int min() {
        return smallest;
    }

    public boolean isFull() {
        return top == stack.length;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    @Override
    public String toString() {
        var content = Arrays.copyOfRange(stack, 0, top + 1);
        return Arrays.toString(content);
    }
}
