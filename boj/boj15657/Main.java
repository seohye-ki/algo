package boj15657;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N;
	static int M;
	static int[] arr;
	static int[] result;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N];
		result = new int[M];
		for(int i = 0; i < N; i++)
			arr[i] = sc.nextInt();
		Arrays.sort(arr);
		dfs(0, 0);
		System.out.println(sb);
		
		sc.close();
	}
	
	static void dfs(int start, int cnt) {
		if(cnt == M) {
			for(int i = 0; i < M; i++)
				sb.append(result[i] + " ");
			sb.append("\n");
			return ;
		}
		
		for(int i = start; i < N; i++) {
			result[cnt] = arr[i];
			dfs(i, cnt + 1);
		}
	}
}
