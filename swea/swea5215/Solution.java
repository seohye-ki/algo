package swea5215;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	static int L;
	static int N;
	static int M; //몇개까지
	static int max;
	static int ing[][];
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++) {
			max = 0;
			N = sc.nextInt(); //입력받을 음식 수
			L = sc.nextInt(); //최대 칼로리
			ing = new int[N][2];
			
			for(int i = 0 ; i < N; i++) {
				
				ing[i][0] = sc.nextInt(); //점수 
				ing[i][1] = sc.nextInt(); //칼로리 
			}
			Arrays.sort(ing, (a, b)->(a[1] - b[1]));
//			System.out.println(Arrays.deepToString(ing));
			
			for(int i = 0; i < N; i++) {
				M = i + 1;
				dfs(0, 0, 0, 0);
			}
			
			System.out.println("#" + test_case + " " + max);
		}		
		sc.close();
	}
	
	static void dfs(int start, int cnt, int sumScore, int sumKcal) {
		if(sumKcal > L)
			return ;
		
		if(cnt == M) {
//			System.out.println("===============");
//			System.out.println("sums : " + sumScore + " sumk : " + sumKcal);
			if(sumKcal <= L && sumScore > max) {
				max = sumScore;
			}
			return ;
		}

		for(int i = start; i < N; i++) {
			dfs(i + 1, cnt + 1, sumScore + ing[i][0], sumKcal + ing[i][1]);
		}
	}
}
