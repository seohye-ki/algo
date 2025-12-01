package swea2115;

//import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	static int[][] map;
	static int max = 0;
	static int N;
	static int M;
	static int C;
	static int[] arr1;
	static int[] arr2;
	static boolean[] visited;
	static int[] result;
	static int arrMax;
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++) {
			max = 0;
			N = sc.nextInt(); //map의 크기
			M = sc.nextInt(); //선택할 수 있는 벌통의 개수
			C = sc.nextInt(); //채쥐가능 꿀의 양
			arr1 = new int[M];
			arr2 = new int[M];
			map = new int[N][N];
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++)
					map[i][j] = sc.nextInt();
			}
			
			//같은 행에서 벌꿀 채취하는 경우
			if((N / M) > 1) {
				for(int row = 0; row < N; row++)
					rowEqual(row);
			}
			
			//다른 행에서 벌꿀 채취하는 경우
			for(int row1 = 0; row1 < N - 1; row1++) {
				for(int row2 = row1 + 1; row2 < N; row2++)
					rowDiff(row1, row2);
			}
			System.out.println("#" + test_case + " " + max);
		}
		sc.close();
	}
	//같은 행에서 모든 조합 구하기
	static void rowEqual(int row) {
		for(int i = 0; i < N - (2 * M) + 1; i++) {
			int idx = 0;
			for(int j = i; j < i + M; j++)
				arr1[idx++] = map[row][j]; //arr1완성
			for(int p = i + M; p < N - M + 1; p++) {
				idx = 0;
				for(int q = p; q < p + M; q++)
					arr2[idx++] = map[row][q]; //arr2완성
				arrMax = 0;
				findMax(arr1);
				int sum = arrMax;
				arrMax = 0;
				findMax(arr2);
				sum += arrMax;
				if(sum > max)
					max = sum;
			}
		}
	}
	
	//p1행과 p2행에서 만들어지는 모든 조합을 만들기
	static void rowDiff(int row1, int row2) {
		for(int i = 0; i < N - M + 1; i++) {
			int idx = 0;
			for(int j = i; j < i + M; j++)
				arr1[idx++] = map[row1][j]; //arr1완성				
			for(int p = 0; p < N - M + 1; p++) {
				idx = 0;
				for(int q = p; q < p + M; q++)
					arr2[idx++] = map[row2][q]; //arr2완성
				arrMax = 0;
				findMax(arr1);
				int sum = arrMax;
				
				arrMax = 0;
				findMax(arr2);
				sum += arrMax;
				if(sum > max)
					max = sum;
			}
		}
	}
	
	//합이 C를 넘지 않으면서 arr에서 만들 수 있는 최댓값 찾기
	static void findMax(int[] arr) {
		int i = 1;
		while(i <= M) {
			visited = new boolean[N];
			result = new int[i];
			dfs(arr, i, 0);
			i++;
		}
	}
	
	//조합 구해서 계산하기
	static void dfs(int[] arr, int M, int cnt) {
		//종료조건
		if(cnt == M) {
			int sum = 0;
			int powerSum = 0;
			for(int i = 0;  i < M; i++) {
				sum += result[i];
				powerSum += (result[i] * result[i]);
			}
			//최대 채취량을 넘지 않으면 powerSum리턴 넘으면 0
			if(sum <= C && arrMax < powerSum)
				arrMax = powerSum;
			return ;
		}
		
		for(int i = 0; i < M; i++) {
			if(visited[i] == false) {
				visited[i] = true;
				result[cnt] = arr[i];
				dfs(arr, M, cnt + 1);
				visited[i] = false;
			}			
		}
		return ;
	}
}
