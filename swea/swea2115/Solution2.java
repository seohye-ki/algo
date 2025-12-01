package swea2115;

import java.util.Scanner;

public class Solution2 {
	static int N; //벌통의 크기
	static int M; //벌통의 개수
	static int C; //꿀을 채취할 수 있는 최대 양
	static int map[][];
	static int max;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
			M = sc.nextInt();
			C = sc.nextInt();
			map = new int[N][N];
			
			for(int i = 0;  i < N; i++) {
				for(int j = 0; j < N; j++)
					map[i][j] = sc.nextInt();
			}
			
			max = 0;
			boolean[][] visited = new boolean[N][N];
			//1번의 벌통 구하기
			for(int i = 0; i < N; i++) {
				for(int j = 0;  j < N - M + 1; j++) {
					//열값 옮기기
					for(int k = 0; k < M; k++)
						visited[i][j + k] = true;
					dfs(i, j + M, visited);
					for(int k = 0; k < M; k++)
						visited[i][j + k] = true;
				}
			}
			System.out.println("#" + test_case + " " + max);
		}
		
		sc.close();
	}
	
	static void dfs(int row, int col, boolean[][] visited) {
		for(int i = row; i < N; i++) {
			for(int j = col; j < N - M + 1; j++) {
				if(valid(i, j, visited)) {
					int sum = 0;
					calMax(i, j, 0, 0, sum);
					max = Math.max(max, sum);
				}
			}
		}
	}
	
	//유효한 2번 벌통 구하기
	static boolean valid(int row, int col, boolean[][] visited) {
		for(int i = 0; i < M; i++) {
			if(visited[row][col + i])
				return false;
		}
		return true;
	}
	
	//벌통에서 생산할 수 있는 벌꿀 양 구하기
	static void calMax(int row, int col, int cnt, int cur, int sum) {
		if(cnt == M) {
			sum = Math.max(max, sum);
			return ;
		}
		
		calMax(row, col, cnt + 1, cur, sum);
		int currhoney = map[row][col + cnt];
		if(cur + currhoney <= C) {
			calMax(row, col, cnt + 1, cur + currhoney, sum);
		}
	}
}
