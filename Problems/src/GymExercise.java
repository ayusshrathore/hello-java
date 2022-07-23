import java.util.*;

public class Exercise {
    
     /**
     * 
     * Today you decided to go to the gym. You currently have energy equal to E
     * units. There are N exercises in
     * the gym. Each of these exercises drains Ai amount of energy from your body.
     * 
     * You feel tired if your energy reaches 0 or below. Calculate the minimum
     * number of exercises you have
     * to perform such that you become tired. Every unique exercise can only be
     * performed at most 2 times as
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int E = sc.nextInt();
        int N = sc.nextInt();
        int[] A = new int[N];

        for (int i = 0; i < A.length; i++)
            A[i] = sc.nextInt();

        Arrays.sort(A);

        int count = 0;
        for (int i = N - 1; i >= 0; i--) {
            int min = 0;
            while ((E > 0) && (min < 2)) {
                E = E - A[i];
                min++;
                count++;
            }
        }
        if (E <= 0)
            System.out.println(count);
        else
            System.out.println(-1);

        sc.close();
    }
}
