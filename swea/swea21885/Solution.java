package swea21885;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {
	static int N; //전체 수
	static int minCnt; //최대학생 수
	static int maxCnt; //최소학생 수
	static int[] student; //점수 배열
	static List<Integer> list; //중복값없는 점수
	static int[] score; //점수 기준 2개
	static int result; //결과값(최대인원과 최소인원의 차)
	static int flag; //만족하는 결과가 있는지 없는지(하나라도 있으면 1)
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); //테스트케이스 수
		for(int test_case = 1; test_case <= T; test_case++) {
			N  = sc.nextInt(); //학생수
			minCnt = sc.nextInt(); //최소인원
			maxCnt = sc.nextInt(); //최대인원
			student = new int[N]; //점수
			for(int i = 0;  i < N; i++)
				student[i] = sc.nextInt();
			list = new ArrayList<>();
			for(int i = 0; i < N; i++) {
				if(list.contains(student[i]) == false)
					list.add(student[i]);
			}
			Collections.sort(list);
			//모든 점수 조합별로 max, min구하기
			flag = 0;
			result = 2147483647;
			score = new int[2];
			dfs(0, 0);
			if(flag == 1)
				System.out.println("#" + test_case + " " + result);
			else
				System.out.println("#" + test_case + " -1");
		}
		sc.close();
	}
	
	static void dfs(int start, int cnt) {
		if(cnt == 2) {
//			System.out.println(Arrays.toString(score));
			int[] classroom = new int[3];
			//학생 반별로 나누기
			for(int i = 0; i < N; i++) {
				if(student[i] < score[0])
					classroom[0]++;
				else if(student[i] < score[1])
					classroom[1]++;
				else
					classroom[2]++;
			}
			
//			System.out.println(Arrays.toString(classroom));
			
			//max랑 min값 찾기
			int max = classroom[0];
			int min = classroom[0];
			for(int i = 0; i < 3; i++) {
				if(max < classroom[i])
					max = classroom[i];
				if(classroom[i] < min)
					min = classroom[i];
			}
			
//			System.out.println("min: " + min + " max: " + max);
			//valid check
			if(minCnt <= min && max <= maxCnt)
				flag = 1;
			
			//차가 최소인지 확인
			if(Math.abs(max - min) < result)
				result = Math.abs(max - min);
			return ;
		}
		
		for(int i = start; i < list.size(); i++) {
			score[cnt] = list.get(i);
			dfs(i + 1, cnt + 1);
		}
	}
}
