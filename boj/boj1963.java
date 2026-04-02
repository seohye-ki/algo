import java.util.*;
import java.io.*;

public class boj1963 {
    static boolean[] isPrime = new boolean[10000];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        checkPrime();

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());

			int result = bfs(start, end);
			
			if (result == -1) {
				sb.append("Impossible\n");
			} else {
				sb.append(result).append("\n");
			}
		}
		System.out.print(sb);
    }

    static int bfs(int start, int end) {
        Queue<Integer> q = new LinkedList<>();
        int[] dist = new int[10000];
        Arrays.fill(dist, -1);

        q.add(start);
        dist[start] = 0;

        while (!q.isEmpty()) {
            int curr = q.poll();
            if (curr == end) return dist[curr];

            int[] digits = {curr / 1000, (curr / 100) % 10, (curr / 10) % 10, curr % 10};

            for (int i = 0; i < 4; i++) {
                for (int j = 0; j <= 9; j++) {
                    if (i == 0 && j == 0) continue;

                    int next = changeDigit(digits, i, j);

                    if (isPrime[next] && dist[next] == -1) {
                        dist[next] = dist[curr] + 1;
                        q.add(next);
                    }
                }
            }
        }
        return -1;
    }

    static int changeDigit(int[] digits, int index, int value) {
        int res = 0;
        for (int i = 0; i < 4; i++) {
            res *= 10;
            if (i == index) {
                res += value;
            } else {
                res += digits[i];
            }
        }
        return res;
    }

    static void checkPrime() {
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        for (int i = 2; i * i < 10000; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < 10000; j += i) isPrime[j] = false;
            }
        }
    }
}