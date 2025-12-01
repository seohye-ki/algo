package boj11399;

import java.util.Scanner;

public class ATM {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//입력 
		int N = sc.nextInt();
		int[] time = new int[N];
		for(int i = 0; i < N; i++)
			time[i] = sc.nextInt();
		
		//선택정렬 
		for(int i = 0; i < N; i++) {
			int minIndex = i;
			for(int j = i + 1; j < N; j++) {
				if(time[j] < time[minIndex])
					minIndex = j;
			}
			//swap
			int tmp;
			tmp = time[i];
			time[i] = time[minIndex];
			time[minIndex] = tmp;				
		}

		//더하기
		int sum = 0;
		for(int i = 0; i < N; i++) {
			int tmp = 0;
			for(int j = 0; j < i + 1; j++)
				tmp += time[j];
			sum += tmp;
		}
		System.out.println(sum);
		sc.close();
	}
}
