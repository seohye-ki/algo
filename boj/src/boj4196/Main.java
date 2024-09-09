package boj4196;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class Main {
	static int V;
	static int[][] adjArr;
	static boolean[] visited;
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 0; tc < T; tc++) {
			V = sc.nextInt(); //정점 수
			int E = sc.nextInt(); //간선 수
			
			visited = new boolean[V + 1]; //방문처리
			adjArr = new int[V + 1][V + 1]; //인접행렬
			
			for(int i = 0; i < E; i++) {
				int A = sc.nextInt();
				int B = sc.nextInt();
				
				adjArr[A][B] = 1;
				adjArr[B][A] = 1;
			}
			
			int ans = 0;
			for(int i = 1; i < V + 1; i++) {
				if(visited[i] == false) {
					dfs(i);
					ans++;
				}
			}
			System.out.println(ans);
		}
	}

	static void dfs(int cnt) {
		visited[cnt] = true;
		
		for(int i = 0; i < adjArr[cnt].length; i++) {
			if(adjArr[cnt][i] == 1 && visited[i] == false)
				dfs(i);
		}
	}
	
	
}
