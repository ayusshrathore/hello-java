import java.util.*;

public class Temp {
  public static void main(String[] args) {
    System.out.println(maxScore(1));
  }

  static int maxScore(int k) {
    int count = 0, i = 0, j = 0;
    // String str = "aaab";
    // String str = "aabcabc";

    String str = "aaaaaabbb";
    Set<Character> set = new HashSet<>();
    while (i < str.length() && j < str.length()) {
      set.add(str.charAt(j));
      if (set.size() == k)
        count++;
      j++;
      if (i == str.length() - 1 && j == str.length())
        break;
      if (j == str.length()) {
        j = ++i;
        set.clear();
      }
    }
    return count;
  }
}
