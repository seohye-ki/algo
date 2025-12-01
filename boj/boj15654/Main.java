package boj15654;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int[] arr;
	static int[] visited;
	static int[] result;
	static int N;
	static int M;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		result = new int[N];
		visited = new int[N];
		arr = new int[N];
		for(int i = 0; i < N; i++)
			arr[i] = sc.nextInt();
		Arrays.sort(arr);
		dfs(0);
		
		System.out.println(sb);
		sc.close();
	}
	
	static void dfs(int cnt) {
		if(cnt == M) {
			for(int i = 0; i < M; i++)
				sb.append(result[i] + " ");
			sb.append("\n");
			return ;
		}
		
		for(int i = 0; i < N; i++) {
			if(visited[i] == 0) {
				visited[i] = 1;
				result[cnt] = arr[i];				
				dfs(cnt + 1);
				visited[i] = 0;
			}
		}
	}
}
