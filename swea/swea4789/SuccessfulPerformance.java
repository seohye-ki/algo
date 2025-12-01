package swea4789;

import java.util.Scanner;

public class SuccessfulPerformance {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t = 0;  t < T; t++) {
			String tmp = sc.next();
			int[] stand = new int[tmp.length()];
			for(int i = 0; i < tmp.length(); i++)
				stand[i] = (int)(tmp.charAt(i) - '0');
			
			//계산
			int total = 0;
			int curr = stand[0];
			for(int i = 1; i < tmp.length(); i++) {
				if(stand[i] == 0)
					continue;
				if(curr < i) {
					total += (i - curr);
					curr += ((i - curr) + stand[i]);
				}
				else
					curr += stand[i];
			}
			
			//출력
			System.out.println("#" + (t+1) + " " + total);
		}
		
		sc.close();
	}
}
