package boj13300;

import java.util.Scanner;

public class RoomManager {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N  = sc.nextInt();
		int max = sc.nextInt();
		int[] girl = new int[6];
		int[] boy = new int[6];
		for(int i = 0; i < N; i++) {
			int gender = sc.nextInt();
			int grade = sc.nextInt();
			if(gender == 0)
				girl[grade - 1] += 1;
			else
				boy[grade - 1] += 1;
		}
		int sum = 0;
		for(int i = 0; i < 6; i++) {
			if(girl[i] != 0) {
				sum += (girl[i] / max);
				if((girl[i] % max) > 0)
					sum++;
			}
			if(boy[i] != 0) {
				sum += (boy[i] / max);
				if((boy[i] % max) > 0)
					sum++;
			}
		}
		System.out.println(sum);
		sc.close();
	}
}
