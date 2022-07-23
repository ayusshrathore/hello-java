import java.io.*;
import java.util.*;

public class Solution {
    
    /**
    * Rohit has chocolate weighing 1 to n. He wants to divide it into two equal
    * weights without cutting any chocolate.
    * 
    * Is it possible for him to divide?
    */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n % 2 != 0) {
            for (int i=1; i<=n/2; i=i+2) {
                if (i * 2 + 1 == n) {
                    System.out.println("YES");
                    return;
                }
            }
        }
        else {
            for (int i=1; i<=n/2; i=i+2) {
                if (i * 2 + 2 == n) {
                    System.out.println("YES");
                    return;
                }
            }
        }
        System.out.println("NO");
    }
}
