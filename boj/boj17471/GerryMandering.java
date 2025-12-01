package boj17471;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class GerryMandering {
	static int N;
	static int[] population;
	static boolean[][] link;
	static boolean[] visited;
	static int min = Integer.MAX_VALUE;
	static int valid = 0;
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); //선거구 수
		population = new int[N]; //인구수 배열
		link = new boolean[N][N]; //링크배열
		visited = new boolean[N];
		
		//인구수 배열 채우기
		for(int i = 0; i < N; i++)
			population[i] = sc.nextInt();
		
		//링크 정보 받아오기
		for(int i = 0; i < N; i++) {
			int cnt = sc.nextInt();
			link[i][i] = true;
			for(int j = 0; j < cnt; j++)
				link[i][sc.nextInt() - 1] = true; 
		}
		
		dfs(0);
		if(valid == 0)
			System.out.println("-1");
		else
			System.out.println(min);
		
		sc.close();
	}
	
	static void dfs(int start) {
		//최소 수가 나온다면 
		if(min == 0)
			return ;
		
		if(start == N) {
//			System.out.println(Arrays.toString(visited));
			//link되어있는 유효한 경우인지 확인 true면 연결되어있음 / false는 연결되어있지 않음
			if(linkValid()) {
				valid = 1;
				int A = 0;
				int B = 0;
				for(int i = 0; i < N; i++) {
					if(visited[i])
						A += population[i];
					else
						B += population[i];						
				}
				if(Math.abs(A - B) < min)
					min = Math.abs(A - B);
			}
			return ;
		}
		
		//포함하고 돌리기 
		visited[start] = true;
		dfs(start + 1);
		
		//포함하지 않고 돌리기 
		visited[start] = false;
		dfs(start + 1);
	}
	
	static boolean linkValid() {
		//true그룹끼리 false그룹끼리 링크 되어있는지 확인 
		return isConnected(true) && isConnected(false);
	}
	
	static boolean isConnected(boolean group) {
		Queue<Integer> queue = new LinkedList<>();
		boolean[] check = new boolean[N];
		boolean init = false;
		
		for(int i = 0; i < N; i++) {
			if(visited[i] == group) {
				queue.add(i);
				check[i] = true;
				init = true;
				break;
			}
		}
		
		if(init == false)
			return true;
		
		while(!queue.isEmpty()) {
			int curr = queue.poll();
			for(int i = 0; i < N; i++) {
				if(visited[i] == group && link[curr][i] && !check[i]) {
					queue.add(i);
					check[i] = true;
				}
			}
		}
		
		for (int i = 0; i < N; i++) {
	        if (visited[i] == group && !check[i])
	            return false;
	    }
		return true;
	}
}
