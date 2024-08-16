package boj17144;

import java.util.Arrays;
import java.util.Scanner;

public class Bye {
	static int[][] newMap;
	static int R;
	static int C;
	static int[] dr = {-1, 0, 1, 0}; //시계방향
	static int[] dc = {0, 1, 0, -1}; //시계방향
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt(); //행
		C = sc.nextInt(); //열
		int T = sc.nextInt(); //초
		int[][] map = new int[R][C]; //map
		
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++)
				map[i][j] = sc.nextInt();
		}
		
		newMap = map;
		//T초 동안 돌리기
		for(int n = 0; n < T; n++) {
			int[][] oldMap = newMap;
			//1. 미세먼지 확산
			newMap = spread(oldMap);
			System.out.println(Arrays.deepToString(newMap));
			
			//2. 미세먼지 회전
			newMap = rotate(newMap);
			System.out.println(Arrays.deepToString(newMap));
		}
		sc.close();		
	}
	
	//미세먼지 확산
	static int[][] spread(int[][] oldMap) {
		int[][] change = new int[R][C];
		
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				if(oldMap[i][j] == 0 || oldMap[i][j] == -1) {
					if(oldMap[i][j] == -1)
						change[i][j] = -1;
					continue;
				}
				
				int dust = oldMap[i][j] / 5; //한칸에 흩어지는 양
				change[i][j] += oldMap[i][j];
				for(int k = 0; k < 4; k++) {
					int row = i + dr[k];
					int col = j + dc[k];
					if(row < R && 0 <= row && col < C && 0 <= col && oldMap[row][col] != -1) {
						change[row][col] += dust;
						change[i][j] -= dust;
					}
				}
			}
		}
		return change;
	}
	
	
	
	//미세먼지 회전
	static int[][] rotate(int[][] oldMap){
//		int[][] change = new int[R][C];
		int[][] change = oldMap;
		
		//공기청정기 찾기
		int row = 0;
		for(int i = 0; i < R; i++) {
			if(oldMap[i][0] == -1) {
				row = i;
				break ;
			}
		}
		
		//상단 반시계회전 - 오른쪽으로
		for(int i = 1; i < C; i++) {
			int tmp = oldMap[row][i - 1];
			if(tmp == -1)
				change[row][i] = 0;
			else
				change[row][i] = tmp;
		}
		//상단 반시계회전 - 위쪽으로
		for(int i = row - 1; i >= 0; i--)
			change[i][C - 1] = oldMap[i + 1][C - 1];
		//상단 반시계회전 - 왼쪽으로
		for(int i = C - 2; i >= 0; i--)
			change[0][i] = oldMap[0][i + 1];
		//상단 반시계회전 - 아래쪽으로
		for(int i = 1; i < row; i++)
			change[i][0] = oldMap[i - 1][0];

		
//		//하단 시계회전 - 오른쪽으로
//		for(int i = 1; i < C; i++) {
//			int tmp = oldMap[row + 1][i - 1];
//			if(tmp == -1)
//				change[row][i] = 0;
//			else
//				change[row][i] = tmp;
//		}
//		//상단 반시계회전 - 아래쪽으로
//		for(int i = row; i >= 0; i--)
//			change[i][C - 1] = oldMap[i][C - 1];
//		//상단 반시계회전 - 왼쪽으로
//		for(int i = C - 1; i >= 0; i--)
//			change[0][i] = oldMap[0][i];
//		//상단 반시계회전 - 아래쪽으로
//		for(int i = 0; i <= row; i++) {
//			int tmp = oldMap[row][0];
//			if(tmp == -1)
//				change[i][0] = 0;
//			else
//				change[i][0] = tmp;
//		}
		return change;
	}
}
