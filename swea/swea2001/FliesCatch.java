package swea2001;

import java.util.Scanner;

public class FliesCatch {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t = 0; t < T; t++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int[][] map = new int[N][N];
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++)
					map[i][j] = sc.nextInt();
			}
			
			//계산
			int max = 0;
			for(int i = 0; i < N - M + 1; i++) {
				for(int j = 0; j < N - M + 1; j++) {
					int sum = 0;
					for(int k = i; k < i + M; k++) {
						for(int w = j; w < j + M; w++) {
								sum += map[k][w];
								
						}
					}
					if(max < sum)
						max = sum;
				}
			}
			
			System.out.println("#" + (t + 1) + " " + max);
		}
		
		sc.close();
	}
}
