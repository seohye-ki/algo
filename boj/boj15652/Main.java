package boj15652;

import java.util.Scanner;

public class Main {
	static int N;
	static int M;
	static int[] result;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		result = new int[M];
		dfs(0, 0);
		System.out.println(sb);
		sc.close();
	}
	
	static void dfs(int start, int cnt) {
		if(cnt == M) {
			for(int i = 0; i < M; i++) {
				sb.append(result[i] + " ");
			}
			sb.append("\n");
			return ;
		}
		
		for(int i = start; i < N; i++) {
			result[cnt] = (i + 1);
			dfs(i, cnt + 1);
		}
	}
}
