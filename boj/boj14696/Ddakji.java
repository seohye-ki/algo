package boj14696;

import java.util.Scanner;

public class Ddakji {	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		for(int i = 0; i < N; i++) {
			int[] user1 = userInput(sc);
			int[] user2 = userInput(sc);
			
			//승부 
			if(user1[0] != user2[0])
				fight(user1[0], user2[0]);
			else if(user1[1] != user2[1])
				fight(user1[1], user2[1]);
			else if(user1[2] != user2[2])
				fight(user1[2], user2[2]);
			else if(user1[3] != user2[3])
				fight(user1[3], user2[3]);
			else
				System.out.println("D");
		}
		sc.close();
	}
		
	public static int[] userInput(Scanner sc) {
		int length = sc.nextInt();
		int[] user = new int[4];
		
		for(int i = 0; i < length; i++) {
			int shape = sc.nextInt();
			if(shape == 4)
				user[0] += 1;
			else if(shape == 3)
				user[1] += 1;
			else if(shape == 2)
				user[2] += 1;
			else
				user[3] += 1;
		}

		return user;
	}
		
	public static void fight(int a, int b) {
		if(a > b)
			System.out.println("A");
		else
			System.out.println("B");
	}
		
}
