import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class MinHeap {
  private HeapNode[] heap;
  private int size;
  private int count = 0;

  private class HeapNode {
    private int key;
    private String value;

    private HeapNode(String value, int key) {
      this.key = key;
      this.value = value;
    }
  }

  public MinHeap(int size) {
    this.size = size;
    this.heap = new HeapNode[size];
  }

  private HeapNode root;

  public void insert(String value, int priority) {
    if (value == null)
      throw new IllegalArgumentException();

    heap[count++] = new HeapNode(value, priority);
    bubbleUp();
    root = heap[0];
  }

  public HeapNode min() {
    return root;
  }

  private void bubbleUp() {
    for (int i = count - 1; i >= 0; i--)
      if (i > 0 && heap[i].key <= heap[parent(i)].key)
        swap(i, parent(i));
  }

  public HeapNode remove() {
    if (isEmpty())
      throw new IllegalArgumentException("Heap is empty!");

    HeapNode node = heap[0];
    root = node;
    heap[0] = heap[--count];

    int index = 0;
    bubbleDown(index);

    return node;
  }

  private void bubbleDown(int index) {
    while (!isValidParent(index) && index <= count) {
      var smallerChildIndex = getSmallerChildIndex(index);
      swap(index, smallerChildIndex);
      index = smallerChildIndex;
    }
  }

  private int getSmallerChildIndex(int index) {
    if (!hasLeftChild(index))
      return index;

    if (!hasRightChild(index))
      return leftChildIndex(index);

    return rightChild(index).key < leftChild(index).key ? rightChildIndex(index) : leftChildIndex(index);
  }

  private boolean isValidParent(int index) {
    if (!hasLeftChild(index))
      return true;

    var isvalid = heap[index].key <= leftChild(index).key;

    if (hasRightChild(index))
      return isvalid &= heap[index].key <= rightChild(index).key;

    return isvalid;
  }

  private boolean hasLeftChild(int index) {
    return leftChildIndex(index) <= count;
  }

  private boolean hasRightChild(int index) {
    return rightChildIndex(index) <= count;
  }

  private HeapNode leftChild(int index) {
    return heap[leftChildIndex(index)];
  }

  private HeapNode rightChild(int index) {
    return heap[rightChildIndex(index)];
  }

  private int leftChildIndex(int index) {
    return index * 2 + 1;
  }

  private int rightChildIndex(int index) {
    return index * 2 + 2;
  }

  private int parent(int i) {
    return (i - 1) / 2;
  }

  private void swap(int a, int b) {
    HeapNode temp = heap[a];
    heap[a] = heap[b];
    heap[b] = temp;
  }

  public boolean isEmpty() {
    return count == 0;
  }

  public boolean isFull() {
    return count == size;
  }

  @Override
  public String toString() {
    var array = Arrays.copyOfRange(heap, 0, count);
    Map<String, Integer> map = new LinkedHashMap<>();
    for (int i = 0; i < array.length; i++)
      map.put(array[i].value, array[i].key);

    return "[" + map.toString() + "]";
  }

}
