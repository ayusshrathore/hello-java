import java.util.Stack;

public class QueueWith1Stack {
  Stack<Integer> stack = new Stack<>();

  public static void main(String[] args) throws Exception {

    /**
     * Implement a first in first out (FIFO) queue using only two stacks. The
     * implemented queue should support all the functions of a normal queue (push,
     * peek, pop, and empty).
     * 
     * Implement the MyQueue class:
     * 
     * void push(int x) Pushes element x to the back of the queue.
     * int pop() Removes the element from the front of the queue and returns it.
     * int peek() Returns the element at the front of the queue.
     * boolean empty() Returns true if the queue is empty, false otherwise.
     */
    QueueWith1Stack queue = new QueueWith1Stack();
    queue.push(1);
    queue.push(2);
    queue.push(3);
    System.out.println(queue);
    System.out.println(queue.pop());

  }

  public void push(int x) {
    stack.push(x);
    // 1 2 3 4 5
    for (int i = 0; i < stack.size() - 1; i++)
      stack.push(stack.pop());
  }

  public int pop() {
    if (empty())
      return -1;

    return stack.remove(0);
  }

  public int peek() {
    if (empty())
      return -1;

    return stack.get(0);
  }

  public boolean empty() {
    return stack.isEmpty();
  }

  @Override
  public String toString() {
    return stack.toString();
  }

}
