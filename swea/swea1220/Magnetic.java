package swea1220;

import java.util.Scanner;

public class Magnetic {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int t = 0; t < 1; t++) {
			//맵 입력받기
			int N = sc.nextInt();
			int[][] map = new int[N][N];
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			//교착상태 카운트
			int total = 0;
			for(int j = 0; j < 100; j++) {
				int n_flag = 0;
				for(int i = 0; i <100; i++) {
					//N극일때
					if(map[i][j] == 1) {
						if(n_flag == 0)
							n_flag = 1;
					}
					//S극일때
					else if(map[i][j] == 2) {
						if(n_flag == 1) {
							total++;
							n_flag = 0;
						}
						
					}
					//빈공간일때
					else
						continue;
				}
			}
			System.out.println("#" + (t + 1) + " " + total);
		}
		sc.close();
	}
}
