import java.util.*;

public class boj13397 {
    static int N, M;
    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        int lo = 0, hi = 10000, ans = 10000;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (can(mid)) {
                ans = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        System.out.println(ans);
    }

    static boolean can(int limit) {
        int segments = 1;
        int curMin = arr[0];
        int curMax = arr[0];

        for (int i = 1; i < N; i++) {
            int newMin = Math.min(curMin, arr[i]);
            int newMax = Math.max(curMax, arr[i]);

            if (newMax - newMin > limit) {
                segments++;
                curMin = arr[i];
                curMax = arr[i];
            } else {
                curMin = newMin;
                curMax = newMax;
            }
        }

        return segments <= M;
    }
}