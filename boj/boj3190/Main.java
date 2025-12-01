package boj3190;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class Main {
	static int[] dr = {0, 1, 0, -1}; //우하좌상
	static int[] dc = {1, 0, -1, 0};
	static int N; //보드 크기
	static int[][] map;
	static int dir = 0; //뱀의 현재 방향
	static int headX = 0; //뱀의 머리 열 좌표
	static int headY = 0; //뱀의 머리 행 좌표
	static int tailX = 0; //뱀의 꼬리 열 좌표
	static int tailY = 0; //뱀의 꼬리 행 좌표
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N]; //(0)빈공간, (1)뱀, (2)아이템
		int K = sc.nextInt(); //아이템수
		//아이템 표시
		for(int i = 0; i < K; i++) {
			int r = sc.nextInt() - 1;
			int c = sc.nextInt() - 1;
			map[r][c] = 2;
		}
		
		//움직이기
		int L = sc.nextInt(); //뱀이 몇번 방향을 바꾸는지
		int M = sc.nextInt(); //방향 바꾸는 시간
		String cmd = sc.next(); //바꿀 방향
		int time = 0; //흐른 시간
		int turn = 1; //방향을 몇번 바꿨는지
		map[headY][headX] = 1; //뱀의 처음 위치
		Queue<Integer> move = new LinkedList<>(); //움직임 저장
		
		while(true) {
			time++; //시간 흐르기
			
			//머리 움직이기
			headY += dr[dir];
			headX += dc[dir];
			//움직임 추가
			move.add(dr[dir]);
			move.add(dc[dir]);

			//방향을 바꾼 횟수가 입력받은 것보다 작고 M초가 되었다면
			if(time == M) {
				//방향 바꾸기
				if(cmd.equals("L")) {
					dir--;
					if(dir < 0)
						dir = 3;
				}
				else {
					dir++;
					if(dir >= 4)
						dir = 0;
				}
				
				//새로 입력받기
				if(turn < L) {
					M = sc.nextInt();
					cmd = sc.next();					
				}
				turn++;
			}
			
			//벽에 부딫히면 끝
			if(headY < 0 || N <= headY || headX < 0 || N <= headX) {
				System.out.println(time);
				sc.close();
				return ;
			}
			//아이템이면 머리 늘리기 꼬리 그대로
			else if(map[headY][headX] == 2) {
				map[headY][headX] = 1;
			}
			//빈공간이면 꼬리 줄이기
			else if(map[headY][headX] == 0) {
				map[headY][headX] = 1;
				map[tailY][tailX] = 0;
				tailY += move.poll();
				tailX += move.poll();
			}
			//뱀에 부딫히면 끝
			else {
				System.out.println(time);
				sc.close();
				return ;
			}
		}
	}
}
