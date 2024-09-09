package boj14888;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;
	static int[] numArr;
	static int[] opArr;
	static boolean[] visited;
	static int N;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); //숫자 개수
		
		//숫자배열
		numArr = new int[N];
		for(int i = 0; i < N; i++) {
			numArr[i] = sc.nextInt();
		}
		
		//연산자 개수
		int[] operators = new int[4];
		for(int i = 0; i < 4; i++) {
			operators[i] = sc.nextInt();
		}
		
		//연산자 char로 넣기
		int idx = 0;
		opArr = new int[N - 1];
		for(int i = 0; i < 4; i++) {
			while(operators[i] != 0) {
				opArr[idx++] = i;
				operators[i]--;
			}
		}
		
		visited = new boolean[N];
		comb(1, numArr[0]);
		System.out.println(max);
		System.out.println(min);
	}
	
	static void comb(int cnt, int total) {
		if(cnt == N) {
			min = Math.min(min, total);
			max = Math.max(max, total);
			return;
		}
		
		for(int i = 0; i < N - 1; i++) {
			if(visited[i] == false) {
				visited[i] = true;
				comb(cnt + 1, cal(total, numArr[cnt], opArr[i]));
				visited[i] = false;
			}
		}
	}
	
	static int cal(int num1, int num2, int i) {
		if(i == 0)
			return num1 + num2;
		else if(i == 1)
			return num1 - num2;
		else if(i == 2)
			return num1 * num2;
		else
			return num1 / num2;
	}
}
