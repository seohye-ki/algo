package boj2810;

import java.util.Scanner;

public class CupHolder {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String seat = sc.next();
		int cnt = 1;
		int couple = 0;
		for(int i = 0; i < seat.length(); i++) {
			if(seat.charAt(i) == 'S')
				cnt++;
			else {
				couple++;
				if(couple == 2) {
					cnt++;
					couple = 0;
				}
			}
		}
		if(N < cnt)
			System.out.println(N);
		else
			System.out.println(cnt);
		sc.close();
	}
}
