import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElement {
  public static void main(String[] args) throws Exception {

    /**
     * Next Greater Element II
     * Given a circular integer array nums (i.e., the next element of
     * nums[nums.length - 1] is nums[0]), return the next greater number for every
     * element in nums.
     * 
     * The next greater number of a number x is the first greater number to its
     * traversing-order next in the array, which means you could search circularly
     * to find its next greater number. If it doesn't exist, return -1 for this
     * number.
     * 
     * Example 1:
     * Input: nums = [1,2,1]
     * Output: [2,-1,2]
     * Explanation: The first 1's next greater number is 2;
     * The number 2 can't find next greater number.
     * The second 1's next greater number needs to search circularly, which is also
     * 2.
     * 
     * Example 2:
     * Input: nums = [1,2,3,4,3]
     * Output: [2,3,4,-1,4]
     */
    System.out.println(Arrays.toString(nextGreaterElementsII(new int[] { 1, 2, 3, 4, 3 })));

    /**
     * Next Greater I
     * The next greater element of some element x in an array is the first greater
     * element that is to the right of x in the same array.
     * 
     * You are given two distinct 0-indexed integer arrays nums1 and nums2, where
     * nums1 is a subset of nums2.
     * 
     * For each 0 <= i < nums1.length, find the index j such that nums1[i] ==
     * nums2[j] and determine the next greater element of nums2[j] in nums2. If
     * there is no next greater element, then the answer for this query is -1.
     * 
     * Return an array ans of length nums1.length such that ans[i] is the next
     * greater element as described above.
     * 
     * Example 1:
     * Input: nums1 = [4,1,2], nums2 = [1,3,4,2]
     * Output: [-1,3,-1]
     * Explanation: The next greater element for each value of nums1 is as follows:
     * - 4 is underlined in nums2 = [1,3,4,2]. There is no next greater element, so
     * the answer is -1.
     * - 1 is underlined in nums2 = [1,3,4,2]. The next greater element is 3.
     * - 2 is underlined in nums2 = [1,3,4,2]. There is no next greater element, so
     * the answer is -1.
     * 
     * Example 2:
     * Input: nums1 = [2,4], nums2 = [1,2,3,4]
     * Output: [3,-1]
     * Explanation: The next greater element for each value of nums1 is as follows:
     * - 2 is underlined in nums2 = [1,2,3,4]. The next greater element is 3.
     * - 4 is underlined in nums2 = [1,2,3,4]. There is no next greater element, so
     * the answer is -1.
     */
    System.out.println(Arrays.toString(nextGreaterElement(new int[] { 4, 1, 2 }, new int[] { 1, 3, 4, 2 })));
  }

  public static int[] nextGreaterElementsII(int[] nums) {
    Stack<Integer> stack = new Stack<>();
    int[] result = new int[nums.length];
    int n = nums.length;

    for (int i = 2 * n - 1; i >= 0; i--) {
      while (!stack.isEmpty() && stack.peek() <= nums[i % n])
        stack.pop();

      if (i < n)
        if (stack.isEmpty())
          result[i % n] = -1;
        else
          result[i % n] = stack.peek();

      stack.push(nums[i % n]);
    }

    return result;
  }

  public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
    Stack<Integer> st = new Stack<>();
    int[] array = new int[nums1.length];
    Map<Integer, Integer> map = new HashMap<>();

    for (int i = nums2.length - 1; i >= 0; i--) {
      while (!st.isEmpty() && st.peek() <= nums2[i])
        st.pop();

      if (st.isEmpty())
        map.put(nums2[i], -1);
      else
        map.put(nums2[i], st.peek());

      st.push(nums2[i]);
    }

    for (int i = 0; i < nums1.length; i++)
      array[i] = map.get(nums1[i]);

    return array;
  }

}
