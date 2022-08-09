import java.util.Arrays;

public class MaxHeap {
  // 5 3 8 4 1 2
  public static String heapify(int[] array) {
    var lastParent = array.length / 2 - 1;

    for (int i = lastParent; i >= 0; i--)
      heapify(array, i);

    return Arrays.toString(array);

  }

  public static int getKthLargestItem(int[] array, int k) {
    if (k <= 0 || k > array.length)
      throw new IllegalArgumentException("K must lie between 0 & " + array.length);
    Heap heap = new Heap(array.length);
    for (var item : array)
      heap.insert(item);

    var i = 0;
    while (i++ < k - 1)
      heap.remove();

    return heap.max();
  }

  private static void heapify(int[] array, int index) {
    var largerIndex = index;

    var leftIndex = index * 2 + 1;
    var rightIndex = index * 2 + 2;

    if (leftIndex < array.length && array[leftIndex] > array[largerIndex])
      largerIndex = leftIndex;

    if (rightIndex < array.length && array[rightIndex] > array[largerIndex])
      largerIndex = rightIndex;

    if (largerIndex == index)
      return;

    swap(array, index, largerIndex);
    heapify(array, largerIndex);
  }

  private static int parent(int index) {
    return (index - 1) / 2;
  }

  public static String iterativeHeapify(int[] array) {
    for (int i = array.length - 1; i >= 0; i--) {
      if (i > 0 && array[i] > array[parent(i)])
        swap(array, i, parent(i));

    }
    return Arrays.toString(array);
  }

  private static void swap(int[] array, int a, int b) {
    int temp = array[a];
    array[a] = array[b];
    array[b] = temp;
  }
}
