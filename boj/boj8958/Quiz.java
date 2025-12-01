package boj8958;

import java.util.Scanner;

public class Quiz {	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t = 0; t < T; t++) {
			int total = 0;
			int score = 0;
			String answer = sc.next();
			for(int i = 0; i < answer.length(); i++) {
				if(answer.charAt(i) == 'O')
					score++;
				else
					score = 0;
				total += score;
			}
			System.out.println(total);
		}
		sc.close();
	}
}
