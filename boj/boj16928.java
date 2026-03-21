import java.util.*;
import java.io.*;

public class boj16928 {
	static int[] board = new int[101];
	static int[] count = new int[101];
	static boolean[] visited = new boolean[101];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		for(int i = 1; i <= 100; i++) {
			board[i] = i;
		}

		for(int i = 0; i < n+m; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			board[s] = e;
		}

		bfs();

	}

	static void bfs() {
		Queue<Integer> q = new LinkedList<>();
		q.offer(1);
		visited[1] = true;
		count[1] = 0;

		while (!q.isEmpty()) {
			int curr = q.poll();

			if(curr == 100) {
				System.out.println(count[curr]);
				return;
			}

			for(int i = 1; i <= 6; i++) {
				int next = curr + i;
				if(100 < next) continue;
				next = board[next];
				if(!visited[next]) {
					visited[next] = true;
					count[next] = count[curr] + 1;
					q.offer(next);
				}
			}
		}
	}
}