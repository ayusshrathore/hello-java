// Wrapper around Heap Class
public class PriorityQueue {
  private int size;
  private Heap heap;

  public PriorityQueue(int capacity) {
    this.size = capacity;
    this.heap = new Heap(size);
  }

  public void enqueue(int item) {
    heap.insert(item);
  }

  public int dequeue() {
    return heap.remove();
  }

  public boolean isEmpty() {
    return heap.isEmpty();
  }

  public boolean isFull() {
    return heap.isFull();
  }

  public String toString() {
    return heap.toString();
  }
}
