package swea1215;

import java.util.Scanner;

public class Palindrome {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] result = new int[10];
		for (int t = 0; t < 10; t++) {
			//입력
			int N = sc.nextInt();
			String[][] map = new String[8][];
			for(int i = 0; i < 8; i++)
				map[i] = sc.next().split("");
			
			if(N == 1) {
				result[t] = 64;
				continue;
			}
			
			//검사 
			int cnt = 0;
			for(int i = 0; i < 8; i++) {
				for(int j = 0; j < 8; j++) {
					//가로 확인
					if(j + N - 1 < 8) {
						int flag = 0;
						for(int k = 0; k < N / 2; k++) {
							if(!(map[i][j + k].equals(map[i][j + N - 1 - k]))) {
								flag = 1;
								break;
							}
						}
						if(flag == 0)
							cnt++;
					}
					
					//세로 확인
					if(i + N - 1 < 8) {
						int flag = 0;
						for(int k = 0; k < N / 2; k++) {
							if(!(map[i + k][j].equals(map[i + N - 1 - k][j]))) {
								flag = 1;
								break;
							}
						}
						if(flag == 0)
							cnt++;
					}
				}
			}
			result[t] = cnt;
		}

		//출력 
		for (int i = 0; i < 10; i++)
			System.out.println("#" + (i + 1) + " " + result[i]);
		sc.close();
	}
}
