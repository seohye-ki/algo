package swea1961;

import java.util.Scanner;

public class NumArrRotate {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t = 0; t < T; t++) {
			int N = sc.nextInt();
			String[][] origin = new String[N][N];
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++)
					origin[i][j] = sc.next();
			}
			
			//90도
			String[] r90 = new String[N];
			for(int j = 0; j < N; j++) {
				String tmp = "";
				for(int i = N - 1; i >= 0; i--) {
					 tmp = tmp + origin[i][j];
				}
				r90[j] = tmp;
			}
			
			//180도
			String[] r180 = new String[N];
			for(int i = N - 1; i >= 0; i--) {
				String tmp = "";
				for(int j = N - 1; j >= 0; j--) {
					 tmp = tmp + origin[i][j];
				}
				r180[N - 1 - i] = tmp;
			}
			
			//270도
			String[] r270 = new String[N];
			for(int j = N - 1; j >= 0; j--) {
				String tmp = "";
				for(int i = 0; i < N; i++) {
					 tmp = tmp + origin[i][j];
				}
				r270[N - 1 - j] = tmp;
			}
			//출력
			System.out.println("#" + (t + 1));
			for(int i = 0; i < N; i++) {
				System.out.print(r90[i]);
				System.out.print(" " + r180[i]);
				System.out.print(" " + r270[i]);
				System.out.println();
			}
		}
		
		sc.close();
	}
}
