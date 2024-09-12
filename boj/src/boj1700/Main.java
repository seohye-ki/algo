package boj1700;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	static int[] multi;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); //구멍개수
		int K = sc.nextInt(); //사용횟수
		int cnt = 0; //플러그 빼는 횟수
		
		multi = new int[N]; //멀티탭 배열
		int[] use = new int[K]; //용품 사용 순서
		
		List<Integer>[] loc =  new ArrayList[K]; //각 용품별 사용 순서 저장 리스트
		for(int i = 0; i < K; i++)
			loc[i] = new ArrayList<>();
		
		//input
		for(int i = 0; i < K; i++) {
			use[i] = sc.nextInt();
			loc[use[i] - 1].add(i); //용품별 리스트에 순서 넣기
		}
		
		//플러그 꽂기
		for(int i = 0; i < K; i++) {
			int plug = use[i];
			//이미 꽂혀있으면
			if(contain(plug)) {
				loc[plug - 1].remove(0);
			}
			
			//빈공간이 있다면 꽂기
			else if(isEmpty()) {
				change(0, plug);
				loc[plug - 1].remove(0);
			}
			
			//꽉차있으면 가장 늦게 사용되는 것 뽑고 꽂기
			else {
				int late = out(loc);
				change(multi[late], plug);
				cnt++;
				loc[plug - 1].remove(0);
			}
		}
		System.out.println(cnt);
	}
	
	static int out(List<Integer>[] loc) {
		int idx = -1; //가장 늦게 사용하는 용품의 번호
		int late = -1; //꽂혀있는 플러그 중 가장 첫번째의 다음에 등장하는 시간
		
		for(int i = 0; i < multi.length; i++) {
			int plug = multi[i];
			if(loc[plug - 1].isEmpty())
				return i;
			int nextUse = loc[plug - 1].get(0);
			if(late < nextUse) {
				idx = i;
				late = nextUse;
			}
		}
		return idx;
	}
	
	static boolean isEmpty() {
		for(int i = 0; i < multi.length; i++) {
			if(multi[i] == 0)
				return true;
		}
		return false;
	}
	
	static boolean contain(int num) {
		for(int i = 0; i < multi.length; i++) {
			if(multi[i] == num)
				return true;
		}
		return false;
	}
	
	static void change(int num, int plug) {
		for(int i = 0; i < multi.length; i++) {
			if(multi[i] == num) {
				multi[i] = plug;
				break;
			}
		}
	}
}