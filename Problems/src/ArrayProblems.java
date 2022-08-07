import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ArrayProblems {

	public static void main(String[] args) throws Exception {
		/**
		 * Reverse a given array
		 */
		System.out.println(reverseArray(new int[] { 1, 2, 3, 4, 5 }, 5));
		System.out.println(reverse(new int[] { 10, 22, 34, 46, 51 }, 5));

		/**
		 * Maximum and minimum element in the array
		 */
		maxOrMin(new int[] { 71, 19, 25, 64, 33 });

		/**
		 * Kth maximum or kth minimum element in the array
		 */
		kthMaxOrMin(new int[] { 23, 55, 12, 52, 64, 20 }, 2, 3);

		/**
		 * Given an array which consists of only 0, 1 and 2. Sort the array without
		 * using any sorting algo
		 */
		sortZeroOneTwo(new int[] { 1, 2, 0, 2, 0, 0 });
		sort012(new int[] { 1, 2, 0, 2, 0, 0 }); // alternative approach

		/**
		 * Move all the negative elements to one side of the array
		 */
		moveNegativeToSide(new int[] { 2, 0, -1, 5, -2 });

		/**
		 * Find the Union and Intersection of the two sorted arrays.
		 */
		intersectionOrUnion(new int[] { 22, 14, 55, 1, 20, 82 }, new int[] { 51, 22, 1, 20, 7, 32 });

		/**
		 * Write a program to cyclically rotate an array by one.
		 */
		cyclicallyRotateByOne(new int[] { 1, 2, 3, 4, 5 });

		/**
		 * find Largest sum contiguous Subarray [V. IMP]
		 */
		System.out.println(largestSubArraySum(new int[] { -3, -1, }));

		/**
		 * Minimise the maximum difference between heights [V.IMP]
		 */
		System.out.println(minTheMaxDiff(new int[] { 1, 10, 14, 14, 14, 15 }, 6));

		/**
		 * Minimum no. of Jumps to reach end of an array
		 */
		// 1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9 output: 3
		// 1, 3, 6, 3, 2, 3, 6, 8, 9, 5 output: 4
		System.out.println(minJumps(new int[] { 9, 8, 6, 7, 6, 2, 9, 8, 5, 3, 1 }));

		/**
		 * find duplicate in an array of N-1 Integers in O(n) without using extra space
		 */
		duplicateIntegers(new int[] { 1, 2, 3, 6, 3, 6, 1 });

		/**
		 * Merge 2 sorted arrays without using Extra space.
		 */
		mergeTwoSortedArrays(new int[] { 1, 5, 9, 10, 15, 20 }, new int[] { 2, 3, 8, 13 });
		mergeTwoSortedArrays(new int[] { 10 }, new int[] { 2, 3 });

		/**
		 * find all pairs on integer array whose sum is equal to given number
		 */
		printPairs(new int[] { 1, 5, 7, -1, 5 }, 6);

		/**
		 * Rearrange the array in alternating positive and negative items with O(1)
		 * extra space
		 */
		alternateIntegers(new int[] { 1, 2, 3, -4, -1, 4 });
		alternateIntegers(new int[] { -5, -2, 5, 2, 4, 7, 1, 8, 0, -8 });

		/**
		 * Find if there is any subarray with sum equal to 0
		 */
		System.out.println(subArrayWithZeroSum(new int[] { 4, 2, -3, 1, 6 }));
		System.out.println(subArrayWithZeroSum(new int[] { 4, 2, 0, 1, 6 }));
		System.out.println(subArrayWithZeroSum(new int[] { -3, 2, 3, 1, 6 }));

		/**
		 * find maximum product subarray
		 */
		System.out.println(largestSubArrayProduct(new int[] { 6, -3, -10, 0, 2 }));
		System.out.println(largestSubArrayProduct(new int[] { -2, -40, 0, -2, -3 }));
		System.out.println(largestSubArrayProduct(new int[] { -2, -3, 0, -2, -40, }));
		System.out.println(largestSubArrayProduct(new int[] { 1, -2, -3, 0, 7, -8, -2 }));

		/**
		 * Find longest consecutive subsequence
		 */
		System.out.println(longestConsecutiveSubsequence(new int[] { 1, 9, 3, 10, 4,
				20, 2 }));
		System.out.println(longestConsecutiveSubsequence(new int[] { 36, 41, 56, 35, 44, 33, 34, 92, 43, 32, 42 }));
		System.out.println(longestConsecutiveSubsequence(new int[] { 1, 4, 2, 2, 4,
				1, 2 }));
	}

	// array length - how much min + 1
	static String reverseArray(int[] array, int size) {
		var first = array[0];
		var last = array[size - 1];
		while (first != array[size - 1] && last != array[0]) {
			for (int i = 0; i < size - 1; i++) {
				var temp = array[i];
				array[i] = array[i + 1];
				array[i + 1] = temp;
			}
			size--;
		}

		return Arrays.toString(array);
	}

	// alternate reverse method complexity O(n) worst case
	static String reverse(int[] array, int size) {
		int[] newArray = new int[size];

		for (int i = 0; i < size; i++)
			newArray[i] = array[size - i - 1];

		array = newArray;

		return Arrays.toString(array);
	}

	static void maxOrMin(int[] array) {
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;

		for (var num : array) {
			max = num > max ? num : max;
			min = num < min ? num : min;
		}

		System.out.println("Maximum: " + max + " Minimum: " + min);
	}

	static void kthMaxOrMin(int[] array, int kthMax, int kthMin) {
		Arrays.sort(array);

		if (kthMax > array.length || kthMax <= 0)
			System.out.println(kthMax + "th minimum number is: " + 0);

		if (kthMin > array.length || kthMin <= 0)
			System.out.println(kthMin + "th minimum number is: " + 0);

		if (kthMax <= array.length && kthMin <= array.length) {
			System.out.println(kthMin + "th minimum number is: " + array[kthMin - 1]);
			System.out.println(kthMax + "th maximum number is: " + array[array.length - kthMax]);
		}

	}

	static void sortZeroOneTwo(int[] array) {

		int low = 0, mid = 0, temp = 0;
		int high = array.length - 1;
		while (mid <= high) {
			switch (array[mid]) {
				case 0: {
					temp = array[low];
					array[low] = array[mid];
					array[mid] = temp;
					low++;
					mid++;
					break;
				}

				case 1:
					mid++;
					break;

				case 2: {
					temp = array[mid];
					array[mid] = array[high];
					array[high] = temp;
					high--;
					break;
				}
			}
		}
		System.out.println(Arrays.toString(array));
	}

	static void sort012(int[] array) {
		int noOfZeros = 0, noOfOnes = 0, noOfTwos = 0;

		for (var num : array) {
			noOfZeros = num == 0 ? noOfZeros + 1 : noOfZeros;
			noOfOnes = num == 1 ? noOfOnes + 1 : noOfOnes;
			noOfTwos = num == 2 ? noOfTwos + 1 : noOfTwos;
		}

		int index = 0;
		while (noOfZeros > 0) {
			array[index++] = 0;
			noOfZeros--;
		}
		while (noOfOnes > 0) {
			array[index++] = 1;
			noOfOnes--;
		}
		while (noOfTwos > 0) {
			array[index++] = 2;
			noOfTwos--;
		}

		System.out.println(Arrays.toString(array));
	}

	static void moveNegativeToSide(int[] array) {
		int low = 0, mid = 0;
		// 2, 0, -1, 5, -2
		while (mid < array.length) {
			if (array[mid] < 0) {
				int temp = array[low];
				array[low] = array[mid];
				array[mid] = temp;
				low++;
				mid++;
			}
			mid++;

		}

		System.out.println(Arrays.toString(array));
	}

	static void intersectionOrUnion(int[] array, int[] otherArray) {
		Set<Integer> set = new HashSet<>();

		System.out.print("Intersection of two arrays: ");
		for (var num : array) {
			set.add(num);
			for (var num2 : otherArray) {
				set.add(num2);
				if (num == num2)
					System.out.print(num + " ");
			}
		}

		System.out.print("\nUnion of two arrays: ");
		System.out.print(set.toString());
		System.out.println();
	}

	static void cyclicallyRotateByOne(int[] array) {
		int last = array[array.length - 1];

		for (int i = array.length - 1; i > 0; i--) {
			array[i] = array[i - 1];
		}
		array[0] = last;

		System.out.println(Arrays.toString(array));
	}

	static int largestSubArraySum(int array[]) {
		int maxSoFar = array[0];
		int currentMax = array[0];
		// -3 -1
		for (int i = 1; i < array.length; i++) {
			if (currentMax < array[i])
				currentMax = currentMax + array[i];

			if (currentMax > maxSoFar)
				maxSoFar = currentMax;
		}

		return maxSoFar;
	}

	static int minTheMaxDiff(int[] array, int k) {

		Arrays.sort(array);
		int maxDiff = array[array.length - 1] - array[0];

		int min = array[0];
		int max = array[array.length - 1];

		for (int i = 1; i < array.length; i++) {
			if (array[i] - k < 0)
				continue;

			min = Math.min(array[0] + k, array[i] - k);
			max = Math.max(array[i - 1] + k, array[array.length - 1] - k);
			maxDiff = Math.min(maxDiff, max - min);
		}
		return maxDiff;
	}

	static int minJumps(int[] array) {
		int jumps = 0;

		for (int i = 0; i < array.length; i++) {
			if (array[i] == 0)
				return -1;
			if (array[i] == 1) {
				if (i != 1)
					jumps++;
				continue;
			}
			int max = 0;
			int index = 0;
			for (int j = i + 1; j <= array[i] + i; j++)
				if (array[j] > max) {
					max = array[j];
					index = j;
				}

			i += index;
			jumps++;
			if (max + index + 1 >= array.length)
				return ++jumps;

		}
		return jumps;
	}

	static void duplicateIntegers(int[] array) {

		// {1, 2, 3, 6, 3, 6, 1}

		for (int i = 0; i < array.length; i++)
			array[array[i] % array.length] = array[array[i] % array.length] + array.length;

		for (int i = 0; i < array.length; i++) {
			if (array[i] >= array.length * 2)
				System.out.print(i + " ");
		}
		System.out.println();
	}

	// 2 sorted array without using extra space
	// 1 2 3 4 5 6 7
	// 9 10 11 12 13
	// Input: ar1[] = {1, 5, 9, 10, 15, 20};
	// ar2[] = {2, 3, 8, 13};
	static void mergeTwoSortedArrays(int[] array1, int[] array2) {
		int length = array1[0] < array2[0] ? array1.length : array2.length;

		for (int i = 0; i < length; i++) {
			int j = 0;
			if (i == array1.length || i == array2.length)
				break;

			if (array1[i] > array2[j]) {
				int temp = array1[i];
				array1[i] = array2[j];
				array2[j] = temp;
				Arrays.sort(array2);
				j++;
			}
		}

		for (int i = 0; i < array1.length; i++)
			System.out.print(array1[i] + " ");

		System.out.println();
		for (int i = 0; i < array2.length; i++)
			System.out.print(array2[i] + " ");
		System.out.println();
	}

	static void printPairs(int[] array, int sum) {

		for (int i = 0; i < array.length; i++)
			for (int j = i + 1; j < array.length; j++)
				if (array[i] + array[j] == sum)
					System.out.println("(" + array[i] + ", " + array[j] + ")");

	}

	static void alternateIntegers(int[] array) {
		// {1, 2, 3, -4, -1, 4}
		for (int i = 0; i < array.length; i++) {
			if (array[i] >= 0 && i % 2 == 0) {
				for (int j = i + 1; j < array.length; j++) {
					if (array[j] < 0) {
						int temp = array[i];
						array[i] = array[j];
						array[j] = temp;
						break;
					}
				}
			}
			if (array[i] < 0 && i % 2 != 0)
				for (int j = i + 1; j < array.length; j++) {
					if (array[j] >= 0) {
						int temp = array[i];
						array[i] = array[j];
						array[j] = temp;
						break;
					}
				}
		}

		System.out.println(Arrays.toString(array));
	}

	static int largestSubArrayProduct(int array[]) {
		int maxSoFar = Integer.MIN_VALUE;
		int currentMax = 1;
		// 6, -3, -10, 0, 2

		for (int i = 0; i < array.length; i++) {
			currentMax = currentMax * array[i];
			currentMax = currentMax == 0 ? 1 : currentMax;
			if (currentMax > maxSoFar)
				maxSoFar = currentMax;
		}

		return maxSoFar;
	}

	static boolean subArrayWithZeroSum(int array[]) {
		Set<Integer> set = new HashSet<>();
		int sum = array[0];
		set.add(sum);

		// {4, 2, -3, 1, 6}

		for (int i = 1; i < array.length; i++) {
			sum += array[i];

			if (sum == 0 || array[i] == 0 || set.contains(sum))
				return true;

			set.add(sum);
		}

		return false;
	}

	static int longestConsecutiveSubsequence(int[] array) {
		int count = 1;
		// 1 4 2 2 4 1 2
		Arrays.sort(array);

		int maxCount = Integer.MIN_VALUE;
		for (int i = 0; i < array.length - 1; i++) {
			if (array[i] == array[i + 1])
				continue;

			if (array[i] + 1 == array[i + 1])
				count++;

			if (array[i] + 1 != array[i + 1]) {
				maxCount = maxCount > count ? maxCount : count;
				count = 1;
			}
		}

		return maxCount;
	}
}