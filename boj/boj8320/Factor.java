package boj8320;

import java.util.Scanner;

public class Factor {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		for(int i = 0; i < N; i++) {
			int factors = 0;
			for(int j = 1; j <= N; j++) {
				if((i + 1) % j == 0)
					factors++;
			}
			arr[i] = factors / 2;
			if(factors % 2 != 0)
				arr[i]++;
		}
		int sum = 0;
		for(int n : arr)
			sum += n;
		System.out.println(sum);
		sc.close();
	}
}
