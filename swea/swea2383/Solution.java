package swea2383;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {
	static int[][] map; //맵
	static boolean visited[]; //방문처리
	static int min; //최소시간
//	static PriorityQueue<Integer> stair1; //1번 계단
//	static PriorityQueue<Integer> stair2; //2번 계단
	static List<int[]> exit; //계단정보
	static List<int[]> loc; //사람위치 정보
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); //테스트케이스 수
		for(int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt(); //한변의 길이
			exit = new ArrayList<>(); //[0]row [1]col [2]계단길이 
			loc = new ArrayList<>(); //[0]row [1]col
			map = new int[N][N];
			
			//지도받기
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
					//계단정보 저장
					if(map[i][j] > 1)
						exit.add(new int[] {i, j, map[i][j]});
					//사람위치 저장
					else if(map[i][j] == 1)
						loc.add(new int[] {i, j});
				}
			}
			
			//내려갈 계단 선택하기(조합으로 돌리기)
			min = Integer.MAX_VALUE;
			visited = new boolean[loc.size()];
			comb(0, loc.size());
			System.out.println("#" + test_case + " " + min);
		}
		sc.close();
	}
	
	static int simulation(int N) {
		PriorityQueue<Integer> one = new PriorityQueue<>(); //첫번째 계단
		PriorityQueue<Integer> two = new PriorityQueue<>(); //두번째 계단
		
		//시간 계산해서 우선순위 큐에 담기
		for(int i = 0; i < N; i++) {
			//true그룹은 첫번재 계단으로 내려감
			if(visited[i] == true) {
				int tmp = movetime(exit.get(0), loc.get(i));
				one.add(tmp);
			}
			//false그룹은 두번째 계단으로 내려감
			else {
				int tmp = movetime(exit.get(1), loc.get(i));
				two.add(tmp);
			}
		}
		
		//걸린 시간 계산하기
		return 0;
	}
	
	
	static void comb(int cnt, int N) {
		if(cnt == N) {
			//걸린시간 계산하기
			int time = simulation(N);
			//min보다 작으면 교체
			if(time < min)
				min = time;
			return;
		}
		
		//1번으로 내려가는 경우
		visited[cnt] = true;
		comb(cnt + 1, N);
		
		//2번으로 내려가는 경우
		visited[cnt] = false;
		comb(cnt + 1, N);
		
	}
	
	//계단까지 가는데 걸리는 시간 계산
	static int movetime(int[] exit, int[] loc) {
		return Math.abs(loc[0] - exit[0]) + Math.abs(loc[1] - exit[1]);
	}
}
