package boj15651;

import java.util.Scanner;

public class Main {
	static int[] result;
	static int N;
	static int M;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		result = new int[M];
		dfs(0);
		System.out.println(sb);
		sc.close();
	}
	
	static void dfs(int cnt) {
		if(cnt == M) {
			for(int i = 0;  i < M; i++) {
				sb.append(result[i] + " ");
			}
			sb.append("\n");
			return ;
		}
		
		for(int i = 0; i < N; i++) {
			result[cnt] = (i + 1);
			dfs(cnt + 1);
		}
	}
}
