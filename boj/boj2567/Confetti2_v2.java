package boj2567;

import java.util.Arrays;
import java.util.Scanner;

public class Confetti2_v2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//4: 빈공간 3: 테두리, 2: 꼭짓점, 1: 변, 0: 면 
		int[][] paper = new int[100][100];
		for(int i = 0; i < 100; i++)
			Arrays.fill(paper[i], 4);
		
		int N = sc.nextInt();
		for(int t = 0; t < N; t++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			for(int r = y; r < y + 10; r++) {
				for(int c = x; c < x + 10; c++) {
					if(paper[r][c] == 0)
						continue;
					if(c == x) {
						//꼭짓점
						if(r == y) {
							if(paper[r][c] == 4)
								paper[r][c] = 2;
							else if(paper[r][c] == 3) {
								paper[r][c] = 2;
								if(0 <= c - 1  && (paper[r][c - 1] == 2 || paper[r][c - 1] == 1)) {
									paper[r][c - 1]--;
									paper[r][c]--;
								}
								if(0 <= r - 1 && (paper[r - 1][c] == 2 || paper[r - 1][c] == 1)) {
									paper[r - 1][c]--;
									paper[r][c]--;
								}
							}
							else if(paper[r][c] == 2 || paper[r][c] == 1) {
								if(r - 1 < 0 || (r - 1 >= 0 && paper[r - 1][c] == 3) || c - 1 < 0 || (c - 1 >= 0 && paper[r][c - 1] == 3)) {
									if(paper[r][c] == 1)
										paper[r][c] = 1;
									else
										paper[r][c] = 2;
								}
							}
							else
								paper[r][c] = 0;
							//테두리
							if(0 <= r - 1 && paper[r - 1][c] == 4)
								paper[r - 1][c] = 3;
						}
						//꼭짓점 
						else if(r == (y + 9)) {
							if(paper[r][c] == 4)
								paper[r][c] = 2;
							else if(paper[r][c] == 3) {
								paper[r][c] = 2;
								if(0 <= c - 1 && (paper[r][c - 1] == 2 || paper[r][c - 1] == 1)) {
									paper[r][c - 1]--;
									paper[r][c]--;
								}
								if(r + 1 < 100 && (paper[r + 1][c] == 2 || paper[r + 1][c] == 1)) {
									paper[r + 1][c]--;
									paper[r][c]--;
								}
							}
							else if(paper[r][c] == 2 || paper[r][c] == 1) {
								if(c - 1 < 0 || (c - 1 >= 0 && paper[r][c - 1] == 3) || r + 1 >= 100 || (r + 1 < 100 && paper[r + 1][c] == 3)) {
									if(paper[r][c] == 1)
										paper[r][c] = 1;
									else
										paper[r][c] = 2;
								}
							}
							else
								paper[r][c] = 0;
							//테두리
							if(r + 1 < 100 && paper[r + 1][c] == 4)
								paper[r + 1][c] = 3;
						}
						//변
						else {
							if(paper[r][c] == 4)
								paper[r][c] = 1;
							else if(paper[r][c] == 3) {
								paper[r][c] = 1;
								if(c - 1 >= 0 && (paper[r][c - 1] == 2 || paper[r][c - 1] == 1)) {
									paper[r][c]--;
									paper[r][c - 1]--;
								}
							}
							else if(paper[r][c] != 0) {
								if(c - 1 < 0 || (c - 1 >= 0 && paper[r][c - 1] == 3))
									paper[r][c] = 1;
								else
									paper[r][c] = 0;
							}
							else
								paper[r][c] = 0;
						}
						//테두리
						if(0 <= c - 1 && paper[r][c - 1] == 4)	
							paper[r][c - 1] = 3;
					}
					else if(c == (x + 9)) {
						//꼭짓점
						if(r == y) {
							if(paper[r][c] == 4)
								paper[r][c] = 2;
							else if(paper[r][c] == 3) {
								paper[r][c] = 2;
								if(c + 1 < 100 && (paper[r][c + 1] == 2 || paper[r][c + 1] == 1)) {
									paper[r][c + 1]--;
									paper[r][c]--;
								}
								if(0 <= r - 1 && (paper[r - 1][c] == 2 || paper[r - 1][c] == 1)) {
									paper[r - 1][c]--;
									paper[r][c]--;
								}
							}
							else if(paper[r][c] == 2 || paper[r][c] == 1) {
								if(c + 1 >= 100 || (c + 1 < 100 && paper[r][c + 1] == 3) || r - 1 < 0|| (r - 1 >= 0 && paper[r - 1][c] == 3)) {
									if(paper[r][c] == 1)
										paper[r][c] = 1;
									else
										paper[r][c] = 2;
								}
							}
							else
								paper[r][c] = 0;
							//테두리
							if(0 <= r - 1 && paper[r - 1][c] == 4)
								paper[r - 1][c] = 3;
						}
						//꼭짓점
						else if(r == (y + 9)) {
							if(paper[r][c] == 4)
								paper[r][c] = 2;
							else if(paper[r][c] == 3) {
								paper[r][c] = 2;
								if(c + 1 < 100 && (paper[r][c + 1] == 2 || paper[r][c + 1] == 1)) {
									paper[r][c - 1]--;
									paper[r][c]--;
								}
								if(r + 1 < 100 && (paper[r + 1][c] == 2 || paper[r + 1][c] == 1)) {
									paper[r - 1][c]--;
									paper[r][c]--;
								}
							}
							else if(paper[r][c] == 2 || paper[r][c] == 1) {
								if(c + 1 >= 100 || (c + 1 < 100 && paper[r][c + 1] == 3) || r + 1 >= 100 || (r + 1 < 100 && paper[r + 1][c] == 3)) {
									if(paper[r][c] == 1)
										paper[r][c] = 1;
									else
										paper[r][c] = 2;
								}
							}
							else
								paper[r][c] = 0;
							//테두리
							if(r + 1 < 100 && paper[r + 1][c] == 4)
								paper[r + 1][c] = 3;
						}
						//변
						else {
							if(paper[r][c] == 4)
								paper[r][c] = 1;
							else if(paper[r][c] == 3) {
								paper[r][c] = 1;
								if(c + 1 < 100 && (paper[r][c + 1] == 2 || paper[r][c + 1] == 1)) {
									paper[r][c]--;
									paper[r][c + 1]--;
								}
							}
							else if(paper[r][c] != 0) {
								if(c + 1 >= 100 || (c + 1 < 100 && paper[r][c + 1] == 3))
									paper[r][c] = 1;
								else
									paper[r][c] = 0;
							}
							else
								paper[r][c] = 0;
						}
						//테두리
						if(c + 1 < 100 && paper[r][c + 1] == 4)	
							paper[r][c + 1] = 3;
					}
					else {
						//변
						if(r == y) {
							if(paper[r][c] == 4)
								paper[r][c] = 1;
							else if(paper[r][c] == 3) {
								paper[r][c] = 1;
								if(r - 1 >= 0 && (paper[r - 1][c] == 2 || paper[r - 1][c] == 1)) {
									paper[r][c]--;
									paper[r - 1][c]--;
								}
							}
							else if(paper[r][c] != 0) {
								if(r - 1 < 0 || (r - 1 >= 0 && paper[r - 1][c] == 3))
									paper[r][c] = 1;
								else
									paper[r][c] = 0;
							}
							else
								paper[r][c] = 0;
							//테두리
							if(0 <= r - 1 && paper[r - 1][c] == 4)
								paper[r - 1][c] = 3;
						}
						//변 
						else if(r == (y + 9)) {
							if(paper[r][c] == 4)
								paper[r][c] = 1;
							else if(paper[r][c] == 3) {
								paper[r][c] = 1;
								if(r + 1 < 100 && (paper[r + 1][c] == 2 || paper[r + 1][c] == 1)) {
									paper[r][c]--;
									paper[r + 1][c]--;
								}
							}
							else if(paper[r][c] != 0) {
								if(r + 1 >= 100 || (r + 1 < 100 && paper[r + 1][c] == 3))
									paper[r][c] = 1;
								else
									paper[r][c] = 0;
							}
							else
								paper[r][c] = 0;
							//테두리
							if(r + 1 < 100 && paper[r + 1][c] == 4)
								paper[r + 1][c] = 3;
						}
						//면
						else {
							paper[r][c] = 0;
						}
					}
				}
			}
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
