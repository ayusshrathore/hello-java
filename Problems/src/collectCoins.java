import java.util.*;

public class collectCoins {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = Integer.parseInt(sc.nextLine());
    int[] arr = new int[N];

    for (int i = 0; i < N; i++)
      arr[i] = Integer.parseInt(sc.nextLine());

    sc.close();
    System.out.println(collect(arr, 0, N));
  }

  public static int collect(int[] arr, int idx, int N) {
    if (idx >= N)
      return 0;

    int notPick = collect(arr, idx + 1, N);
    int pick = arr[idx] + collect(arr, idx + 2, N);
    return Math.max(pick, notPick);
  }
}
