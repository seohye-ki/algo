package swea2005;

import java.util.Scanner;

public class PascalTriangle {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t = 0; t < T; t++) {
			int N = sc.nextInt();
			int[][] triangle = new int[N][10];
			for(int i = 0; i < N; i++) {
				triangle[i][0] = 1;
				triangle[i][i] = 1;
				for(int j = 1; j < i; j++) {
					triangle[i][j] = triangle[i - 1][j - 1] + triangle[i - 1][j];
				}
			}
			
			
			//출력
			System.out.println("#" + (t+1));
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(triangle[i][j] != 0)
						System.out.print(triangle[i][j] + " ");
				}
				System.out.println();
			}
		}
		sc.close();
	}
}
