package boj2851;

import java.util.Scanner;

public class SuperMario {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] score = new int[10];
		for(int i = 0; i < 10; i++)
			score[i] = sc.nextInt();
		int total = 0;
		for(int i = 0; i < 10; i++) {
			if(total + score[i] <= 100)
				total += score[i];
			else {
				if(Math.abs(100 - total) >= Math.abs(100 - (total + score[i])))
					total += score[i];
				break;
			}
		}
		System.out.println(total);
		sc.close();
	}
}
