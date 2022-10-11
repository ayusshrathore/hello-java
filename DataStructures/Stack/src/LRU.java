import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class LRU {
  public static void main(String[] args) throws Exception {

    /**
     * LRU Cache
     * 
     * Design a data structure that follows the constraints of a Least Recently Used
     * (LRU) cache.
     * 
     * Implement the LRUCache class:
     * 
     * LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
     * int get(int key) Return the value of the key if the key exists, otherwise
     * return -1.
     * void put(int key, int value) Update the value of the key if the key exists.
     * Otherwise, add the key-value pair to the cache. If the number of keys exceeds
     * the capacity from this operation, evict the least recently used key.
     * The functions get and put must each run in O(1) average time complexity.
     * 
     * Example 1:
     * 
     * Input
     * ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
     * [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
     * Output
     * [null, null, null, 1, null, -1, null, -1, 3, 4]
     * 
     * Explanation
     * LRUCache lRUCache = new LRUCache(2);
     * lRUCache.put(1, 1); // cache is {1=1}
     * lRUCache.put(2, 2); // cache is {1=1, 2=2}
     * lRUCache.get(1); // return 1
     * lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
     * lRUCache.get(2); // returns -1 (not found)
     * lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
     * lRUCache.get(1); // return -1 (not found)
     * lRUCache.get(3); // return 3
     * lRUCache.get(4); // return 4
     */
    LRUCache lRUCache = new LRUCache(2);
    // lRUCache.put(1, 1);
    // lRUCache.put(2, 2);

    System.out.println(lRUCache.get(2));
    lRUCache.put(2, 6);
    System.out.println(lRUCache.get(1));
    System.out.println(lRUCache.toString());
    lRUCache.put(1, 5);
    lRUCache.put(1, 2);
    System.out.println(lRUCache.toString());
    System.out.println(lRUCache.get(1));
    System.out.println(lRUCache.get(2));

  }

  static class LRUCache {
    int size = 0;

    class Node {
      Node next;
      Node pre;
      int key;
      int value;
    }

    Node head;
    Node tail;

    Map<Integer, LRUCache.Node> map = new HashMap<>();

    public LRUCache(int capacity) {
      head = new Node();
      tail = new Node();
      size = capacity;
      head.key = 0;
      head.value = 0;
      tail.key = 0;
      tail.value = 0;
      tail.pre = head;
      head.next = tail;
      tail.next = null;
      head.pre = null;
    }

    public int get(int key) {
      if (map.isEmpty() || !map.containsKey(key))
        return -1;

      var desiredNode = map.get(key);
      var newNode = new Node();
      newNode.key = desiredNode.key;
      newNode.value = desiredNode.value;

      // remove lru
      desiredNode.pre.next = desiredNode.next;
      desiredNode.next.pre = desiredNode.pre;

      // add desired node to next of head;
      var next = head.next;
      head.next = newNode;
      newNode.next = next;
      next.pre = newNode;
      newNode.pre = head;
      map.put(key, newNode);

      return map.get(key).value;
    }

    public void put(int key, int value) {
      // if LRUCache is not full
      if (map.size() < size) {
        // & map contains key
        if (map.containsKey(key)) {
          var node = map.get(key);
          node.pre.next = node.next;
          node.next.pre = node.pre;
        }

        var newNode = new Node();
        var next = head.next;
        newNode.key = key;
        newNode.value = value;
        head.next = newNode;
        newNode.next = next;
        newNode.next.pre = newNode;
        newNode.pre = head;
        map.put(key, newNode);
      }

      else if (map.size() >= size) {
        if (!map.containsKey(key)) {
          // remove lru first
          var node = tail.pre;
          node.pre.next = node.next;
          node.next.pre = node.pre;
          map.remove(node.key);

        } else if (map.containsKey(key)) {
          // get node wherever it exists
          var node = map.get(key);
          node.pre.next = node.next;
          node.next.pre = node.pre;

          // remove this node from map
          map.remove(key);
        }

        // add new node with new set of key and value
        var newNode = new Node();
        var next = head.next;
        head.next = newNode;
        newNode.key = key;
        newNode.value = value;
        newNode.next = next;
        next.pre = newNode;
        newNode.pre = head;
        map.put(key, newNode);
      }
    }

    @Override
    public String toString() {
      return map.toString();
    }
  }
}
