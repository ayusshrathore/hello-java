import java.util.Arrays;

public class Search {
  private int[] array;
  private int size;

  public Search(int[] array) {
    this.array = array;
    this.size = array.length;
  }

  public int linearSearch(int item) {
    var index = -1;

    for (int i = 0; i < size; i++)
      if (array[i] == item)
        return index = i;

    return index;
  }

  public int recursiveBinarySearch(int item) {
    int left = 0;
    int right = size - 1;

    Arrays.sort(array);

    return partitionArray(left, right, item);
  }

  public int iterativeBinarySearch(int item) {
    int left = 0;
    int right = size - 1;
    int index = -1;

    while (left <= right) {
      int mid = (left + right) / 2;

      if (array[mid] == item)
        return index = mid;

      if (array[mid] < item)
        left = mid + 1;

      if (array[mid] > item)
        right = mid - 1;
    }

    return index;
  }

  public int ternarySearch(int item) {
    Arrays.sort(array);
    return ternarySearch(0, size - 1, item);
  }

  private int ternarySearch(int left, int right, int item) {
    int partitionSize = (size - 1) / 3;
    int mid1 = left + partitionSize;
    int mid2 = right - partitionSize;

    if (left > right)
      return -1;

    if (array[mid1] == item)
      return mid1;

    if (array[mid2] == item)
      return mid2;

    if (array[mid1] < item)
      return ternarySearch(left, mid1 - 1, item);

    if (array[mid2] < item)
      return ternarySearch(mid2 + 1, right, item);

    return ternarySearch(mid1 + 1, mid2 - 1, item);
  }

  public int jumpSearch(int item) {
    int blockSize = (int) Math.sqrt(array.length);
    int start = 0;
    int next = blockSize;

    while (start < array.length &&
        array[next - 1] < item) {
      start = next;
      next += blockSize;
      if (next > array.length)
        next = array.length;
    }

    for (var i = start; i < next; i++)
      if (array[i] == item)
        return i;

    return -1;
  }

  public int exponentialSearch(int item) {
    int bound = 1;

    while (bound < size && array[bound] < item)
      bound *= 2;

    int left = bound / 2;
    int right = Math.min(bound, size - 1);

    return partitionArray(left, right, item);
  }

  // ================== utility method ======================
  private int partitionArray(int left, int right, int item) {

    int mid = (left + right) / 2;

    if (left > right)
      return -1;

    if (array[mid] == item)
      return mid;

    if (array[mid] < item)
      return partitionArray(mid + 1, right, item);

    return partitionArray(left, mid - 1, item);

  }
}
