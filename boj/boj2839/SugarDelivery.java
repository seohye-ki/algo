package boj2839;

import java.util.Scanner;

public class SugarDelivery {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int kg = sc.nextInt();
		int five = 0;
		int three = 0;
		int flag = 0;
		for(int i = 0; i < kg / 5; i++) {
			five = (kg / 5) - i;
			three = (kg - (five * 5)) / 3;
			if(((five * 5) + (three * 3)) == kg) {
				flag = 1;
				break;
			}
		}
		
		if(flag == 1)
			System.out.println(five + three);
		else {
			if(kg % 3 == 0)
				System.out.println(kg / 3);
			else
				System.out.println(-1);
		}
		sc.close();
	}
}
