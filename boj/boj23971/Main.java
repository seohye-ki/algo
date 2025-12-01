package boj23971;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int H = sc.nextInt();
		int W = sc.nextInt();
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int num1 = 1 + ((W - 1) / (M + 1));
		int cnt = num1 * (1 + ((H - 1) / (N + 1)));

		System.out.println(cnt);
		sc.close();
	}
}
