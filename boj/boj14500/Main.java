package boj14500;

import java.util.Scanner;

public class Main {
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int N;
	static int M;
	static int[][] map;
	static boolean[][] visited;
	static int max;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); //세로
		M = sc.nextInt(); //가로
		map = new int[N][M];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++)
				map[i][j] = sc.nextInt();
		}

		max = 0;
		visited = new boolean[N][M];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++)
				dfs(i, j, 0, 0);
		}
		System.out.println(max);
		sc.close();
	}
	
	static void dfs(int i, int j, int cnt, int sum) {
		if(cnt == 4) {
			if(max < sum)
				max = sum;
			return;
		}
		
		for(int k = 0; k < 4; k++) {
			int row = i + dr[k];
			int col = j + dc[k];
			if(0 <= row && row < N && 0 <= col && col < M && visited[row][col] == false) {
				if(cnt == 2) {
					visited[row][col] = true;
					dfs(i, j, cnt + 1, sum + map[row][col]);
					visited[row][col] = false;
				}
				visited[row][col] = true;
				dfs(row, col, cnt + 1, sum + map[row][col]);
				visited[row][col] = false;
			}
				
		}
	}
}
