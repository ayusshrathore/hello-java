import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

		// Q1
		// holes [4,8]
		// bob = 3 step forward, 4 step backward, target=10
		// [0,3,6,9,12,15,11,14,10]

		// Q2
		// n=4 [1, 2, 3, 4], divide into k parts & find out each permutation

		/**
		 * All Permutations of array
		 */
		System.out.println(permutations(0, new int[] { 1, 2, 3 }, new ArrayList<ArrayList<Integer>>()));

		/**
		 * NextPermutation
		 */
		System.out.println(nextPermutation(new int[] { 1, 3, 5, 4, 2 }));
		System.out.println(nextPermutation(new int[] { 5, 4, 3, 2, 1 }));
		System.out.println(nextPermutation(new int[] { 1, 3, 2 }));

		/**
		 * Merge Intervals
		 */
		System.out.println(Arrays.deepToString(
				mergeIntervals(new int[][] { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } })));
		System.out.println(Arrays.deepToString(
				mergeIntervals(new int[][] { { 1, 4 }, { 0, 0 } })));
		System.out.println(Arrays.deepToString(
				mergeIntervals(new int[][] { { 6, 8 }, { 1, 9 }, { 2, 4 }, { 4, 7 } })));

		/**
		 * Buy or sell stocks
		 */
		System.out.println(buySellStock(new int[] { 100, 180, 260, 310, 40, 535, 695 }));

		/**
		 * Trapping Rain Water Problem
		 */
		System.out.println(trappingRainWater(new int[] { 3, 0, 2, 0, 4 }));
		System.out.println(trappingRainWater(new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 }));

		/**
		 * Chocolate Distribution
		 */
		System.out.println(chocolateDistribution(new int[] { 7, 3, 2, 4, 9, 12, 56 }, 3));
		System.out.println(chocolateDistribution(new int[] { 3, 4, 1, 9, 56, 7, 9, 12 }, 5));
		System.out.println(
				chocolateDistribution(new int[] { 12, 4, 7, 9, 2, 23, 25, 41, 30, 40, 28, 42, 30, 44, 48, 43, 50 }, 7));

		/**
		 * Pascal's Triangle
		 */
		System.out.println(pascalsTriangle(4));

		/**
		 * Four Sum
		 */
		System.out.println(fourSum(new int[] { 1, 0, -1, 0, -2, 2 }, 0));
		System.out.println(fourSum(new int[] { 2, 2, 2, 2, 2 }, 8));
		System.out.println(fourSum(new int[] { 1000000000, 1000000000, 1000000000, 1000000000 }, -294967296));
		System.out.println(fourSum(new int[] { -1, 0, 1, 2, -1, -4 }, -1));

		/**
		 * Remove Duplicates from Sorted Array
		 */
		System.out.println(removeDuplicates(new int[] { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 }));
		System.out.println(removeDuplicates(new int[] { 1, 2 }));

		/**
		 * Three Sum
		 */
		// System.out.println(threeSum(new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
		// 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
		// 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
		// 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
		// 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
		// 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
		// 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
		// 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
		// 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
		// 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
		// 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
		// 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
		// 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
		// 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
		// 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
		// 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
		// 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
		// 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
		// 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
		// 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
		// 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
		// 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
		// 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
		// 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
		// 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
		// 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
		// 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
		// 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
		// 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
		// 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
		// 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
		// 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
		// 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
		// 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
		// 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
		// 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
		// 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
		// 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
		// 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
		// 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
		// 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
		// 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
		// 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
		// 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
		// 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
		// 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
		// 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
		// 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
		// 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
		// 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
		// 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
		// 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
		// 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
		// 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
		// 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
		// 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
		// 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
		// 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
		// 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
		// 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
		// 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
		// 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
		// 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
		// 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
		// 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
		// 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
		// 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
		// 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
		// 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
		// 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
		// 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
		// 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
		// 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
		// 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
		// 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
		// 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
		// 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
		// 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
		// 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
		// 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
		// 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
		// 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
		// 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
		// 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
		// 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
		// 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
		// 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
		// 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
		// 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
		// 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
		// 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
		// 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
		// 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
		// 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
		// 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
		// 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
		// 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
		// 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
		// 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
		// 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
		// 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
		// 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
		// 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
		// 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
		// 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
		// 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
		// 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
		// 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
		// 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
		// -1, -1, -1, -1, -1, -1, -1, -1,
		// -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
		// -1, -1, -1, -1, -1, -1, -1, -1, -1,
		// -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
		// -1, -1, -1, -1, -1, -1, -1, -1, -1,
		// -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
		// -1, -1, -1, -1, -1, -1, -1, -1, -1,
		// -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
		// -1, -1, -1, -1, -1, -1, -1, -1, -1,
		// -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
		// -1, -1, -1, -1, -1, -1, -1, -1, -1,
		// -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
		// -1, -1, -1, -1, -1, -1, -1, -1, -1,
		// -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
		// -1, -1, -1, -1, -1, -1, -1, -1, -1,
		// -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
		// -1, -1, -1, -1, -1, -1, -1, -1, -1,
		// -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
		// -1, -1, -1, -1, -1, -1, -1, -1, -1,
		// -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
		// -1, -1, -1, -1, -1, -1, -1, -1, -1,
		// -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
		// -1, -1, -1, -1, -1, -1, -1, -1, -1,
		// -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
		// -1, -1, -1, -1, -1, -1, -1, -1, -1,
		// -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
		// -1, -1, -1, -1, -1, -1, -1, -1, -1,
		// -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
		// -1, -1, -1, -1, -1, -1, -1, -1, -1,
		// -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
		// -1, -1, -1, -1, -1, -1, -1, -1, -1,
		// -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
		// -1, -1, -1, -1, -1, -1, -1, -1, -1,
		// -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
		// -1, -1, -1, -1, -1, -1, -1, -1, -1,
		// -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
		// -1, -1, -1, -1, -1, -1, -1, -1, -1,
		// -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
		// -1, -1, -1, -1, -1, -1, -1, -1, -1,
		// -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
		// -1, -1, -1, -1, -1, -1, -1, -1, -1,
		// -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
		// -1, -1, -1, -1, -1, -1, -1, -1, -1,
		// -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
		// -1, -1, -1, -1, -1, -1, -1, -1, -1,
		// -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
		// -1, -1, -1, -1, -1, -1, -1, -1, -1,
		// -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
		// -1, -1, -1, -1, -1, -1, -1, -1, -1,
		// -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
		// -1, -1, -1, -1, -1, -1, -1, -1, -1,
		// -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
		// -1, -1, -1, -1, -1, -1, -1, -1, -1,
		// -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
		// -1, -1, -1, -1, -1, -1, -1, -1, -1,
		// -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
		// -1, -1, -1, -1, -1, -1, -1, -1, -1,
		// -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
		// -1, -1, -1, -1, -1, -1, -1, -1, -1,
		// -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
		// -1, -1, -1, -1, -1, -1, -1, -1, -1,
		// -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
		// -1, -1, -1, -1, -1, -1, -1, -1, -1,
		// -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
		// -1, -1, -1, -1, -1, -1, -1, -1, -1,
		// -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
		// -1, -1, -1, -1, -1, -1, -1, -1, -1,
		// -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
		// -1, -1, -1, -1, -1, -1, -1, -1, -1,
		// -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
		// -1, -1, -1, -1, -1, -1, -1, -1, -1,
		// -1, -1, -1 }));
		System.out.println(threeSum(new int[] { 0, 0, 0, 0 }));

		/**
		 * Minimum Number of coins
		 */
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

	static ArrayList<ArrayList<Integer>> permutations(int index, int[] nums,
			ArrayList<ArrayList<Integer>> ans) {
		if (index == nums.length) {

			ArrayList<Integer> ds = new ArrayList<>();
			for (var num : nums)
				ds.add(num);
			ans.add(ds);

			return ans;
		}

		for (int i = index; i < nums.length; i++) {
			swap(i, index, nums);
			permutations(index + 1, nums, ans);
			// backtracking
			swap(i, index, nums);
		}
		return ans;
	}

	static String nextPermutation(int[] nums) {
		// 1 3 5 4 2
		// 1 3 2
		if (nums == null || nums.length <= 1)
			return nums.toString();

		int index1 = -1, index2 = 0;
		for (int i = nums.length - 1; i > 0; i--)
			if (nums[i] > nums[i - 1]) {
				index1 = i - 1;
				break;
			}
		if (index1 >= 0)
			for (int i = nums.length - 1; i > 0; i--)
				if (nums[i] > nums[index1]) {
					index2 = i;
					swap(index1, index2, nums);
					break;
				}
		reverse(index1 + 1, nums.length - 1, nums);

		return Arrays.toString(nums);
	}

	static int[][] mergeIntervals(int[][] intervals) {
		List<int[]> mergedIntervals = new ArrayList<>();
		if (intervals == null || intervals.length < 1)
			return mergedIntervals.toArray(new int[0][]);

		Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
		int start = intervals[0][0], end = intervals[0][1];

		for (int[] it : intervals) {
			if (it[0] <= end)
				end = Math.max(it[1], end);
			else {
				mergedIntervals.add(new int[] { start, end });
				// updating values of start & end as intervals changes
				start = it[0];
				end = it[1];
			}
		}

		mergedIntervals.add(new int[] { start, end });
		return mergedIntervals.toArray(new int[0][]);
	}

	static int buySellStock(int[] prices) {
		if (prices == null || prices.length == 0)
			return 0;
		int maxProfit = 0, minAmount = Integer.MAX_VALUE;

		for (int i = 0; i < prices.length; i++) {
			minAmount = Math.min(prices[i], minAmount);
			maxProfit = Math.max(maxProfit, prices[i] - minAmount);
		}
		return maxProfit;
	}

	static int trappingRainWater(int[] elevations) {
		int minHeights = 0;
		int totalWater = 0;
		if (elevations == null | elevations.length == 0)
			return totalWater;

		int[] left = new int[elevations.length], right = new int[elevations.length];

		// store max heights from the left
		left[0] = elevations[0];
		for (int i = 1; i < elevations.length; i++)
			left[i] = Math.max(left[i - 1], elevations[i]);

		// store max heights from the right
		right[elevations.length - 1] = elevations[elevations.length - 1];
		for (int i = elevations.length - 2; i >= 0; i--)
			right[i] = Math.max(right[i + 1], elevations[i]);

		for (int i = 0; i < elevations.length; i++) {
			minHeights = Math.min(left[i], right[i]);
			totalWater += (minHeights - elevations[i] > 0 ? minHeights - elevations[i] : 0);
		}

		return totalWater;
	}

	static int chocolateDistribution(int[] chocolates, int m) {
		if (chocolates == null || chocolates.length == 0)
			return 0;

		int diff = 0, lowestDiff = Integer.MAX_VALUE;
		Arrays.sort(chocolates);
		for (int i = 0; i < chocolates.length; i++) {
			if (chocolates.length - i >= m) {
				diff = chocolates[m - 1 + i] - chocolates[i];
				lowestDiff = Math.min(diff, lowestDiff);
			}
		}
		return lowestDiff;
	}

	static List<List<Integer>> pascalsTriangle(int numRows) {
		List<List<Integer>> result = new ArrayList<>();

		List<Integer> pre = null;
		for (int i = 0; i < numRows; i++) {
			List<Integer> row = new ArrayList<>();
			for (int j = 0; j <= i; j++) {
				if (j == 0 || j == i)
					row.add(1);
				else
					row.add(pre.get(j) + pre.get(j - 1));
			}
			pre = row;
			result.add(row);
		}
		return result;

	}

	static List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (nums == null || nums.length == 0)
			return result;

		int n = nums.length;
		// [-2,-1,0,0,1,2]
		Arrays.sort(nums);
		for (int i = 0; i < n - 3; i++) {
			for (int j = i + 1; j < n - 2; j++) {
				long target2 = target - (nums[i] + nums[j]);

				var left = j + 1;
				var right = n - 1;

				while (left < right) {
					if (target2 < nums[left] + nums[right])
						right--;
					else if (target2 > nums[left] + nums[right])
						left++;
					else {
						List<Integer> quads = new ArrayList<>();
						quads.add(nums[i]);
						quads.add(nums[j]);
						quads.add(nums[left]);
						quads.add(nums[right]);
						result.add(quads);

						// removing duplicates for left & right pointers
						while (left < right && nums[left] == quads.get(2))
							++left;

						while (left < right && nums[right] == quads.get(3))
							--right;
					}
				}
				while (j + 1 < n - 2 && nums[j] == nums[j + 1])
					++j;
			}
			while (i + 1 < n - 3 && nums[i] == nums[i + 1])
				++i;
		}
		return result;
	}

	static int removeDuplicates(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}

		for (int i = 0; i < nums.length - 1; i++) {
			int j = i + 1;
			if (nums[j] <= nums[i]) {
				for (int k = j + 1; k < nums.length; k++)
					if (nums[k] > nums[i]) {
						swap(k, j, nums);
						break;
					}
			}
		}
		int count = 1;
		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i] < nums[i + 1])
				count++;
			else
				break;
		}
		return count;
	}

	// static double findMedianSortedArrays(int[] nums1, int[] nums2) {
	// if (nums1 == null && nums2 == null)
	// return 0;

	// int size1 = nums1.length - 1;
	// int size2 = nums2.length - 1;
	// double larger = 0;
	// double result = 0;

	// if (nums1[size1] > nums2[size2])
	// larger = nums1[size1];
	// else
	// larger = nums2[size2];

	// if (larger % 2 == 0) {
	// double n1 = larger / 2;
	// double n2 = (larger / 2) + 1;
	// double n = n1 + n2;
	// result = n / 2;
	// } else
	// result = Math.ceil(larger / 2);

	// return result;
	// }

	// static List<List<Integer>> threeSum(int[] nums) {
	// List<List<Integer>> result = new ArrayList<List<Integer>>();
	// if (nums == null || nums.length == 0)
	// return result;

	// if (nums.length >= 3 && nums.length < 3000 && IntStream.of(nums).sum() == 0)
	// {
	// ArrayList<Integer> numList = new ArrayList<>();
	// int count = 0;
	// for (int i = 0; i < 3; i++)
	// if (nums[i] == 0)
	// count++;

	// if (count == 3) {
	// numList.add(0);
	// numList.add(0);
	// numList.add(0);
	// result.add(numList);
	// return result;
	// }
	// }

	// int n = nums.length;
	// int target = 0;
	// Arrays.sort(nums);
	// for (int i = 0; i < n - 2; i++) {
	// var target2 = target - (nums[i]);

	// var left = i + 1;
	// var right = n - 1;

	// while (left < right) {
	// if (target2 < nums[left] + nums[right])
	// right--;
	// else if (target2 > nums[left] + nums[right])
	// left++;
	// else {
	// List<Integer> trips = new ArrayList<>();
	// trips.add(nums[i]);
	// trips.add(nums[left]);
	// trips.add(nums[right]);
	// result.add(trips);

	// while (left < right && nums[left] == trips.get(1))
	// ++left;

	// while (left < right && nums[right] == trips.get(2))
	// --right;
	// }
	// }
	// while (i + 1 < n - 2 && nums[i] == nums[i + 1])
	// ++i;
	// }
	// return result;
	// }
	static List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (nums == null || nums.length == 0)
			return result;

		int n = nums.length;

		Arrays.sort(nums);
		for (int i = 0; i < n - 2; i++) {
			var sum = 0 - nums[i];

			var left = i + 1;
			var right = n - 1;

			while (left < right) {
				if (sum < nums[left] + nums[right])
					right--;
				else if (sum > nums[left] + nums[right])
					left++;
				else {
					List<Integer> trips = new ArrayList<>();
					trips.add(nums[i]);
					trips.add(nums[left]);
					trips.add(nums[right]);
					result.add(trips);

					while (left < right && nums[left] == trips.get(1))
						++left;

					while (left < right && nums[right] == trips.get(2))
						--right;
				}
			}
			while (i < n - 2 && nums[i] == nums[i + 1])
				++i;
		}
		return result;
	}

	static void reverse(int startingIndex, int lastIndex, int[] array) {
		while (startingIndex < lastIndex)
			swap(startingIndex++, lastIndex--, array);
	}

	static void swap(int a, int b, int[] array) {
		int temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}
}