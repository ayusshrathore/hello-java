import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

        /**
         * |--------------------------------------------------
         * Rohit has chocolate weighing 1 to n. He wants to divide it into two equal
         * weights without cutting any chocolate.
         * 
         * Is it possible for him to divide?
         * 
         * Input Format
         * 
         * The only input line contains an integer n.
         * 
         * Constraints
         * 
         * 1≤n≤10^6
         * 
         * Output Format
         * 
         * Print "YES", if the division is possible, and "NO" otherwise.
         * 
         * Sample Input 0
         * 
         * 4
         * Sample Output 0
         * 
         * YES
         * |--------------------------------------------------
         */
        // Scanner sc = new Scanner(System.in);
        // int size = sc.nextInt();
        // int[] array = new int[size];
        // for (int i = 0; i < size; i++) {
        // array[i] = i + 1;
        // }
        // canDivide(array);
        // sc.close();

        /**
         * |--------------------------------------------------
         * |Given a matrix M[n][n] which is square matrix, find two elemnts from the
         * given matrix x=M[c][d] and y = M[a][b] where c>a and d>b such that x-y gives
         * the maximum value of all such pairs. Print the value x-y.
         * 
         * Input Format
         * 
         * Input: First line contains the dimensions of the input matrix , single number
         * N Next N lines contain rows of the matrix having comma separated N elements
         * each
         * 
         * 5
         * 
         * 1 2 -1 -4 -20
         * 
         * -8 -3 4 2 1
         * 
         * 3 8 6 1 3
         * 
         * -4 -1 1 7 -6
         * 
         * 0 -4 10 -5 1
         * 
         * Constraints
         * 
         * 1≤n≤20
         * 
         * -100≤M[i]≤100
         * 
         * Output Format
         * 
         * Output: Print the difference x-y
         * 
         * 18
         * 
         * Explaination The maximum value is 18 as M[4][2] - M[1][0] = 18 has maximum
         * difference.
         * |--------------------------------------------------
         */

        // System.out.println(sQMatrixMaxDiff(new int[][] { { 1, 2, -1, -4, -20 },
        // { -8, -3, 4, 2, 1 }, { 3, 8, 6, 1, 3 }, { -4, -1, 1, 7, -6 }, { 0, -4, 10,
        // -5, 1 } }));
        // System.out.println(sQMatrixMaxDiff(new int[][] { { 1, 2, -1, -4, -20 },
        // { -20, -3, 4, 2, 1 }, { 3, 8, 6, 1, 3 }, { -4, -1, 1, 7, -6 }, { 0, -4, 10,
        // -5, 1 } }));

        // Scanner sc = new Scanner(System.in);
        // int size = sc.nextInt();
        // int[] array = new int[size];
        // for (int i = 0; i < size; i++)
        // array[i] = sc.nextInt();

        // sc.close();
        // System.out.println(piggyBank(array));

        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < size; i++)
            list.add(i + 1);

        sc.close();
        destroyingBoxes(list, size);

    }

    static void canDivide(int[] array) {
        var sum = (double) array.length / 2 * (array[0] + array[array.length]);

        if (sum % 2 == 0)
            System.out.println("YES");
        else
            System.out.println("NO");

    }

    static int sQMatrixMaxDiff(int[][] array) {
        int tempMax = Integer.MIN_VALUE;
        int tempMin = Integer.MAX_VALUE;
        int indexIMax = Integer.MIN_VALUE;
        int indexJMax = Integer.MIN_VALUE;
        int indexIMin = Integer.MAX_VALUE;
        int indexJMin = Integer.MAX_VALUE;
        int discardedIMax = 0;
        int discardedJMax = 0;
        int discardedIMin = 0;
        int discardedJMin = 0;

        while (true) {
            if (indexIMax > indexIMin && indexJMax > indexJMin)
                break;

            tempMax = Integer.MIN_VALUE;
            tempMin = Integer.MAX_VALUE;
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array.length; j++) {
                    if (array[i][j] > tempMax && (i != discardedIMax && j != discardedJMax)) {
                        tempMax = array[i][j];
                        indexIMax = i;
                        indexJMax = j;
                    }
                    if (array[i][j] < tempMin && (i != discardedIMin && j != discardedJMin)) {
                        tempMin = array[i][j];
                        indexIMin = i;
                        indexJMin = j;
                    }
                }
            }
            if (indexIMax > indexIMin) {
                discardedIMin = indexIMin;
                discardedJMin = indexJMin;

            } else {
                discardedIMax = indexIMax;
                discardedJMax = indexJMax;
            }

        }

        return tempMax - tempMin;

    }

    static long piggyBank(int[] array) {
        long minAmount = 1;
        int i = 0;
        while (i < array.length && array[i] <= minAmount) {
            minAmount += array[i];
            i++;
        }

        return minAmount;
    }

    static void destroyingBoxes(ArrayList<Integer> list, int size) {
        int count = 1;
        ArrayList<Integer> list2 = new ArrayList<>();

        while (list.size() != 0) {
            for (int i = 0; i < list.size(); i++) {
                if (count % 2 == 0) {
                    var ele = list.get(i);
                    System.out.print(ele + " ");
                    list2.add(ele);
                }
                count++;
            }
            for (int i = 0; i < list.size(); i++)
                if (list2.contains(list.get(i)))
                    list.remove(i);
            list2.clear();
        }
    }

}