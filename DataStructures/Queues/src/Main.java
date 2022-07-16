import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {

        // It's an interface implementation, so we can't instantiate it directly, but we
        // can use the class built around this interface. One of them is ArrayDeque.
        // (Double ended queue)
        // Queue<Integer> queue = new ArrayDeque<>();
        // queue.add(1);
        // queue.add(2);
        // queue.add(3);
        // queue.add(4);
        // System.out.println(queue);
        // var front = queue.remove();
        // System.out.println(front);
        // queue.peek();
        // reverse(queue);
        // System.out.println(queue);
        // Queue<String> queue2 = new ArrayDeque<>();
        // queue2.add("Java");
        // queue2.add("JavaScript");
        // queue2.add("TypeScript");
        // queue2.add("C");
        // System.out.println(queue2.peek());
        // reverseStrQueue(queue2);
        // System.out.println(queue2);

        // var queue3 = new ArrayQueue(5);
        // queue3.enqueue(4);
        // queue3.enqueue(3);
        // queue3.enqueue(5);
        // System.out.println(queue3.peek());
        // System.out.println(queue3.toString());
        // queue3.dequeue();
        // queue3.dequeue();
        // queue3.dequeue();
        // System.out.println(queue3);

        // // circular queues
        // var queue4 = new ArrayQueue(5);
        // queue4.circularEnqueue(10);
        // queue4.circularEnqueue(20);
        // queue4.circularEnqueue(30);
        // queue4.circularEnqueue(40);
        // queue4.circularEnqueue(50);
        // System.out.println(queue4.toString());
        // queue4.circularDequeue();
        // queue4.circularEnqueue(60);
        // // queue4.circularEnqueue(70);
        // System.out.println(queue4.toString());

        // // Queue using Stack
        // var sQueue = new StackQueue(4);
        // sQueue.enqueue(10);
        // sQueue.enqueue(20);
        // sQueue.enqueue(30);
        // System.out.println(sQueue.peek());
        // sQueue.dequeue();
        // sQueue.dequeue();
        // System.out.println(sQueue.dequeue());

        // // Inbuilt Priority Queues
        // PriorityQueue<Integer> pQueue = new PriorityQueue<>();
        // pQueue.add(1);
        // pQueue.add(5);
        // pQueue.add(3);
        // pQueue.add(2);
        // while (!pQueue.isEmpty())
        // System.out.println(pQueue.remove());

        // // Custom Priority Queues with Array
        // var cPQueue = new PriorityQueues(5);
        // cPQueue.insert(7);
        // cPQueue.insert(8);
        // cPQueue.insert(1);
        // cPQueue.insert(2);
        // cPQueue.insert(12);
        // while (!cPQueue.isEmpty())
        // System.out.println(cPQueue.remove());

        // System.out.println(cPQueue.toString());

        // Input: Q = [10, 20, 30, 40, 50], K = 3
        // Output: Q = [30, 20, 10, 40, 50]
        // QueueReverser queueReverser = new QueueReverser();
        // var k = 3;
        // Queue<Integer> queue = new ArrayDeque<>();
        // queue.add(10);
        // queue.add(20);
        // queue.add(30);
        // queue.add(40);
        // queue.add(50);
        // queueReverser.reverseK(queue, k);
        // System.out.println(queue.toString());

        // LinkedList implementation of Queue
        // LinkedListQueue queue = new LinkedListQueue();
        // queue.enqueue(10);
        // queue.enqueue(20);
        // queue.enqueue(30);
        // System.out.println(queue.dequeue());
        // System.out.println(queue);
        // System.out.println(queue.peek());
        // queue.enqueue(40);
        // queue.enqueue(50);
        // System.out.println(queue + "\tSize of queue: " + queue.size());

        // Stack with 2 Queues
        StackWithTwoQueues stack = new StackWithTwoQueues(6);
        stack.push(40);
        stack.push(50);
        stack.push(60);
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.popAlter());
        System.out.println(stack.toString() + " size: " + stack.size());
        stack.push(70);
        stack.push(80);
        System.out.println(stack.toString() + " size: " + stack.size());
    }

    // Reverse a Queue of integers
    public static void reverse(Queue<Integer> queue) {
        Stack<Integer> stack = new Stack<>();
        if (queue.isEmpty())
            throw new IllegalStateException();
        while (!queue.isEmpty())
            stack.push(queue.remove());
        while (!stack.isEmpty())
            queue.add(stack.pop());
    }

    // Reverse a Queue of string
    public static void reverseStrQueue(Queue<String> queue) {
        Stack<String> stack = new Stack<>();
        if (queue.isEmpty())
            throw new IllegalStateException();
        while (!queue.isEmpty())
            stack.push(queue.remove());
        while (!stack.isEmpty())
            queue.add(stack.pop());
    }

}
