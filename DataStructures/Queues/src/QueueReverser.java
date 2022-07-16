import java.util.Queue;
import java.util.Stack;

public class QueueReverser {
    // 1- Given an integer K and a queue of integers, write code to reverse the
    // order of the first K elements of the queue.

    private Stack<Integer> stack = new Stack<>();

    public void reverseK(Queue<Integer> queue, int k) {
        if (k <= 0 || k > queue.size())
            throw new IllegalArgumentException();

        // S: [10, 20, 30] Q: [40, 50]
        reverseFirstKElements(queue, k);

        addRemaningItemsToBack(queue, k);
    }

    private void reverseFirstKElements(Queue<Integer> queue, int k) {
        for (int i = 0; i < k; i++)
            stack.push(queue.remove());

        while (!stack.isEmpty())
            queue.add(stack.pop());
    }

    private void addRemaningItemsToBack(Queue<Integer> queue, int k) {
        for (int i = 0; i < queue.size() - k; i++) {
            queue.add(queue.remove());
        }
    }

}