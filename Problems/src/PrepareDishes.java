import java.util.*;

public class PrepareDishes {
  public static void main(String[] args) throws Exception {

    /**
     * 
     * Q1. At a restaurant, two types of dishes (A and B) are to be cooked. For
     * this, the restaurant authority wants to hire
     * new chefs. There are few chefs who can prepare only dish A and few others can
     * prepare only dish B. Some chefs
     * (represented as C) can prepare both dish A and dish B. The restaurant kitchen
     * is small, and only one chef can work in
     * the kitchen at a time.
     * Consider N chefs, available to prepare dish A or dish B or both, along with
     * the time Ti (i = 1,2,3....N) required by
     * i
     * th chef. The restaurant authority can either hire two chefs among N chefs to
     * prepare dish A and B separately, or can
     * hire someone who can cook both A and B.
     * 
     * Write a program to find the minimum time Z required to prepare both of the
     * dishes.
     * 
     * The first line of input contains N.
     * Next N lines of input contains a character (A, B or C) and T, separated by a
     * single white space.
     * 
     * Sample Input1:
     * 5
     * A 2
     * B 5
     * A 2
     * C 4
     * B 3
     * 
     * Sample Output1:
     * 4
     * 
     * Explanation1:
     * There are 2 chefs who can cook dish A. The time T taken by both of them are 2
     * and 2. Thus, the minimum time
     * required to prepare dish A is 2.
     * There are 2 chefs who can cook dish B. The time T taken by both of them are 5
     * and 3. Thus, the minimum time
     * required to prepare dish B is 3.
     * Thus, minimum time required to prepare both dish A and B separately is 2+3 =
     * 5.
     * Now, There is 1 chef who can cook both dish A and B. The time T taken by the
     * person is 4, which is less than time
     * taken to prepare dish A and B separately. Thus, 4 is the output.
     */
    Scanner sc = new Scanner(System.in);

    int A = Integer.MAX_VALUE, B = Integer.MAX_VALUE, C = Integer.MAX_VALUE;
    int N = Integer.parseInt(sc.nextLine());

    while (N-- > 0) {
      String s = sc.nextLine();
      String[] str = s.split(" ");

      if (str[0].equals("A"))
        A = Math.min(A, Integer.parseInt(str[1]));
      if (str[0].equals("B"))
        B = Math.min(B, Integer.parseInt(str[1]));

      if (str[0].equals("C"))
        C = Math.min(C, Integer.parseInt(str[1]));
    }
    System.out.println(Math.min(A + B, C));
    sc.close();
  }
}