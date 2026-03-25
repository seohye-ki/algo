import java.util.*;
import java.io.*;

public class boj2792 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] gems = new int[M];
		int maxGem = 0;
		for (int i = 0; i < M; i++) {
			gems[i] = Integer.parseInt(br.readLine().trim());
			maxGem = Math.max(maxGem, gems[i]);
		}

		long lo = 1;
		long hi = maxGem;
		long answer = maxGem;
		while (lo <= hi) {
			long mid = (lo + hi) / 2;
			if (can(gems, N, mid)) {
				answer = mid;
				hi = mid - 1;
			} else {
				lo = mid + 1;
			}
		}

		System.out.println(answer);
	}

	static boolean can(int[] gems, long N, long mid) {
		long students = 0;
		for (int c : gems) {
			students += (c + mid - 1) / mid;
			if (students > N)
				return false;
		}
		return students <= N;
	}

}
