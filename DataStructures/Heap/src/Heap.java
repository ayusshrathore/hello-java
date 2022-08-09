import java.util.Arrays;

public class Heap {
  private int size;
  private int count = 0;
  private int[] array;

  public Heap(int size) {
    this.size = size;
    this.array = new int[size];
  }

  public void insert(int item) {
    if (isFull())
      throw new IllegalStateException();

    array[count++] = item;

    bubbleUp();
  }

  public int remove() {
    if (isEmpty())
      throw new IllegalStateException("Array is empty");

    var root = array[0];
    array[0] = array[--count];
    int index = 0;

    // while root < childrens
    bubbleDown(index);

    return root;
  }

  public String sort(int[] array, boolean ascending) {
    for (int i = 0; i < array.length; i++)
      insert(array[i]);

    if (ascending)
      for (int i = array.length - 1; i >= 0; i--)
        array[i] = remove();
    else
      for (int i = 0; i < array.length; i++)
        array[i] = remove();

    return Arrays.toString(array);
  }

  private void bubbleDown(int index) {
    while (!isValidParent(index) && index <= count) {
      var largerChildIndex = getLargerChildIndex(index);
      swap(index, largerChildIndex);
      index = largerChildIndex;
    }
  }

  private int getLargerChildIndex(int index) {
    if (!hasLeftChild(index))
      return index;

    if (!hasRightChild(index))
      return lefChildIndex(index);

    return leftChild(index) > rightChild(index) ? lefChildIndex(index) : rightChildIndex(index);
  }

  private boolean isValidParent(int index) {
    if (!hasLeftChild(index))
      return true;

    var isValid = array[index] >= leftChild(index);
    if (hasRightChild(index))
      return isValid &= array[index] >= rightChild(index);

    return isValid;
  }

  private boolean hasRightChild(int index) {
    return rightChildIndex(index) <= count;
  }

  private boolean hasLeftChild(int index) {
    return lefChildIndex(index) <= count;
  }

  private int leftChild(int index) {
    return array[lefChildIndex(index)];
  }

  private int rightChild(int index) {
    return array[rightChildIndex(index)];
  }

  private int rightChildIndex(int index) {
    return index * 2 + 2;
  }

  private int lefChildIndex(int index) {
    return index * 2 + 1;
  }

  public boolean isEmpty() {
    return count == 0;
  }

  public boolean isFull() {
    return count == size;
  }

  private void bubbleUp() {
    for (int i = count - 1; i >= 0; i--)
      if (i > 0 && array[i] > array[parent(i)])
        swap(i, parent(i));
  }

  private int parent(int i) {
    return (i - 1) / 2;
  }

  private void swap(int a, int b) {
    int temp = array[a];
    array[a] = array[b];
    array[b] = temp;
  }

  public int max() {
    if (isEmpty())
      throw new IllegalStateException("Array is empty!");

    return array[0];
  }

  @Override
  public String toString() {
    return Arrays.toString(Arrays.copyOfRange(array, 0, count));
  }
}
