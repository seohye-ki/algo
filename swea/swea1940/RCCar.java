package swea1940;

import java.util.Scanner;

public class RCCar {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[] result = new int[T];
		for(int t = 0; t < T; t++) {
			int total = 0;
			int currSpeed = 0;
			int N = sc.nextInt();
			for(int i = 0; i < N; i++) {
				int cmd = sc.nextInt();
				if(cmd == 0) {
					total += currSpeed;
				}
				else if(cmd == 1) {
					int speed = sc.nextInt();
					currSpeed += speed;
					total += currSpeed;
				}
				else {
					int speed = sc.nextInt();
					currSpeed-= speed;
					if(currSpeed < 0)
						currSpeed = 0;
					total += currSpeed;
				}				
			}
			result[t] = total;
		}
		
		for(int i = 0; i < T; i++)
			System.out.println("#" + (i + 1) + " " + result[i]);
		sc.close();
	}
}
