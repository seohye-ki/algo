package swea5215;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	static int L;
	static int N;
	static int M; //몇개까지
	static int[] result;
	static int[] kcal;
	static int[] score;
	static int[] visited;
	static int max;
	static int maxKcal;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++) {
			max = 0;
			N = sc.nextInt(); //입력받을 음식 수
			L = sc.nextInt(); //최대 칼로리
			kcal = new int[N]; //칼로리 배열
			score = new int[N]; //맛점수 배열
			
			for(int i = 0 ; i < N; i++) {
				score[i] = sc.nextInt();
				kcal[i] = sc.nextInt();
			}
			
			for(int i = 0; i < N; i++) {
				M = i + 1;
				result = new int[M];
				visited = new int[N];
				maxKcal = 0;
				dfs(0, 0);
			}
			System.out.println("#" + test_case + " " + max);
		}		
		sc.close();
	}
	
	static void dfs(int start, int cnt) {
		if(cnt == M) {
			int sumKcal = 0;
			int sumScore = 0;
			for(int i = 0; i < M; i++) {
				sumKcal += kcal[result[i]];
				sumScore += score[result[i]];
			}
			
			if(sumKcal <= L && sumScore > max) {
				
				System.out.println(Arrays.toString(result));
				System.out.println("sumk : " + sumKcal + " sums : " + sumScore);
				max = sumScore;
			}
			return ;
		}
		
		for(int i = 0; i < N; i++) {
			if(visited[i] == 0) {
				visited[i] = 1;
				result[cnt] = i;
				dfs(i + 1, cnt + 1);
				visited[i] = 0;
			}
		}
	}
}
