public class MinPriorityQueue {
  private int size;
  private MinHeap heap;

  public MinPriorityQueue(int capacity) {
    this.size = capacity;
    this.heap = new MinHeap(size);
  }

  public void enqueue(String value, int priority) {
    heap.insert(value, priority);
  }

  public void dequeue() {
    heap.remove();
  }

  public boolean isFull() {
    return heap.isFull();
  }

  public boolean isEmpty() {
    return heap.isEmpty();
  }
}
