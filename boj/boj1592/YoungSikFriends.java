package boj1592;

import java.util.Scanner;

public class YoungSikFriends {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); //참여하는 인원
		int M = sc.nextInt(); //한명이 공을 받아야하는 횟수
		int L = sc.nextInt(); //어디로 던질지
		
		int[] cnt = new int[N];
		int flag = 0;
		int round = 0;
		int curr = 0;
		while(flag == 0) {
			cnt[curr]++; //받은사람 cnt++
			//종료조건 확인
			if(cnt[curr] == M) {
				flag = 1;
				break;
			}
			//공 던질때 받은 횟수 홀수
			else if(cnt[curr] % 2 == 1) {
				if (curr + L < N)
					curr += L;
				else
					curr = (curr + L) - N;
			}
			//공 던질때 받은 횟수 짝수
			else {
				if (0 <= curr - L)
					curr -= L;
				else
					curr = N - Math.abs(curr - L);
			}
			round++;
		}
		System.out.println(round);
		sc.close();
	}
}
