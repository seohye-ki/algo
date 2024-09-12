package boj12865;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); //물건 개수
		int kg = sc.nextInt(); //담을 수 있는 최대 무게
		int[] weight = new int[N + 1]; //각 물건의 무게 배열
		int[] value = new int[N + 1]; //각 물건의 가치 배열
		
		//input
		for(int i = 1; i <= N; i++) {
			weight[i] = sc.nextInt();
			value[i] = sc.nextInt();
		}
		
		//dp 2차원배열 만들기
		int[][] dp = new int[2][kg + 1];
		//몇번째 물건까지 고려할 것인지 for문
		for(int i = 1; i <= N; i++) {
			//max무게 까지 늘려가면서 계산하기
			for(int w = 0; w <= kg; w++) {
				//가방에 넣을 수 있는 물건이라면
				if(weight[i] <= w) {
					dp[i % 2][w] = Math.max(dp[(i - 1) % 2][w], dp[(i - 1) % 2][w - weight[i]] + value[i]);
				}
				else {
					//못넣으면 전에 넣은 값이 best!
					dp[i % 2][w] = dp[(i - 1) % 2][w];
				}
			}
		}
		System.out.println(dp[N % 2][kg]);
	}
}
