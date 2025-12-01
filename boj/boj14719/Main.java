package boj14719;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int H = sc.nextInt();
		int W = sc.nextInt();
		int[][] map = new int[H][W];
		
		int maxHeight = 0;
		for(int j = 0; j < W; j++) {
			int wall = sc.nextInt();
			maxHeight = Math.max(maxHeight, wall);
			for(int i = 0; i < wall; i++) {
				map[i][j] = 1;
			}
		}
		
		int result = 0;
		for(int row = 0; row < maxHeight; row++) {
			int idx = 0;
			while(idx < W) {
				if(map[row][idx] == 1) {
					idx++;
					int cnt = 0;
					while(idx < W && map[row][idx] == 0) {
						cnt++;
						idx++;
					}
					if(idx < W)			
						result += cnt;
				}
				else
					idx++;
			}
		}
		System.out.println(result);
	}
}
