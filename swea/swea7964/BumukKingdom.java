package swea7964;

import java.util.Scanner;

public class BumukKingdom {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t = 0; t < T; t++) {
			int N = sc.nextInt(); //왕국 수
			int D = sc.nextInt(); //이동 제한 거리
			int[] kingdom = new int[N];
			for(int i = 0; i < N; i++)
				kingdom[i] = sc.nextInt();
			
			//계산
			int distance = 0;
			int total = 0;
			for(int i = 0; i < N; i++) {
				if(kingdom[i] == 1)
					distance = 0;
				else {
					distance++;
					if(distance == D) {
						total++;
						distance = 0;
					}
				}
			}
			
			//출력
			System.out.println("#" + (t+1) + " " + total);
		}
		sc.close();
	}
}
