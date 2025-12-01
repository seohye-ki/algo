package swea2007;

import java.util.Scanner;

public class Pattern {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t = 0; t < T; t++) {
			String str = sc.next();
			for(int i = 1; i <= 10; i++)	{
				int flag = 0;
				int k = i - 1;
				for(int j = 0; j < i; j++) {
					if(str.charAt(k + j) != str.charAt(k + i + j)) {
						flag = 1;
						break;
					}
				}
				if(flag == 0) {
					System.out.println("#" + (t+1) + " " + i);
					break;
				}
			}
		}
		sc.close();
	}
}
