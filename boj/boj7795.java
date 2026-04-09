import java.util.*;
import java.io.*;

public class boj7795 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        
        if (!sc.hasNextInt()) return;
        int T = sc.nextInt();

        for (int t = 0; t < T; t++) {
            int N = sc.nextInt();
            int M = sc.nextInt();

            int[] A = new int[N];
            int[] B = new int[M];

            for (int i = 0; i < N; i++) {
                A[i] = sc.nextInt();
            }

            for (int i = 0; i < M; i++) {
                B[i] = sc.nextInt();
            }

            Arrays.sort(B);

            int count = 0;
            for (int i = 0; i < N; i++) {
                count += binarySearch(B, A[i]);
            }
            System.out.println(count);
        }
		sc.close();
    }

	private static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int count = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (arr[mid] < target) {
                count = mid + 1;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return count;
    }
}