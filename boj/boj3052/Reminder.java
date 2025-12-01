package boj3052;

import java.util.Scanner;

public class Reminder {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] reminder = new int[42];
		for(int i = 0; i < 10; i++) {
			int num = sc.nextInt();
			reminder[num % 42]++;
		}
		int cnt = 0;
		for(int i = 0; i < 42; i++) {
			if(reminder[i] != 0)
				cnt++;
		}
		System.out.println(cnt);
		sc.close();
	}
}
