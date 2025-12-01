package swea7236;

import java.util.Scanner;

public class WaterDepth {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T  = sc.nextInt();
		int[] result = new int[T];
		for(int t = 0; t < T; t++) {
			int N = sc.nextInt();
			int[][] map = new int[N][N];
			for(int i = 0;  i < N; i++) {
				for(int j = 0; j < N; j++) {
					String tmp = sc.next();
					if(tmp.equals("G"))
						map[i][j] = 0;
					else
						map[i][j] = 1;
				}
			}
			
			//구하기
			int max = 0;
			int[] dr = {-1, -1, -1, 0, 1, 1, 1, 0};
			int[] dc = {-1, 0, 1, 1, 1, 0, -1, -1};
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(map[i][j] == 1) {
						int cnt = 0;
						max = 1;
						for(int k = 0; k < 8; k++) {
							if(i + dr[k] < 0 || N <= i + dr[k] || j + dc[k] < 0 || N <= j + dc[k])
								continue;
							cnt += map[i + dr[k]][j + dc[k]];
						}
						if (cnt == 0)
                            cnt = 1;
						if(max < cnt)
							max = cnt;
					}
				}
			}
			result[t] = max;
		}
		for(int i = 0; i < T; i++)
			System.out.println("#" + (i + 1) + " " + result[i]);
		sc.close();
	}
}
