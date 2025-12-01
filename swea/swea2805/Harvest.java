package swea2805;

import java.util.Scanner;

public class Harvest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 0; t < T; t++) {
			int N = sc.nextInt();
			String[] tmp = new String[N];
			for(int i = 0; i < N; i++)
				tmp[i] = sc.next();
			
			//land 2차원배열 만들기
			int[][] land = new int[N][N];
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++)
					land[i][j] = (int)(tmp[i].charAt(j) - '0');
			}
			
			//농작물 수익하는 칸 구하기
			int[][] harvest = new int[N][N];
			for(int i = 0; i < N / 2; i++) {
				for(int j = 0; j < N / 2 - i; j++)
					harvest[i][j] = 0;
				for(int j = N / 2 - i; j < N / 2 - i + i * 2 + 1; j++)
					harvest[i][j] = 1;
				for(int j = N / 2 + i * 2 + 1; j < N; j++)
					harvest[i][j] = 0;
			}
			
			for(int i = N / 2; i >= 0; i--) {
				for(int j = 0; j < N / 2 - i; j++)
					harvest[N - i - 1][j] = 0;
				for(int j = N / 2 - i; j <  N / 2 - i + i * 2 + 1; j++)
					harvest[N - i - 1][j] = 1;
				for(int j = N / 2 - i + i * 2 + 1; j < N; j++)
					harvest[N - i - 1][j] = 0;
			}
			
//			for(int i = 0; i < N; i++) {
//				for(int j = 0; j < N; j++)
//					System.out.print(harvest[i][j]);
//				System.out.println();
//			}
			
			//수확하기
			int sum = 0;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(harvest[i][j] == 1)
						sum += land[i][j];
				}
			}
			System.out.println("#" + (t + 1) + " " + sum);
		}
		sc.close();
	}
}
