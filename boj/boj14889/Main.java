package boj14889;

import java.util.Scanner;

public class Main {
	static int N;
	static int[][] synergy; //시너지 배열
	static boolean[] comb; //조합저장 배열
	static int min; //차이 최솟값
	
	public static void main(String[] args) {	
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		synergy = new int[N][N];
		
		//synergy arr input
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				synergy[i][j] = sc.nextInt();
			}
		}
		
		//true, false 그룹으로 나누기
		comb = new boolean[N];
		min = Integer.MAX_VALUE;
		div(0, 0);
		System.out.println(min);
		sc.close();
		
	}
	
	//2그룹으로 나누기
	static void div(int start, int cnt) {
		// N/2개 선택하면 끝
		if(cnt == N / 2) {
			//각 그룹의 맛의 합 구하기
			int sum1 = cal(true);
			int sum2 = cal(false);
			if(Math.abs(sum1 - sum2) < min)
				min = Math.abs(sum1 - sum2);
			return;
		}
		
		for(int i = start; i < N; i++) {
			if(comb[i] == false) {
				comb[i] = true; //선택
				div(i + 1, cnt + 1);
				comb[i] = false; //선택해제
			}
		}
	}
	
	//그룹안에서 점수 계산하기
	static int cal(boolean group) {
		//그룹에 속하는 인덱스를 배열에 저장
		int[] arr = new int[N / 2];
		int idx = 0;
		for(int i = 0; i < N; i++) {
			if(comb[i] == group) {
				arr[idx] = i;
				idx++;
			}
		}
		
		//시너지 계산하기
		int sum = 0;
		for(int i = 0; i < (N / 2) - 1; i++) {
			for(int j = i + 1; j < N / 2; j++) {
				sum += (synergy[arr[i]][arr[j]] + synergy[arr[j]][arr[i]]);
			}
		}
		return sum;
	}
}
