package boj3190;

import java.util.Scanner;

// 15:05 ~

public class Main {
	static int N; //보드 크기
	static int[][] map;
	static int sec = 0; //게임시간
	static int[] dr = {0, 1, 0, -1}; //우하좌상
	static int[] dc = {1, 0, -1, 0};
	static int dir = 0; //뱀의 현재 방향
	static int x = 0; //뱀의 머리 열 좌표
	static int y = 0; //뱀의 머리 행 좌표
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		int K = sc.nextInt(); //아이템수
		//맵에 아이템 표시하기 2번으로
		for(int i = 0; i < K; i++) {
			int r = sc.nextInt() - 1;
			int c = sc.nextInt() - 1;
			map[r][c] = 2;
		}
		
		//움직이기
		int L = sc.nextInt(); //뱀이 몇번 방향을 바꾸는지
		for(int i = 0; i < L; i++) {
			int M = sc.nextInt(); //뱀이 몇초 움직이는지
			String cmd = sc.next(); //어디로 회전할지
			//1칸씩 움직이기
			for(int j = 0; j < M; j++) {
				//1칸 움직이기
				y += dr[dir];
				x += dc[dir];
				
				//벽이라면 끝!
				if(x < 0 || N <= x || y < 0 || N <= y) {
					System.out.println(sec);
					return ;
				}
				//아이템이라면 머리만 움직임
				else if(map[y][x] == 2) {
					
				}
					
			}
		}
		
		sc.close();
	}
}
