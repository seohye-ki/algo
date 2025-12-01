package swea11315;

import java.util.Scanner;

public class Omok {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t = 0; t < T; t++) {
			//입력 
			int N = sc.nextInt();
			int[][] omakMap = new int[N][N];
			for(int i = 0; i < N; i++) {
				String online = sc.next();
				for(int j = 0; j < N; j++) {
					if(online.charAt(j) == 'o')
						omakMap[i][j] = 1;
					else
						omakMap[i][j] = 0;
				}
			}
			//계산
			String result = "NO";
			out:
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(omakMap[i][j] == 0)
						continue;
					else {
						int cnt = 0;
						//3시 방향
						for(int k = 0; k < 5; k++) {
							if(j + k >= N || omakMap[i][j + k] == 0) {
								break;
							}
							cnt++;
						}
						if(cnt == 5) {
							result = "YES";
							break out;
						}
						else
							cnt = 0;
						
						//5시 방향
						for(int k = 0; k < 5; k++) {
							if(i + k >= N || j + k >= N || omakMap[i + k][j + k] == 0) {
								break;
							}
							cnt++;
						}
						if(cnt == 5) {
							result = "YES";
							break out;
						}
						else
							cnt = 0;
						
						//6시 방향
						for(int k = 0; k < 5; k++) {
							if(i + k >= N || omakMap[i + k][j] == 0) {
								break;
							}
							cnt++;
						}
						if(cnt == 5) {
							result = "YES";
							break out;
						}
						else
							cnt = 0;
						//7시 방향
						for(int k = 0; k < 5; k++) {
							if(i + k >= N || j - k < 0 || omakMap[i + k][j - k] == 0) {
								break;
							}
							cnt++;
						}
						if(cnt == 5) {
							result = "YES";
							break out;
						}
					}
				}
			}
			
			//출력
			System.out.println("#" + (t+1) + " " + result);
		}
		sc.close();
	}
}
