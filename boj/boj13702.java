import java.util.*;
import java.io.*;

public class boj13702 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        long[] arr = new long[N];
        long max = 0;

        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(br.readLine());
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        long left = 1;
        long right = max;
        long result = 0;

        if (max == 0) {
            System.out.println(0);
            return;
        }

        while (left <= right) {
            long mid = (left + right) / 2;
            long count = 0;

            for (int i = 0; i < N; i++) {
                count += (arr[i] / mid);
            }

            if (count >= K) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(result);
    }
}