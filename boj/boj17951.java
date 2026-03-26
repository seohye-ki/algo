import java.util.*;
import java.io.*;

public class boj17951 {
    static int[] a;
    static int n, k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        a = new int[n];

        st = new StringTokenizer(br.readLine());
        int total = 0;
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
            total += a[i];
        }

        int lo = 0, hi = total;
        int ans = 0;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (can(mid)) {
                ans = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        System.out.println(ans);
    }

    static boolean can(int minScore) {
        int groups = 0;
        int cur = 0;
        for (int i = 0; i < n; i++) {
            cur += a[i];
            if (cur >= minScore) {
                groups++;
                cur = 0;
            }
        }
        return groups >= k;
    }
}