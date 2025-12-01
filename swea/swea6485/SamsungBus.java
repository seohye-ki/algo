package swea6485;

import java.util.Scanner;

public class SamsungBus {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 0; t < T; t++) {
			int[] route = new int[5000]; //정류장 현황
			
			//입력값 받기
			int N = sc.nextInt(); //버스 수
			int[] start = new int[N];
			int[] end = new int[N];
			for(int i = 0;  i < N; i++) {
				start[i] = sc.nextInt(); //출발지점
				end[i] = sc.nextInt(); //도착지점
			}
			int P = sc.nextInt(); //알고싶은 정류장 수
			int[] busStop = new int[P];
			for(int i = 0;  i < P; i++)
				busStop[i] = sc.nextInt();
			
			//정류장 현황 업데이트
			for(int i = 0; i < N; i++) {
				for(int j = start[i] - 1; j < end[i]; j++) {
					route[j]++;
				}
			}
			
			System.out.print("#" + (t + 1) + " ");
			//출력
			for(int i = 0; i < P; i++) {
				System.out.print(route[busStop[i] - 1] + " ");
			}
			System.out.println();
			
		}
		sc.close();
	}
}
