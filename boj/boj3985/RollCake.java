package boj3985;

import java.util.Scanner;

public class RollCake {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int L = sc.nextInt(); //케이크 길이
		int N = sc.nextInt(); //방청객 수
		int[] start = new int[N]; //시작번호
		int[] end = new int[N]; //끝번호
		int[] cnt = new int[N]; //먹는 갯수
		
		//입력
		for(int i = 0; i < N; i++) {
			start[i] = sc.nextInt();
			end[i] = sc.nextInt();
			cnt[i] = end[i] - start[i] + 1;
		}

		//기대값
		int expectMax = 0;
		int maxIdx = 0;
		for(int i = 0; i < N; i++) {
			if(expectMax < cnt[i]){
				expectMax = cnt[i];
				maxIdx = i + 1;
			}
		}

		//실제값
		//롤케이크에 값 적기
		int[] rollCake = new int[L]; //롤케이크
		for(int i = 0; i < N; i++) {
			for(int j = start[i] - 1; j < end[i]; j++){
				if(rollCake[j] == 0)
					rollCake[j] = i + 1;
			}
		}
		//실제값 배열 구하기
		int[] eat = new int[N]; //실제 먹은값 카운트
		for(int i = 0; i < L; i++) {
			if(rollCake[i] == 0)
				continue;
			eat[rollCake[i] - 1]++;
		}
		
		//실제값  max 구하기
		int realMax = 0;
		int realMaxidx = 0;
		for(int i = 0; i < N; i++){
			if(realMax < eat[i]){
				realMax = eat[i];
				realMaxidx = i + 1;
			}
		}
		System.out.println(maxIdx);
		System.out.println(realMaxidx);
		sc.close();
	}
}
