package boj2567;

import java.util.Arrays;
import java.util.Scanner;

public class Confetti2_v1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//100 * 100 도화지
		int[][] paper = new int[100][100];
		for(int i = 0; i < 100; i++)
			Arrays.fill(paper[i], 4);
		
		int N = sc.nextInt();
		for(int t = 0;  t < N; t++) {
			int x = sc.nextInt();
			int y = sc.nextInt();

			//빈공간: 4, 테두리: 3, 꼭짓점: 2, 변: 1, 면: 0
			// x1 < x2, y1 < y2(배열이라 반대긴함)
			int x1 = x;
			int x2 = x + 9;
			int y1 = 100 - y - 1;
			int y2 = 100 - y - 10;
			for(int r = y1; r >= y2; r--) {
				for(int c = x1; c <= x2; c++) {
					//이미 색종이 붙어있으면  
					if(paper[r][c] == 0)
						continue;
					
					//빈공간이라면
					else if(paper[r][c] == 4) {
						//들어갈 값이 꼭짓점일때 
						if((r == y1 && c == x1) || (r == y2 && c == x1) || (r == y1 && c == x2) || (r == y2 && c == x2))
							paper[r][c] = 2;
						//들어갈 값이 변일때 
						else if(r == y1 || r == y2 || c == x1 || c == x2)
							paper[r][c] = 1;
						else
							paper[r][c] = 0;
					}
	
					//테두리라면 
					else if(paper[r][c] == 3) {
						//아랫변 
						if(r == y1) {
							paper[r][c] = 2;
							//아래 확인
							if(r + 1 < 100 && (paper[r + 1][c] == 2 || paper[r + 1][c] == 1)) {
								paper[r][c]--;
								paper[r + 1][c]--;
							}
							//왼쪽 꼭짓점 
							if(c == x1) {
								if(c - 1 >= 0 && (paper[r][c - 1] == 2 || paper[r][c - 1] == 1)) {
									paper[r][c]--;
									paper[r][c - 1]--;
								}
							}
							//오른쪽 꼭짓점 
							else if(c == x2) {
								if(c + 1 < 100 && (paper[r][c + 1] == 2 || paper[r][c + 1] == 1)) {
									paper[r][c]--;
									paper[r][c + 1]--;
								}
							}
							else 
								paper[r][c]--;
						}
						//윗변 
						else if(r == y2) {
							paper[r][c] = 2;
							//위에 확인 
							if(r - 1 >= 0 && (paper[r - 1][c] == 2 || paper[r - 1][c] == 1)) {
								paper[r][c]--;
								paper[r - 1][c]--;
							}
							//왼쪽 꼭짓점 
							if(c == x1) {
								if(c - 1 >= 0 && (paper[r][c - 1] == 2 || paper[r][c - 1] == 1)) {
									paper[r][c]--;
									paper[r][c - 1]--;
								}
							}
							//오른쪽 꼭짓점 
							else if(c == x2) {
								if(c + 1 < 100 && (paper[r][c + 1] == 2 || paper[r][c + 1] == 1)) {
									paper[r][c]--;
									paper[r][c + 1]--;
								}
							}
							else
								paper[r][c]--;
						}
						//좌변 
						else if(c == x1) {
							//왼쪽 확인 
							if(c - 1 >= 0 && (paper[r][c - 1] == 2 || paper[r][c - 1] == 1)) {
								paper[r][c]--;
								paper[r][c - 1]--;
							}
						}
						//우변 
						else if(c == x2) {
							//오른쪽 확인 
							if(c + 1 < 100 && (paper[r][c + 1] == 2 || paper[r][c + 1] == 1)) {
								paper[r][c]--;
								paper[r][c + 1]--;
							}
						}
						//면 
						else
							paper[r][c] = 0;
					}
					
					//변이나 꼭짓점이라면
					else {
						//아랫변 
						if(r == y1) {
							//왼쪽 꼭짓점 
							if(c == x1) {
								if(c - 1 < 0 || (c - 1 >= 0 && paper[r][c - 1] == 3) || r + 1 >= 100 || (r + 1 < 100 && paper[r + 1][c] == 3)) {
									if(paper[r][c] == 1)
										paper[r][c] = 1;
									else
										paper[r][c] = 2;
								}
								else
									paper[r][c] = 0;
							}
							//오른쪽 꼭짓점 
							else if(c == x2) {
								if(c + 1 >= 100 || (c + 1 < 100 && paper[r][c + 1] == 3) || r + 1 >= 100 || (r + 1 < 100 && paper[r + 1][c] == 3)) {
									if(paper[r][c] == 1)
										paper[r][c] = 1;
									else
										paper[r][c] = 2;
								}
								else
									paper[r][c] = 0;
							}
							else {
								if(r + 1 >= 100 || (r + 1 < 100 && paper[r + 1][c] == 3))
									paper[r][c] = 1;
								else
									paper[r][c] = 0;
							}
						}
						//윗변 
						else if(r == y2) {
							//왼쪽 꼭짓점 
							if(c == x1) {
								if(r - 1 < 0 || (r - 1 >= 0 && paper[r - 1][c] == 3) || c - 1 < 0 || (c - 1 >= 0 && paper[r][c - 1] == 3)) {
									if(paper[r][c] == 1)
										paper[r][c] = 1;
									else
										paper[r][c] = 2;
								}
								else
									paper[r][c] = 0;
							}
							//오른쪽 꼭짓점 
							else if(c == x2) {
								if(c + 1 >= 100 || (c + 1 < 100 && paper[r][c + 1] == 3) || r - 1 < 0|| (r - 1 >= 0 && paper[r - 1][c] == 3)) {
									if(paper[r][c] == 1)
										paper[r][c] = 1;
									else
										paper[r][c] = 2;
								}
								else
									paper[r][c] = 0;
							}
							else {
								if(r - 1 < 0 || (r - 1 >= 0 && paper[r - 1][c] == 3))
									paper[r][c] = 1;
								else
									paper[r][c] = 0;
							}
						}
						//좌변 
						else if(c == x1) {
							if(c - 1 < 0 || (c - 1 >= 0 && paper[r][c - 1] == 3))
								paper[r][c] = 1;
							else
								paper[r][c] = 0;
						}
						//우변 
						else if(c == x2) {
							if(c + 1 >= 100 || (c + 1 < 100 && paper[r][c + 1] == 3))
								paper[r][c] = 1;
							else
								paper[r][c] = 0;
						}
						//면 
						else
							paper[r][c] = 0;
					}
				}
			}
			//테두리 칠하기
			//상단
			if(99 - y - 10 >= 0) {
				for(int c = x; c < x + 10; c++) {
					if(paper[99 - y - 10][c] == 4)
						paper[99 - y - 10][c] = 3;				
				}
			}
			//하단
			if(99 - y + 1 < 100) {
				for(int c = x; c < x + 10; c++) {
					if(paper[99 - y + 1][c] == 4)
						paper[99 - y + 1][c] = 3;	
				}
			}
			//좌측
			if(x - 1 >= 0) {
				for(int r = 99 - y; r >= 100 - y - 10; r--) {					
					if(paper[r][x - 1] == 4)
						paper[r][x - 1] = 3;
				}
			}
			//우측
			if(x + 10 < 100) {
				for(int r = 99 - y; r >= 100 - y - 10; r--) {
					if(paper[r][x + 10] == 4)
						paper[r][x + 10] = 3;	
				}
			}
			System.out.println();
			for(int i = 0;  i < 100; i++) {
				for(int j = 0; j < 100; j++) {
					System.out.print(paper[i][j]);
				}
				System.out.println();
			}
		}
		//둘레 계산
		int total = 0;
		for(int i = 0;  i < 100; i++) {
			for(int j = 0; j < 100; j++) {
				if(paper[i][j] == 1 || paper[i][j] == 2)
					total += paper[i][j];
			}
		}			
		System.out.println(total);
		sc.close();
	}
}
