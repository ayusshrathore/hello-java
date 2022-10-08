import java.rmi.server.RemoteServer;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class StackWith1Queue {
  private Queue<Integer> queue = new LinkedList<>();

  public static void main(String[] args) throws Exception {

    /**
     * Implement Stack using Queues
     * 
     * Implement a last-in-first-out (LIFO) stack using only two queues. The
     * implemented stack should support all the functions of a normal stack (push,
     * top, pop, and empty).
     * 
     * Implement the MyStack class:
     * 
     * void push(int x) Pushes element x to the top of the stack.
     * int pop() Removes the element on the top of the stack and returns it.
     * int top() Returns the element on the top of the stack.
     * boolean empty() Returns true if the stack is empty, false otherwise.
     */
    System.out.println();

    StackWith1Queue queue = new StackWith1Queue();
    // queue.push(1);
    // queue.push(2);
    // queue.push(3);
    queue.pop();
    System.out.println(queue.toString());
    System.out.println(queue.isEmpty());
  }

  public void push(int val) {
    // val -> 5
    // 1 2 3 4
    // <-------> size = 4 add 5, 1 2 3 4 5
    // 2 3 4 5 1
    // 3 4 5 1 2
    // 4 5 1 2 3
    // 5 4 1 2 3

    int size = queue.size();

    queue.add(val);

    for (int index = 0; index < size; index++)
      queue.add(queue.remove());
  }

  public int pop() {
    if (isEmpty())
      return -1;

    return queue.remove();
  }

  public int top() {
    if (isEmpty())
      return -1;

    return queue.peek();
  }

  public boolean isEmpty() {
    return queue.size() == 0;
  }

  @Override
  public String toString() {
    return queue.toString();
  }
}
