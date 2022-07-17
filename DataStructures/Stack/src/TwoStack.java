import java.util.Arrays;
import java.util.Stack;

public class TwoStack {
    /**
     * |--------------------------------------------------
     * | Implement two stacks in one array. Support these operations:
     * | push1() // to push in the first stack
     * | push2() // to push in the second stack
     * | pop1()
     * | pop2()
     * | isEmpty1()
     * | isEmpty2()
     * | isFull1()
     * | isFull2()
     * |--------------------------------------------------
     */

    private int top1;
    private int top2;
    private int[] stack;

    public TwoStack(int size) {
        if (size <= 0)
            throw new IllegalStateException("Size must be greater than zero!");

        this.top1 = -1;
        this.top2 = size;
        this.stack = new int[size];

    }

    /**
     * [1, 2, 3, 4, 5, 7]
     */
    public void push1(int item) {
        if (isFull1())
            throw new StackOverflowError();

        stack[++top1] = item;
    }

    public void push2(int item) {
        if (isFull2())
            throw new StackOverflowError();

        stack[--top2] = item;
    }

    public int pop1() {
        if (isEmpty1())
            throw new IllegalStateException("Stack Underflow error");

        return stack[top1--];
    }

    public int pop2() {
        if (isFull2())
            throw new IllegalStateException("Stack Underflow error");

        return stack[top2++];
    }

    public boolean isFull1() {
        return top1 + 1 == top2;
    }

    public boolean isEmpty1() {
        return top1 == -1;
    }

    public boolean isFull2() {
        return top2 - 1 == top1;
    }

    public boolean isEmpty2() {
        return top2 == stack.length;
    }

    @Override
    public String toString() {
        return Arrays.toString(stack);
    }
}
