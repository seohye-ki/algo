package boj10163;

import java.util.Scanner;

public class Confetti {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] map = new int[1001][1001];
		
		int N = sc.nextInt();
		for(int t = 0; t < N; t++) {
			int c = sc.nextInt();
			int r = sc.nextInt();
			int nc = sc.nextInt();
			int nr = sc.nextInt();
			for(int i = r; i < r + nr; i++) {
				for(int j = c; j < c + nc; j++)
					map[i][j] = t + 1;
			}
		}
		
		int[] confetti = new int[N];
		for(int i = 0; i < 1001; i++) {
			for(int j = 0; j < 1001; j++) {
				if(map[i][j] == 0)
					continue;
				else
					confetti[map[i][j] - 1]++;			
			}
		}
		for(int n : confetti)
			System.out.println(n);
		sc.close();
	}
}
