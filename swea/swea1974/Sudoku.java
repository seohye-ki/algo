package swea1974;

import java.util.Scanner;

public class Sudoku {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t = 0; t < T; t++) {
			int[][] sudoku = new int[9][9];
			for(int i = 0; i < 9; i++) {
				for(int j = 0; j < 9; j++)
					sudoku[i][j] = sc.nextInt();
			}
			
			int flag = 1;
			
			//가로 검증
			r_out : 
			for(int i = 0; i < 9; i++) {
				int[] tmp = new int[9];
				for(int j = 0;  j < 9; j++) {
					if(tmp[sudoku[i][j] - 1] == 1) {
						flag = 0;
						break r_out;
					}
					else
						tmp[sudoku[i][j] - 1] = 1;		
				}
			}
			
			if(flag == 0) {
				System.out.println("#" + (t + 1) + " " + flag);
				continue;
			}
			
			//세로 검증
			c_out : 
			for(int j = 0;  j < 9; j++) {
				int[] tmp = new int[9];
				for(int i = 0; i < 9; i++) {
					if(tmp[sudoku[i][j] - 1] == 1) {
						flag = 0;
						break c_out;
					}
					else
						tmp[sudoku[i][j] - 1] = 1;
				}
			}
			
			if(flag == 0) {
				System.out.println("#" + (t + 1) + " " + flag);
				continue;
			}
			
			//격자 검증
			p_out :
			for(int i = 0; i < 9; i += 3) {
				for(int j = 0; j < 9; j += 3) {
					int[] tmp = new int[9];
					for(int k = i; k < i + 3; k++) {
						for(int w = j; w < j + 3; w++) {
//							System.out.println("r: " + k + " c: " + w);
							if(tmp[sudoku[k][w] - 1] == 1) {
								flag = 0;
								break p_out;
							}
							else
								tmp[sudoku[k][w] - 1] = 1;
						}
					}					
				}
			}

			if(flag == 0)
				System.out.println("#" + (t + 1) + " " + flag);
			else
				System.out.println("#" + (t + 1) + " " + flag);
		}
		
		sc.close();	
	}
}
