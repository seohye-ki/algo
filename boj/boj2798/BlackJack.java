package boj2798;

import java.util.Scanner;

public class BlackJack {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] card = new int[N];
		for(int i = 0;  i < N; i++)
			card[i] = sc.nextInt();
		int num = 0;
		for(int i = 0; i < N - 2; i++) {
			for(int j = i + 1; j < N - 1; j++) {
				for(int k = j + 1; k < N; k++) {
					int sum = card[i] + card[j] + card[k];
					if(sum <= M && num < sum)
						num = sum;
				}
			}
		}
		System.out.println(num);
		sc.close();
	}
}
