package boj15664;

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
		for(int i = 0; i < N; i++)
			arr[i] = sc.nextInt();
		Arrays.sort(arr);
		result = new int[M];
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
		
		int before = 0;
		for(int i = start; i < N; i++) {
			if(before != arr[i]) {
				result[cnt] = arr[i];
				before = arr[i];
				dfs(i + 1, cnt + 1);			
			}
		}
	}
}
