package swea4615;

import java.util.Scanner;

public class Othello {
	static int[] dr = {-1, -1, -1, 0 ,1 , 1, 1, 0}; //시계방향
	static int[] dc = {-1, 0, 1, 1 ,1 , 0, -1, -1}; //시계방향
	static int[][] board;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt(); //보드 한변의 길이
			int M = sc.nextInt(); //턴 수
			
			//초기 세팅 0: 빈공간, 1: 흑돌, 2: 백돌
			board = new int[N][N];
			//흑돌
			board[N/2 - 1][N/2] = 1;
			board[N/2][N/2 - 1] = 1;
			//백돌
			board[N/2 - 1][N/2 - 1] = 2;
			board[N/2][N/2] = 2;
			
			
			//시뮬레이션 돌리기
			for(int i = 0; i < M; i++) {
				int col = sc.nextInt(); //열
				int row = sc.nextInt(); //행
				int stone = sc.nextInt(); //흑 또는 백
				
				//돌 두기
				board[--row][--col] = stone;
				
				//중심에서 주변을 확인하기(델타탐색)
				for(int k = 0;  k < 8; k++) {
					int r = row + dr[k];
					int c = col + dc[k];
					if(0 <= r && r < N && 0 <= c && c < N && board[r][c] != stone && board[r][c] != 0)
						change(N, r, c, dr[k], dc[k], stone); //다 바꾸기
				}
				for(int p = 0; p < N; p++) {
					for(int q = 0; q < N; q++) {
						System.out.print(board[p][q] + " ");
					}
					System.out.println();
				}
			}
			
			//출력
			int black = 0;
			int white = 0;
			for(int k = 0; k < N; k++) {
				for(int l = 0; l < N; l++) {
					if(board[k][l] == 1)
						black++;
					else
						white++;
				}
			}
			System.out.println("#" + test_case + " " + black + " " + white);
		}
		
		sc.close();
	}
	
	
	static void change(int N, int r, int c, int dr, int dc, int stone) {
		int row = r;
		int col = c;
		int flag = 0; //0이면 없음, 1이면 있음
		
		//이 방향으로 쭉 가다가 다른 스톤을 만나는지 확인
		while(0 <= row && row < N && 0 <= col && col < N && board[row][col] != 0) {
			if(board[row][col] == stone) {
				flag = 1;
				break;
			}
			row += dr;
			col += dc;
		}
		
		//이방향에는 같은 돌이 끝에 없음
		if(flag == 0)
			return;
		
		while(0 <= r && r < N && 0 <= c && c < N && board[r][c] != stone && board[r][c] != 0) {
			board[r][c] = stone;
			r += dr;
			c += dc;
		}
	}
}
