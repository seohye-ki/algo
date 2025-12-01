package swea3499;

import java.util.Scanner;

public class Shuffle {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 0; t < T; t++) {
			int N = sc.nextInt();
			String[] deck = new String[N];
			for(int i = 0; i < N; i++)
				deck[i] = sc.next();
			System.out.print("#" + (t + 1) + " ");
			for(int i = 0; i < N / 2; i++) {
				if(N % 2 == 0) {
					System.out.print(deck[0 + i]+ " ");
					System.out.print(deck[(N / 2) + i]+ " ");					
				}
				else {
					System.out.print(deck[0 + i]+ " ");
					System.out.print(deck[(N / 2) + 1 + i]+ " ");	
				}
			}
			if(N % 2 == 1)
				System.out.println(deck[N / 2]+ " ");
			else
				System.out.println();
		}
		sc.close();
	}
}
