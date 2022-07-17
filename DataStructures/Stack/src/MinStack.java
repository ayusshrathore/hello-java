public class MinStack {
    /**
     * |----------------------------------------------------------------------
     * | 2- Design a stack that supports push, pop and retrieving the minimum
     * | value in constant time.
     * |----------------------------------------------------------------------
     */
    private int size;

    public MinStack(int size) {
        this.size = size;
    }

    private customStack stack = new customStack(size);
    private customStack minStack = new customStack(size);

    public void push(int item) {
        if (stack.isFull())
            throw new StackOverflowError();

        stack.push(item);
        if (minStack.isEmpty())
            minStack.push(item);
        else if (item < minStack.peek())
            minStack.push(item);
    }

    public int pop() {
        if (stack.isEmpty())
            throw new IllegalStateException();

        var top = stack.pop();

        if (minStack.peek() == top)
            minStack.pop();

        return top;
    }

    public int min() {
        return minStack.peek();
    }
}
