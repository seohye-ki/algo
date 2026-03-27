import java.util.*;
import java.io.*;

public class boj1377 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());

        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = Integer.parseInt(br.readLine().trim());
            arr[i][1] = i;
        }

        Arrays.sort(arr, (a, b) -> a[0] - b[0]);

        int maxMove = 0;
        for (int i = 0; i < n; i++) {
            maxMove = Math.max(maxMove, arr[i][1] - i);
        }

        System.out.println(maxMove + 1);
    }
}