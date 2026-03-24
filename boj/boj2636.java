import java.util.*;
import java.io.*;

public class boj2636 {
	static int[][] board;
	static int N, M;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new int[N][M];

		for (int i = 0; i < N; i++){
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++){
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int time = 0;
		int prevCount = 0;

		while (true) {
			int cheese = countCheese();
			if (cheese == 0)
				break;

			prevCount = cheese;
			melt();
			time++;
		}

		System.out.println(time);
		System.out.println(prevCount);
	}

	static void melt() {
		boolean[][] visited = new boolean[N][M];
		Queue<int[]> que = new LinkedList<>();
		List<int[]> melted = new ArrayList<>();

		que.add(new int[]{0, 0});
		visited[0][0] = true;

		while (!que.isEmpty()) {
			int[] curr = que.poll();
			int x = curr[0];
			int y = curr[1];

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (0 <= nx && nx < N && 0 <= ny && ny < M && !visited[nx][ny]) {
					if (board[nx][ny] == 1) {
						melted.add(new int[]{nx, ny});
						visited[nx][ny] = true;
					} else {
						visited[nx][ny] = true;
						que.add(new int[]{nx, ny});
					}
				}
			}
		}

		for (int[] pos : melted) {
			board[pos[0]][pos[1]] = 0;
		}
	}

	static int countCheese() {
        int cnt = 0;
        for (int i = 0; i < N; i++)
            for (int j = 0; j < M; j++)
                if (board[i][j] == 1)
					cnt++;
        return cnt;
    }
}