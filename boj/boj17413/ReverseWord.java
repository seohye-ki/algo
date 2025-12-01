package boj17413;

import java.util.Scanner;

public class ReverseWord {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		int i = 0;
		
		while(i < str.length() - 1) {
			//그대로 출력
			if(str.charAt(i) == '<') {
				while(str.charAt(i) != '>') {
					System.out.print(str.charAt(i));
					i++;
				}
				System.out.print(str.charAt(i));
				i++;
			}
			else if(str.charAt(i) == ' ') {
				System.out.print(str.charAt(i));
				i++;
			}
			//뒤집어야 함
			else {
				int start = i;
				while(true) {
					if (i == str.length() || str.charAt(i) == ' ' || str.charAt(i) == '<') {
						break;
					}
					i++;
				}
				for(int idx = i - 1; idx >= start; idx--) {
					System.out.print(str.charAt(idx));
				}
			}
		}
		sc.close();
	}
}
