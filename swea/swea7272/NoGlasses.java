package swea7272;

import java.util.Scanner;

public class NoGlasses {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		String[] result = new String[T];
		for(int i = 0; i < T; i++) {
			String str1 = sc.next();
			String str2 = sc.next();
			
			//치환 구멍0 = 0/구멍1 = 1/구멍2 = 2
			int[] str1_change = new int[str1.length()];
			for(int j = 0; j < str1.length(); j++) {
				if(str1.charAt(j) == 'B' )
					str1_change[j] = 2;
				else if(str1.charAt(j) == 'A' || str1.charAt(j) == 'D' || str1.charAt(j) == 'O' ||
						str1.charAt(j) == 'P' || str1.charAt(j) == 'Q' || str1.charAt(j) == 'R')
					str1_change[j] = 1;
				else {
					str1_change[j] = 0;
				}
			}
			int[] str2_change = new int[str2.length()];
			for(int j = 0; j < str2.length(); j++) {
				if(str2.charAt(j) == 'B' )
					str2_change[j] = 2;
				else if(str2.charAt(j) == 'A' || str2.charAt(j) == 'D' || str2.charAt(j) == 'O' ||
						str2.charAt(j) == 'P' || str2.charAt(j) == 'Q' || str2.charAt(j) == 'R')
					str2_change[j] = 1;
				else {
					str2_change[j] = 0;
				}
			}
			
			//유효성 체크 
			int flag = 0;
			if(str1_change.length == str2_change.length) {
				for(int j = 0; j < str1_change.length; j++) {
					if(str1_change[j] != str2_change[j]) {
						flag = 1;
						break;
					}
				}
				if(flag == 1)
					result[i] = "DIFF";
				else
					result[i] = "SAME";
			}
			else
				result[i] = "DIFF";
		}
		for(int i = 0; i < T; i++)
			System.out.println("#" + (i + 1) + " " + result[i]);
		sc.close();
	}
}
