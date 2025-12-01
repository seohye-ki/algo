package swea1954;

import java.util.Scanner;

public class SnailNumber {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t = 0; t < T; t++) {
			int N = sc.nextInt();
			int[][] arr = new int[N][N];
			int cnt = 1;
			int r = 0;
			int c = 0;
			int flag = 1;
			int round = 0;
			int d = 0;
			arr[r][c] = 1;
			cnt++;
			while(round < (N * 2) - 1) {
				if(round % 2 == 1)
					d++;
				//오른쪽
				if(flag == 1) {
					for(int i = 0; i < N - d; i++) {
						if(c + 1 == N)
							break;
						c += 1;
						arr[r][c] = cnt;
						cnt++;
					}
					flag = 2;
				}
				//아래
				else if(flag == 2) {
					for(int i = 0; i < N - d; i++) {
						r += 1;
						arr[r][c] = cnt;
						cnt++;
					}
					flag = 3;
				}
				//왼쪽
				else if(flag == 3) {
					for(int i = 0; i < N - d; i++) {
						c -= 1;
						arr[r][c] = cnt;
						cnt++;
					}
					flag = 4;
				}
				//위쪽
				else {
					for(int i = 0; i < N - d; i++) {
						r -= 1;
						arr[r][c] = cnt;
						cnt++;
					}
					flag = 1;
				}
				round++;
			}
			//출력
			System.out.println("#" + (t + 1));
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++)
					System.out.print(arr[i][j] + " ");
				System.out.println();
			}
		}
		sc.close();
	}
}
