package swea7102;

import java.util.Scanner;

public class CardPlay {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t = 0; t < T; t++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int[] count = new int[N + M - 1]; //빈도수 체크
			
			//빈도수 체크하기
			for(int i = 1; i <= N; i++) {
				for(int j = 1; j <= M; j++) {
					count[i + j - 2]++;
				}
			}
			
			//가장 많이 나오는게 몇번인지 확인하기
			int max = count[0];
			for(int i = 0; i < N + M - 1; i++) {
				if(max < count[i])
					max = count[i];
			}
			
			//출력
			System.out.print("#" + (t+1) + " ");
			for(int i = 0; i < N + M - 1; i++) {
				if(max == count[i])
					System.out.print((i + 2) + " ");					
			}
			System.out.println();
		}
		
		sc.close();
	}
}