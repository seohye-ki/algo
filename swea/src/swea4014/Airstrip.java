package swea4014;


import java.util.Scanner;

public class Airstrip {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int X = sc.nextInt();
			
			int[][] map = new int[N][N];
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++)
					map[i][j] = sc.nextInt();
			}
			
			int total = 0; //활주로를 만들 수 있는 경우의 수
			//가로 한줄 뽑기
			for(int i = 0; i < N; i++) {
				int[] oneline = new int[N];
				for(int j = 0; j < N; j++)
					oneline[j] = map[i][j];
				if(check(oneline, N, X) == 1) {
//					System.out.println(Arrays.toString(oneline));
					total++;
				}
			}
//			System.out.println();
			//세로 한줄 뽑기
			for(int j = 0; j < N; j++) {
				int[] oneline = new int[N];
				for(int i = 0; i < N; i++)
					oneline[i] = map[i][j];
				if(check(oneline, N, X) == 1) {
//					System.out.println(Arrays.toString(oneline));
					total++;
				}
			}
			
			//출력
			System.out.println("#" + test_case + " " + total);
		}
		sc.close();
	}
	
	
	//활주로 건설 가능 여부 확인하기
	static int check(int[] road, int N, int X) {
		//1이하로 차이나는지 확인
		for(int i = 0; i < N - 1; i++) {
			if(Math.abs(road[i] - road[i + 1]) > 1)
				return 0; //유효X
		}
		
		int[] airstrip = new int[N]; //활주로가 건설된곳에 1로 채울 배열
		
		//활주로 건설하기
		for(int i = 0; i < N - 1; i++) {
			//경사로 건설해야 함
			if(road[i] != road[i + 1]) {
				//i가 더 크면
				if(road[i] > road[i + 1]) {
					//경사로 건설이 가능한지 확인
					for(int len = 1; len <= X; len++) {
						//인덱스 범위를 넘어가거나, 같은 높이의 땅이 아니거나, 이미 활주로가 건설되어있으면
						if(i + len >= N || road[i + 1] != road[i + len] || airstrip[i + len] != 0)
							return 0;
					}
					for(int len = 1; len <= X; len++)
						airstrip[i + len] = 1;
				}
				//i + 1이 더 크면
				else {
					//경사로 건설이 가능한지 확인
					for(int len = 0; len < X; len++) {
						//인덱스 범위를 넘어가거나, 같은 높이의 땅이 아니거나, 이미 활주로가 건설되어있으면
						if(i - len < 0 || road[i] != road[i - len] || airstrip[i - len] != 0)
							return 0;
					}
					for(int len = 0; len < X; len++)
						airstrip[i - len] = 1;
				}
			}
		}
//		System.out.println("airstrip : " + Arrays.toString(airstrip));
		return 1;
	}
}
