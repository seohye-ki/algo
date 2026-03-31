import java.util.*;
import java.io.*;

public class boj3020 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        int[] bottom = new int[N / 2];
        int[] top = new int[N / 2];

        for (int i = 0; i < N / 2; i++) {
            bottom[i] = Integer.parseInt(br.readLine());
            top[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(bottom);
        Arrays.sort(top);

        int minCnt = N;
        int count = 0;

        for (int i = 1; i <= H; i++) {
            int destroyed = countDestroyed(bottom, i) + countDestroyed(top, H - i + 1);

            if (destroyed < minCnt) {
                minCnt = destroyed;
                count = 1;
            } else if (destroyed == minCnt) {
                count++;
            }
        }

        System.out.println(minCnt + " " + count);
    }

    private static int countDestroyed(int[] arr, int height) {
        int left = 0;
        int right = arr.length;

        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] >= height) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return arr.length - left;
    }
}