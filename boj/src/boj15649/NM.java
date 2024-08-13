package boj15649;

import java.util.Scanner;

public class NM {
	static boolean[] visit; //방문했는지 확인하는 배열
	static int[] result; //출력값
	
	//조합
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		visit = new boolean[N];
		result = new int[M];
		dfs(N, M, 0);
		sc.close();
	}
	
	static void dfs(int N, int M, int cnt) {
		//종료조건
		if(cnt == M) {
			for(int i = 0;  i < M; i++)
				System.out.print(result[i] + " ");
			System.out.println();
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(visit[i] == false) {
				visit[i] = true;
				result[cnt] = (i + 1);
				dfs(N, M, cnt + 1);
				visit[i] = false;
			}			
		}
		return;
	}
}
