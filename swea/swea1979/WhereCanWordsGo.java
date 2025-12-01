package swea1979;

import java.util.Scanner;

public class WhereCanWordsGo {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t = 0; t < T; t++) {
			int N = sc.nextInt();
			int K = sc.nextInt();
			int[][] arr = new int[N + 1][N + 1];
			for(int i = 0; i < N + 1; i++) {
				for(int j = 0; j < N + 1; j++) {
					if(i == N || j == N)
						arr[i][j] = 0;
					else
						arr[i][j] = sc.nextInt();
				}
			}
			
			int cnt = 0;
			for(int i = 0; i < N + 1; i++) {
				int length = 0;
				for(int j = 0; j < N + 1; j++) {
					if(length == K) {
						if(arr[i][j] == 0)
							cnt++;
						else {
							while(arr[i][j] != 0)
								j++;
						}
						length = 0;
					}
					else if(arr[i][j] == 1)
						length++;
					else
						length = 0;
				}
			}
			
			for(int j = 0; j < N + 1; j++) {
				int length = 0;
				for(int i = 0; i < N + 1; i++) {
					if(length == K) {
						if(arr[i][j] == 0)
							cnt++;
						else {
							while(arr[i][j] != 0)
								i++;
						}
						length = 0;
					}
					else if(arr[i][j] == 1)
						length++;
					else
						length = 0;
				}
			}
			System.out.println("#" + (t + 1) + " " + cnt);
		}
		sc.close();
	}
}
